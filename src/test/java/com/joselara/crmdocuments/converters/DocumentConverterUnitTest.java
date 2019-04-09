package com.joselara.crmdocuments.converters;

import com.joselara.crmdocuments.models.Document;
import com.joselara.crmdocuments.models.dto.DocumentDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class DocumentConverterUnitTest {

    @InjectMocks
    private DocumentConverter cut;

    @Test
    public void mapTest() {
        DocumentDTO documentDTO = DocumentDTO.builder()
                .documentId(UUID.randomUUID())
                .path("testPath")
                .build();

        Document document = cut.map(documentDTO, Document.class);

        assertEquals(document.getDocumentId(), documentDTO.getDocumentId());
    }
}