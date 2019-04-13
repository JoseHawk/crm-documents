package com.joselara.crmdocuments.controllers;

import com.joselara.crmdocuments.models.Document;
import com.joselara.crmdocuments.models.enums.DocumentType;
import com.joselara.crmdocuments.services.DocumentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping(path = "/document", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file,
                                                 @RequestParam("externalId") UUID externalId,
                                                 @RequestParam("type") DocumentType documentType) {

        return ResponseEntity.ok(documentService.uploadDocument(file, externalId, documentType));
    }

    @GetMapping(path = "/document/{documentId}", consumes = "application/json")
    public ResponseEntity<Document> getDocument(@PathVariable("documentId") final UUID documentId) throws NotFoundException {

        return ResponseEntity.ok(documentService.getDocument(documentId));
    }

    @GetMapping(path = "/documents", consumes = "application/json")
    public ResponseEntity<List<Document>> getDocuments() {

        return ResponseEntity.ok(documentService.getAllDocuments());
    }
}
