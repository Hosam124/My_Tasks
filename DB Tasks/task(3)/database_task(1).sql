-- 1. Find all employee where the emp_id is within a certain range  100  and  105.
select *
from employees
where employee_id between 100 and 105 ;
-- 2. Find all employee that belong to a specific set of emp_id  151 , 152, 153, 154 , 155.
select *
from employees
where employee_id in (151,152,153,154,155);
-- 3. Retrieve all employee where the employee first_name starts with the letter 'P' OR 'p'
select *
from employees
where first_name like "p%" or first_name like "P%";
-- 4. Retrieve all employee where the employee first_name end with the letter 'A' OR 'a'
select *
from employees
where first_name like "%A" or first_name like "%a";
-- 5. Retrieve all employee where the employee first_name with the letter 'A' OR 'a'
select *
from employees
where first_name like "%A%" or first_name like "%a%";
-- 6. Retrieve all employee where the employee first_name  third char with the letter 'e' OR 'E'
select *
from employees
where first_name like "__E%" or first_name like "__e%";
-- 7. Retrieve all employees who don't have a manager assigned (i.e., manager_id is NULL).
select *
from employees
where manager_id is null;
-- 8. Find all employees who have a manager assigned.
select *
from employees
where manager_id is not null;
-- 9. Insert a new employee without assigning a manager (NULL value for manager_id).
insert into employees(employee_id,first_name, last_name, email, phone_number, hire_date,job_id, salary, commission_pct,department_id)
values(
          209,"Hossam","Elleithy","hossamelleithy","010.182.87310","2026-06-1","AD_VP",35000.00,0.20,100
      );
-- 10. Find all employees who work either in the 'AD_VP' JOB_ID or the 'IT_PROG' JOB_ID.
select *
from employees
where job_id in ("AD_VP","IT_PROG");

select *
from employees
where job_id = "AD_VP" OR job_id="IT_PROG";
-- 11. Retrieve all employees sorted by their last_name in ascending order.
select *
from employees
order by last_name desc;
-- 12. Retrieve all employees sorted by their hire_date in descending order.
select *
from employees
order by hire_date desc;
-- 13. Sort employees first by department in ascending order and then by salary in descending order within each department_id.
select *
from employees
order by department_id asc , salary desc;
-- 14. Retrieve all employees with their last_name in lowercase
select lower(last_name)
from employees;
-- 15. Retrieve all employees with their first_name in uppercase.
select upper(first_name)
from employees;
-- 16. Retrieve all employees with their first_name and last_name in title case (first letter capitalized).
select
    concat(
            upper(substring(first_name, 1, 1)),
            LOWER(substring(first_name, 2)),
            ' ',
            upper(substring(last_name, 1, 1)),
            lower(substring(last_name, 2))
    ) as full_name
from employees;
-- 17. Find employees whose last_name is 'smith', regardless of the case.
select *
from employees
where lower(last_name) = 'smith';