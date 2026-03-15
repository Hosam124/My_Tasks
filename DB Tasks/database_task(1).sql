-- Hi this is the answer of the task, I want to inform you that I use mysql instead of oracle database,
-- so if you find any differant in syntax do not worry 


-- create table Manger contain
-- id, name , age , birth_date , address

create table manager(
	manager_id int primary key auto_increment,
    manager_name varchar(50) not null,
    manager_birth_date date ,
    address varchar(100)
);
-- ----------------------------------
-- alter table manger drop address column

alter table manager
drop column address;

-- alter table manger add column (city_address, street)
 
alter table manager
add column city_address varchar(100),
add column street varchar(50);
-- -------------------------------------
-- modify column name to full_name

alter table manager
rename column manager_name to full_name;

-- -------------------------------------

-- make this table just for read

CREATE TRIGGER block_insert
BEFORE INSERT ON manager
FOR EACH ROW
SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Table is read-only. INSERT not allowed.';

CREATE TRIGGER block_update
BEFORE UPDATE ON manager
FOR EACH ROW
SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Table is read-only. UPDATE not allowed.';

CREATE TRIGGER block_delete
BEFORE DELETE ON manager
FOR EACH ROW
SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Table is read-only. DELETE not allowed.';

-- Note !!!!! Here I am forced to use triggers as "read only did not work in my 'mysql version'"  
-- soooo .. I hope this is a satisfactory answer to the question.  have a nice day :) 


-- -------------------------------
-- create table same as  Manger with name Owner
-- just has colum id, name, birth_date 

create table owner(
	owner_id int  primary key auto_increment,
    owner_name varchar(50) not null,
    owner_birth_date date 
);

-- ----------------------------------------
-- rename manger table name to Master

rename table owner to master ;

-- -----------------------------------------
-- drop all tables   
  
  drop table manager;
  drop table master;
  
