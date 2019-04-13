package com.joselara.crmdocuments.services;

import com.joselara.crmdocuments.models.Document;
import com.joselara.crmdocuments.models.enums.DocumentType;
import com.joselara.crmdocuments.repositories.DocumentRepository;
import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentServiceIntegrationTest {

    @Autowired
    private DocumentService cut;

    @Autowired
    private DocumentRepository documentRepository;

    @Test
    public void testUploadDocument() {
        MultipartFile multipartFile = new MockMultipartFile("testFile", new byte[1]);
        UUID externalId = UUID.randomUUID();
        DocumentType documentType = DocumentType.PICTURE;

        String expectedPath = cut.uploadDocument(multipartFile, externalId, documentType);

        List<Document> documentList = cut.getAllDocuments();

        assertEquals(documentList.size(),1);
        assertEquals(documentList.get(0).getPath(), expectedPath);

        documentRepository.delete(documentList.get(0));

        assertEquals(documentRepository.findAll().size(), 0);
    }

}
