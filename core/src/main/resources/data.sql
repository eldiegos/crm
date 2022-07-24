
INSERT INTO contact (id, name, first_name, surname1, surname2, created_at, modified_at) 
VALUES (RANDOM_UUID(), 'John Smith', 'John', 'Smith', 'Matrix',  CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


INSERT INTO account (id, name, legal_name, vat, created_at, modified_at)
VALUES (RANDOM_UUID(), 'Universidad Loyola', 'Fundación Universidad Loyola Andalucía', 'ESG14894158', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO country (id, name, cod2, cod3, country_number, eees, sepa, created_at, modified_at)
VALUES (RANDOM_UUID(), 'Spain', 'ES', 'ESP', 724, 1, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO country (id, name, cod2, cod3, country_number, eees, sepa, created_at, modified_at)
VALUES (RANDOM_UUID(), 'Frace', 'FR', 'FRA', 250, 1, 1, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO language (id, name, cod, created_at, modified_at)
VALUES (RANDOM_UUID(), 'French', 'FR', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO language (id, name, cod, created_at, modified_at)
VALUES (RANDOM_UUID(), 'Spanish', 'ES', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());


INSERT INTO currency (id, name, cod, currency_number, created_at, modified_at)
VALUES (RANDOM_UUID(), 'Euro', 'EUR', 978 ,  CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO currency (id, name, cod, currency_number, created_at, modified_at)
VALUES (RANDOM_UUID(), 'US Dollar', 'USD', 840 ,  CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

