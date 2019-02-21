Create table Customers (Id int, Name varchar(255));
Create table Orders (Id int, CustomerId int);
Truncate table Customers;
insert into Customers (Id, Name) values ('1', 'Joe');
insert into Customers (Id, Name) values ('2', 'Henry');
insert into Customers (Id, Name) values ('3', 'Sam');
insert into Customers (Id, Name) values ('4', 'Max');
Truncate table Orders;
insert into Orders (Id, CustomerId) values ('1', '3');
insert into Orders (Id, CustomerId) values ('2', '1');

/* Write your PL/SQL query statement below */
SELECT Name Customers
FROM Customers
WHERE Id NOT IN (SELECT CustomerId FROM Orders);
