Create table Employee (Id int, Salary int);
Truncate table Employee;
insert into Employee (Id, Salary) values ('1', '100');
insert into Employee (Id, Salary) values ('2', '200');
insert into Employee (Id, Salary) values ('3', '300');

SELECT MAX(Salary) "SecondHighestSalary"
FROM Employee 
WHERE SALARY < (SELECT MAX(Salary) FROM Employee);
