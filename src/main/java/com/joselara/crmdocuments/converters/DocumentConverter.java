package com.joselara.crmdocuments.converters;

import com.joselara.crmdocuments.models.Document;
import com.joselara.crmdocuments.models.dto.DocumentDTO;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class DocumentConverter extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {

        factory.classMap(DocumentDTO.class, Document.class)
                .field("documentId", "documentId")
                .field("externalId", "externalId")
                .field("type", "type")
                .field("path", "path")
                .byDefault()
                .register();
    }
}
