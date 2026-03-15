-- create table Doctor contain

-- id, name , salary , address

create table doctor(
	doctor_id int primary key auto_increment,
    doctor_name varchar(50) not null,
    salary decimal(10,2),
    address varchar(100),
    
    constraint chk_salary
    check (salary>0)
);

-- ----------------------------------
-- please insert 10 row with Data as you like 

insert into doctor (doctor_name, salary, address) values
('Ahmed Hassan', 15000.00, '12 Tahrir Square, Cairo'),
('Sara Mohamed', 22000.50, '45 Corniche Street, Alexandria'),
('Omar Khaled', 18500.75, '8 Nile Road, Giza'),
('Nour Ibrahim', 31000.00, '33 El Haram Street, Giza'),
('Youssef Ali', 27500.25, '17 Ramses Avenue, Cairo'),
('Fatma Mostafa', 19800.00, '5 Port Said Street, Suez'),
('Karim Adel', 24000.00, '22 El Geish Road, Alexandria'),
('Dina Tarek', 35000.50, '9 Smart Village, 6th October'),
('Mahmoud Samir', 16750.00, '14 Abbas El Akkad, Cairo'),
('Laila Nasser', 29000.75, '3 New Cairo Boulevard, Cairo');

-- -----------------------------------------
-- update record number 3 with salary 20000

update doctor
set salary = 2000
where doctor_id = 3;

select * from doctor;
-- ----------------------------------
-- delete record number 9

delete from doctor
where doctor_id = 9;

-- -----------------------------------------
--  please Concatenation all name with salary  of all rows

select doctor_id,concat(doctor_name," earns ",salary) as doctor_income , address
from doctor;

-- ----------------------------------
-- display all record with salary * 2

select doctor_id,doctor_name, 2*salary as double_salary , address
from doctor;

-- -----------------------------------------
--  select all data with salary  1000 , 2000 , 3000 

select * 
from doctor
where salary in (1000,2000,3000);

-- ----------------------------------
-- rename table Doctor to PRD_DOCTOR

rename table doctor to PRD_DOCTOR

-- -----------------------------------------
  