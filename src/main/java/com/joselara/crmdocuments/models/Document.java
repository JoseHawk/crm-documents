package com.joselara.crmdocuments.models;

import com.joselara.crmdocuments.models.enums.DocumentType;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Data
@Builder
public class Document {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    private UUID documentId;

    @NotNull
    @Column(columnDefinition = "BINARY(16)")
    private UUID externalId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DocumentType type;

    @NotNull
    private String path;

    @Tolerate
    public Document() {}
}
