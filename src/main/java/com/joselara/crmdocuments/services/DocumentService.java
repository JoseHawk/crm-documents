package com.joselara.crmdocuments.services;

import com.joselara.crmdocuments.models.Document;
import com.joselara.crmdocuments.models.enums.DocumentType;
import com.joselara.crmdocuments.repositories.DocumentRepository;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class DocumentService {

    @Value("${upload.directory}")
    private String directory;

    private static final Logger LOG = LogManager.getLogger(DocumentService.class);

    @Autowired
    private DocumentRepository documentRepository;

    public String uploadDocument(MultipartFile multipartFile, String type) {

        LOG.trace("Recovering the document type");
        DocumentType documentType = DocumentType.valueOf(type.toUpperCase());

        LOG.trace("Getting file extension");
        String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

        LOG.trace("Obtaining the destination directory");
        String pathName = directory + type + UUID.randomUUID() + "." + extension;

        LOG.trace("Saving document in directory");
        saveDocumentInDirectory(multipartFile, pathName);

        LOG.trace("Creating document entity");
        Document document = Document.builder()
                .documentId(UUID.randomUUID())
                .type(documentType)
                .path(pathName)
                .build();

        LOG.trace("Saving in database");
        documentRepository.save(document);

        LOG.trace("Returning the path");
        return pathName;
    }

    private void saveDocumentInDirectory(MultipartFile multipartFile, String pathName) {
        try {
            LOG.trace("Creating directory if does not exist");
            new File(directory).mkdirs();

            LOG.trace("Uploading the file");
            File file = new File(pathName);
            multipartFile.transferTo(file);
        } catch (IOException exception) {
            LOG.error(exception.getMessage());
        }
    }
}
