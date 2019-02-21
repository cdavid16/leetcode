Create table  Employee (Id int, Name varchar(255), Salary int, DepartmentId int);
Create table  Department (Id int, Name varchar(255));
Truncate table Employee;
insert into Employee (Id, Name, Salary, DepartmentId) values ('1', 'Joe', '70000', '1');
insert into Employee (Id, Name, Salary, DepartmentId) values ('2', 'Henry', '80000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('3', 'Sam', '60000', '2');
insert into Employee (Id, Name, Salary, DepartmentId) values ('4', 'Max', '90000', '1');
Truncate table Department;
insert into Department (Id, Name) values ('1', 'IT');
insert into Department (Id, Name) values ('2', 'Sales');

/* Write your PL/SQL query statement below */
SELECT Department.Name Department, Employee.Name Employee, Employee.salary
FROM 
Department 
INNER JOIN 
Employee ON Department.Id = Employee.DepartmentId
WHERE (Employee.Salary, DepartmentId) IN 
(SELECT MAX(SALARY), DepartmentId FROM Employee GROUP BY DepartmentId) 
;
