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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@ActiveProfiles("test")
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

        assertEquals(1, documentList.size());
        assertEquals(expectedPath, documentList.get(0).getPath());

        documentRepository.delete(documentList.get(0));

        assertEquals(0, documentRepository.findAll().size());
    }
}
