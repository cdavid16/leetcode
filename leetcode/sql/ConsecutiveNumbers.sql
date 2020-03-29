Create table Logs (Id int, Num int);
Truncate table Logs;
insert into Logs (Id, Num) values ('1', '1');
insert into Logs (Id, Num) values ('2', '1');
insert into Logs (Id, Num) values ('3', '1');
insert into Logs (Id, Num) values ('4', '2');
insert into Logs (Id, Num) values ('5', '1');
insert into Logs (Id, Num) values ('6', '2');
insert into Logs (Id, Num) values ('7', '2');

/* Write your PL/SQL query statement below */
SELECT DISTINCT Num ConsecutiveNums 
FROM 
(
SELECT Id, Num, CASE WHEN Num = Lead(Num) OVER(ORDER BY ID) and Num = Lead(Num, 2) OVER(ORDER BY ID) THEN 1 ELSE 0 END IsValid
FROM Logs
)
WHERE IsValid = 1;
