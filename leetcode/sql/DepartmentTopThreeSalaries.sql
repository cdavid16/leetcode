Create table Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

/* Write your PL/SQL query statement below */
SELECT Department.Name Department, Emp.Employee, Emp.Salary
FROM
Department 
NATURAL JOIN
(
select Name Employee, DepartmentId Id, Salary, Dense_Rank() OVER(PARTITION BY DepartmentId ORDER BY SALARY DESC) Ranking
from Employee
) Emp
WHERE Emp.Ranking <= 3
ORDER BY Department.Name Asc
;
