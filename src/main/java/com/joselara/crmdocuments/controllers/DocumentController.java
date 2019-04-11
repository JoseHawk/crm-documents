package com.joselara.crmdocuments.controllers;

import com.joselara.crmdocuments.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping(path = "/document/{documentType}", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file, @PathVariable("documentType") final String documentType) {

        return ResponseEntity.ok(documentService.uploadDocument(file, documentType));
    }

    @GetMapping(path = "/document/{documentType}/me", consumes = "application/json")
    public ResponseEntity<String> getDocument(@PathVariable("documentType") final String documentType) {

        return ResponseEntity.ok("Test");
    }
}
