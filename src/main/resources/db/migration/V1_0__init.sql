CREATE TABLE document
(
    document_id BINARY(16) NOT NULL PRIMARY KEY,
    external_id BINARY(16) NOT NULL,
    type VARCHAR(50) NOT NULL,
    path VARCHAR(255)
);