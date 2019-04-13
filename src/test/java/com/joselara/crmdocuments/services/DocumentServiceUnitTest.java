package com.joselara.crmdocuments.services;

import com.joselara.crmdocuments.converters.DocumentConverter;
import com.joselara.crmdocuments.models.Document;
import com.joselara.crmdocuments.models.enums.DocumentType;
import com.joselara.crmdocuments.repositories.DocumentRepository;
import javassist.NotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceUnitTest {

    @InjectMocks
    private DocumentService cut;

    @Mock
    private DocumentRepository documentRepository;

    private Document document;

    @Before
    public void setUp() {
        document = new Document();
        document.setDocumentId(UUID.randomUUID());
        document.setExternalId(UUID.randomUUID());
        document.setType(DocumentType.PICTURE);
        document.setPath("testPath");
    }

    @Test
    public void getDocumentSuccess() throws NotFoundException {
        when(documentRepository.findById(document.getDocumentId())).thenReturn(Optional.of(document));

        Document actualDocument = cut.getDocument(document.getDocumentId());

        assertEquals(document, actualDocument);
    }

    @Test(expected = NotFoundException.class)
    public void getDocumentFails() throws NotFoundException {
        when(documentRepository.findById(any())).thenReturn(Optional.empty());

        cut.getDocument(UUID.randomUUID());
    }

    @Test
    public void getAllDocumentsSuccess() {
        when(documentRepository.findAll()).thenReturn(List.of(document));

        List<Document> actualDocumentList = cut.getAllDocuments();

        assertEquals(document, actualDocumentList.get(0));
        assertEquals(1, actualDocumentList.size());
    }
}
