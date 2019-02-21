CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
BEGIN
    /* Write your PL/SQL query statement below */
    SELECT SALARY 
    INTO result 
    FROM
    (
        select Salary, rank() OVER (ORDER BY SALARY DESC) row_num
        from
        (
            SELECT distinct Salary
            FROM Employee
        )
    )
    WHERE row_num = n;
    
    RETURN result;
END;
