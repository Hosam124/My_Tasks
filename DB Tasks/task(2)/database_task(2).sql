-- create Employees table wiith column ( EmployeeID, FirstName, LastName, Department, Salary )

create table employees(
	employee_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    department varchar(50),
    salary decimal(10,2),
    
    constraint chk_employees_salary
    check (salary>0)
);

alter table employees 
auto_increment =101;

-- ----------------------------------------------------------------
-- Insert a new record into the Employees table.

-- EmployeeID     FirstName   LastName  Department      Salary
-- 101            'John1'      'Doe1'     'HR'            20000
-- 102            'John2'      'Doe2'     'IT'            50000
-- 103            'John3'      'Doe3'     'CS'            40000
-- 104            'John4'      'Doe4'     'IT'            10000
-- 105            'John5'      'Doe5'     'ZX'            30000


insert into employees (employee_id, first_name, last_name, department, salary) values
(101, 'John1', 'Doe1', 'HR', 20000),
(102, 'John2', 'Doe2', 'IT', 50000),
(103, 'John3', 'Doe3', 'CS', 40000),
(104, 'John4', 'Doe4', 'IT', 10000),
(105, 'John5', 'Doe5', 'ZX', 30000);


-- -----------------------------------------------------------------------------------------
-- Update the salary of an employee to 600000 with EmployeeID     101.

update employees
set salary = 600000
where employee_id = 101;


-- -----------------------------------------------------------------
-- Delete a record of an employee who Department = 101.

-- I solve it based on employee_id  as '101' did not match the department record data type :)

delete from employees
where employee_id = 101;

-- ----------------------------------------------------------------
-- Retrieve all employees in the IT department.

select * 
from employees
where department = 'IT';

-- ---------------------------------------------------------------
-- select * data from table but conatination  FirstName, LastName as one column

select employee_id, concat( first_name," " , last_name) as full_name, department, salary
from employees 


-- -----------------------------------------------------------------------------------