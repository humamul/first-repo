
mysql> select * from emp;
+----+-------+--------+--------+
| id | name  | salary | deptid |
+----+-------+--------+--------+
|  1 | joe   |   8500 |      1 |
|  2 | henry |   8000 |      2 |
|  3 | sam   |   6000 |      2 |
|  4 | Max   |   9000 |      1 |
|  5 | Janet |   6900 |      1 |
|  6 | Randy |   8500 |      1 |
|  7 | will  |   7000 |      1 |
+----+-------+--------+--------+
7 rows in set (0.00 sec)

mysql> select * from emp where name regexp "^[a-z].*[a]";
+----+-------+--------+--------+
| id | name  | salary | deptid |
+----+-------+--------+--------+
|  3 | sam   |   6000 |      2 |
|  4 | Max   |   9000 |      1 |
|  5 | Janet |   6900 |      1 |
|  6 | Randy |   8500 |      1 |
+----+-------+--------+--------+
4 rows in set (0.00 sec)

mysql> select * from emp where name like "_a%";
+----+-------+--------+--------+
| id | name  | salary | deptid |
+----+-------+--------+--------+
|  3 | sam   |   6000 |      2 |
|  4 | Max   |   9000 |      1 |
|  5 | Janet |   6900 |      1 |
|  6 | Randy |   8500 |      1 |
+----+-------+--------+--------+
4 rows in set (0.00 sec)
