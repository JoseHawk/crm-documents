package com.joselara.crmdocuments.controllers;

import com.joselara.crmdocuments.services.DocumentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

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
        when(documentService.uploadDocument(any(), any())).thenReturn(testPath);

        String actualPath = cut.uploadDocument(multipartFile, "testPath").getBody();

        assertEquals(testPath, actualPath);
    }
}
