CREATE TABLE document
(
    document_id UUID NOT NULL PRIMARY KEY,
    external_id UUID NOT NULL ,
    type VARCHAR(50) NOT NULL,
    path VARCHAR(255)
);