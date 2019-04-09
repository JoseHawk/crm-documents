package com.joselara.crmdocuments.models;

import com.joselara.crmdocuments.models.enums.DocumentType;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@Builder
public class Document {

    @Id
    @GeneratedValue
    private UUID documentId;

    private UUID externalId;

    private DocumentType type;

    private String path;

    @Tolerate
    public Document() {}
}
