Create table Weather (Id int, RecordDate date, Temperature int);
Truncate table Weather;
insert into Weather (Id, RecordDate, Temperature) values ('1', '2015-01-01', '10');
insert into Weather (Id, RecordDate, Temperature) values ('2', '2015-01-02', '25');
insert into Weather (Id, RecordDate, Temperature) values ('3', '2015-01-03', '20');
insert into Weather (Id, RecordDate, Temperature) values ('4', '2015-01-04', '30');

/* Write your PL/SQL query statement below */
SELECT Id
FROM 
(
SELECT Id, CASE WHEN LAG(Temperature) OVER(ORDER BY RecordDate) < Temperature
        AND LAG(RecordDate)OVER(ORDER BY RecordDate)+1 = RecordDate  THEN 1 else 0 End Raised
FROM Weather
)
WHERE Raised = 1
;
