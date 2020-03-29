# Write your MySQL query statement below
DELETE P
FROM Person P INNER JOIN Person P2 ON P.Id > P2.Id AND P.email = P2.email;
