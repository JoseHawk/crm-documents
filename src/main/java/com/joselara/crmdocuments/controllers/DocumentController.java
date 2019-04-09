package com.joselara.crmdocuments.controllers;

import com.joselara.crmdocuments.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping(path = "/document/{documentType}", consumes = "multipart/form-data")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file, @PathVariable("documentType") String documentType) {

        return ResponseEntity.ok(documentService.uploadDocument(file, documentType));
    }
}
