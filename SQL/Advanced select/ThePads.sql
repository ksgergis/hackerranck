question link https://www.hackerrank.com/challenges/the-pads
/*
Enter your query here.
*/
SELECT CONCAT(name,'(',SUBSTR(occupation,1,1),')') from occupations  ORDER BY name;
SELECT CONCAT('There are total ', count(*), ' ',lower(occupation), IF(count(*) >1,'s',''),'.') from occupations group by occupation order by count(*),occupation