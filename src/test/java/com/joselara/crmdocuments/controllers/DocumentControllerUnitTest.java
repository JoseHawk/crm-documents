package com.joselara.crmdocuments.controllers;

import com.joselara.crmdocuments.models.Document;
import com.joselara.crmdocuments.models.enums.DocumentType;
import com.joselara.crmdocuments.services.DocumentService;
import javassist.NotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocumentControllerUnitTest {

    @InjectMocks
    private DocumentController cut;

    @Mock
    private DocumentService documentService;

    @Mock
    private MultipartFile multipartFile;

    @Test
    public void uploadDocumentTest() {
        String testPath = "testPath";
        when(documentService.uploadDocument(any(), any(), any())).thenReturn(testPath);

        String actualPath = cut.uploadDocument(multipartFile, UUID.randomUUID(), DocumentType.PICTURE).getBody();

        assertEquals(testPath, actualPath);
    }

    @Test
    public void getDocumentTest() throws NotFoundException {
        Document document = Document.builder()
                .documentId(UUID.randomUUID())
                .externalId(UUID.randomUUID())
                .type(DocumentType.PICTURE)
                .path("tesPath")
                .build();
        when(documentService.getDocument(document.getDocumentId())).thenReturn(document);

        ResponseEntity<Document> actualDocument = cut.getDocument(document.getDocumentId());

        assertEquals(actualDocument.getBody(), document);
    }

    @Test
    public void getAllDocumentsTest() {
        List<Document> documentList = List.of(new Document(), new Document());
        when(documentService.getAllDocuments()).thenReturn(documentList);

        ResponseEntity<List<Document>> actualDocumentList = cut.getDocuments();

        assertEquals(documentList, actualDocumentList.getBody());
        assertEquals(2, actualDocumentList.getBody().size());
    }
}
