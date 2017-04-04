question link: https://www.hackerrank.com/challenges/what-type-of-triangle
select  
    (CASE 
        WHEN a=b and a=c THEN 'Equilateral'
        WHEN (a=b or a=c or b=c) and(a+b > c and a+c> b and b+c> a) THEN 'Isosceles' 
        WHEN a+b > c and a+c> b and b+c> a THEN 'Scalene'
        ELSE "Not A Triangle"
    END) AS tType
 from TRIANGLES 