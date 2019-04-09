package com.joselara.crmdocuments.models.dto;

import com.joselara.crmdocuments.models.enums.DocumentType;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class DocumentDTO {

    private UUID documentId;
    private UUID externalId;
    private DocumentType type;
    private String path;
}
