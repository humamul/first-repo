+-------+----------+-------------+---------+-----------+------------+--------+--------+
| empid | empfname | dept        | project | address   | dob        | gender | salary |
+-------+----------+-------------+---------+-----------+------------+--------+--------+
|     1 | sanjay   | HR          | P1      | Hyderabad | 1976-12-01 | m      |  50000 |
|     2 | ananya   | admin       | P2      | delhi     | 1968-05-19 | f      |  75000 |
|     3 | rohan    | account     | P1      | mumbai    | 1980-01-01 | m      |  90000 |
|     4 | sonia    | hr          | P3      | hyderabad | 1992-05-19 | f      |  50000 |
|     5 | priya    | development | P2      | bangalore | 1992-02-23 | f      | 100000 |
+-------+----------+-------------+---------+-----------+------------+--------+--------+
5 rows in set (0.00 sec)

mysql> select * from emp where empfname regexp "[aeiou]$";  //////////ending with vowel
+-------+----------+-------------+---------+-----------+------------+--------+--------+
| empid | empfname | dept        | project | address   | dob        | gender | salary |
+-------+----------+-------------+---------+-----------+------------+--------+--------+
|     2 | ananya   | admin       | P2      | delhi     | 1968-05-19 | f      |  75000 |
|     4 | sonia    | hr          | P3      | hyderabad | 1992-05-19 | f      |  50000 |
|     5 | priya    | development | P2      | bangalore | 1992-02-23 | f      | 100000 |
+-------+----------+-------------+---------+-----------+------------+--------+--------+
3 rows in set (0.00 sec)

mysql> select * from emp where empfname regexp "^[aeiou]";   ///// Starting with vowel
+-------+----------+-------+---------+---------+------------+--------+--------+
| empid | empfname | dept  | project | address | dob        | gender | salary |
+-------+----------+-------+---------+---------+------------+--------+--------+
|     2 | ananya   | admin | P2      | delhi   | 1968-05-19 | f      |  75000 |
+-------+----------+-------+---------+---------+------------+--------+--------+
1 row in set (0.00 sec)

mysql> select * from emp where empfname regexp "^[aeiou].*[aeiou]$"; ////starting and ending with vowel 
