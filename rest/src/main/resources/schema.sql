drop table if exists contact;
drop table if exists account;
drop table if exists country;
 
CREATE TABLE contact (

  id UUID PRIMARY KEY,
  name VARCHAR(100) NOT NULL,

  first_name VARCHAR(50) ,
  surname1 VARCHAR(50) ,
  surname2 VARCHAR(50) ,
  
  created_at TIME,
  modified_at TIME

);
 

 CREATE TABLE account (

  id UUID PRIMARY KEY,
  name VARCHAR(100) NOT NULL,

  legal_name VARCHAR(150) ,
  vat VARCHAR(50) ,
  
  created_at TIME,
  modified_at TIME

);

 CREATE TABLE country (

  id UUID PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  
  cod2 CHAR(2) NOT NULL,
  cod3 CHAR(3) NOT NULL, 
  
  country_number SMALLINT NOT NULL,
  eees BOOLEAN NOT NULL,
  sepa BOOLEAN NOT NULL,
  
  
  created_at TIME,
  modified_at TIME

);
ALTER TABLE "country" ADD CONSTRAINT cod2_unique UNIQUE ( cod2 );
ALTER TABLE "country" ADD CONSTRAINT cod3_unique UNIQUE ( cod2 );
ALTER TABLE "country" ADD CONSTRAINT codnumber_unique UNIQUE ( country_number );
ALTER TABLE "country" ADD CONSTRAINT name_unique UNIQUE ( name );
