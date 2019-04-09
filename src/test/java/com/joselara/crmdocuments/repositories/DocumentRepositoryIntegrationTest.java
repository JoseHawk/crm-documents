package com.joselara.crmdocuments.repositories;

import com.joselara.crmdocuments.models.Document;
import com.joselara.crmdocuments.models.enums.DocumentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DocumentRepositoryIntegrationTest {

    @Autowired
    private DocumentRepository cut;

    @Test
    public void testSaveAndDeleteDocument() {
        Document document = new Document();
        document.setExternalId(UUID.randomUUID());
        document.setType(DocumentType.PICTURE);
        document.setPath("testPath");

        cut.save(document);

        Document retrievedDocument = cut.findAll().get(0);
        assertEquals(document, retrievedDocument);

        cut.delete(document);

        assertEquals(0, cut.findAll().size());
    }
}
