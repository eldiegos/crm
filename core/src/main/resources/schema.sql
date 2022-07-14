drop table if exists contact;
 
CREATE TABLE contact (

  id UUID PRIMARY KEY,
  name VARCHAR(100) NOT NULL,

  first_name VARCHAR(50) ,
  surname1 VARCHAR(50) ,
  surname2 VARCHAR(50) ,
  
  created_at TIME,
  modified_at TIME

    
	
);
 
