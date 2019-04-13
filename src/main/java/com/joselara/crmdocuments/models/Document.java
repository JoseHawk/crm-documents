package com.joselara.crmdocuments.models;

import com.joselara.crmdocuments.models.enums.DocumentType;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Builder
public class Document {

    @Id
    @GeneratedValue
    private UUID documentId;

    @NotNull
    private UUID externalId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @NotNull
    private String path;

    @Tolerate
    public Document() {}
}
