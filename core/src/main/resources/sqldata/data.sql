
INSERT INTO contact (id, name, first_name, surname1, surname2, created_at, modified_at) 
VALUES (RANDOM_UUID(), 'John Smith', 'John', 'Smith', 'Matrix',  CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


INSERT INTO account (id, name, legal_name, vat, created_at, modified_at)
VALUES (RANDOM_UUID(), 'Universidad Loyola', 'Fundación Universidad Loyola Andalucía', 'ESG14894158', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

