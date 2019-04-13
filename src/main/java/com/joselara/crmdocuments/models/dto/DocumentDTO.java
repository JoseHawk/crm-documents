package com.joselara.crmdocuments.models.dto;

import com.joselara.crmdocuments.models.enums.DocumentType;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@Builder
public class DocumentDTO {

    @NotNull
    private UUID externalId;
    @NotNull
    private DocumentType type;
    private String path;

    @Tolerate
    public DocumentDTO() { }
}
