mysql> select sum(population) from city where district = "california";
+-----------------+
| sum(population) |
+-----------------+
|         1021780 |
+-----------------+
1 row in set (0.01 sec)

mysql> select avg(population) from city;
+-----------------+
| avg(population) |
+-----------------+
|     286539.8000 |
+-----------------+
1 row in set (0.00 sec)

mysql> select round avg(population) from city;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '(population) from city' at line 1
mysql> select round( avg(population),0) from city;
+---------------------------+
| round( avg(population),0) |
+---------------------------+
|                    286540 |
+---------------------------+
1 row in set (0.00 sec)

mysql> select * from city;
+------+--------------+--------------+------------+------------+
| ID   | name         | countrycodes | district   | population |
+------+--------------+--------------+------------+------------+
| 3878 | Scottsdale   | USA          | arizona    |     202705 |
| 3965 | corona       | USA          | california |     900000 |
| 3973 | concord      | USA          | california |     121780 |
| 3977 | cedar rapids | USA          | lowa       |     120758 |
| 3982 | colar spring | USA          | florida    |      87456 |
+------+--------------+--------------+------------+------------+
5 rows in set (0.00 sec)

mysql> alter table city add chacha int;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> select * from city;
+------+--------------+--------------+------------+------------+--------+
| ID   | name         | countrycodes | district   | population | chacha |
+------+--------------+--------------+------------+------------+--------+
| 3878 | Scottsdale   | USA          | arizona    |     202705 |   NULL |
| 3965 | corona       | USA          | california |     900000 |   NULL |
| 3973 | concord      | USA          | california |     121780 |   NULL |
| 3977 | cedar rapids | USA          | lowa       |     120758 |   NULL |
| 3982 | colar spring | USA          | florida    |      87456 |   NULL |
+------+--------------+--------------+------------+------------+--------+
5 rows in set (0.00 sec)

mysql> alter table city change chacha important int;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> select * from city;
+------+--------------+--------------+------------+------------+-----------+
| ID   | name         | countrycodes | district   | population | important |
+------+--------------+--------------+------------+------------+-----------+
| 3878 | Scottsdale   | USA          | arizona    |     202705 |      NULL |
| 3965 | corona       | USA          | california |     900000 |      NULL |
| 3973 | concord      | USA          | california |     121780 |      NULL |
| 3977 | cedar rapids | USA          | lowa       |     120758 |      NULL |
| 3982 | colar spring | USA          | florida    |      87456 |      NULL |
+------+--------------+--------------+------------+------------+-----------+
5 rows in set (0.00 sec)

mysql> alter table city drop important;
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> select * from city;
+------+--------------+--------------+------------+------------+
| ID   | name         | countrycodes | district   | population |
+------+--------------+--------------+------------+------------+
| 3878 | Scottsdale   | USA          | arizona    |     202705 |
| 3965 | corona       | USA          | california |     900000 |
| 3973 | concord      | USA          | california |     121780 |
| 3977 | cedar rapids | USA          | lowa       |     120758 |
| 3982 | colar spring | USA          | florida    |      87456 |
+------+--------------+--------------+------------+------------+
5 rows in set (0.00 sec)

mysql> alter table city change name naam varchar(24);
Query OK, 0 rows affected (0.01 sec)
Records: 0  Duplicates: 0  Warnings: 0

mysql> select * from city;
+------+--------------+--------------+------------+------------+
| ID   | naam         | countrycodes | district   | population |
+------+--------------+--------------+------------+------------+
| 3878 | Scottsdale   | USA          | arizona    |     202705 |
| 3965 | corona       | USA          | california |     900000 |
| 3973 | concord      | USA          | california |     121780 |
| 3977 | cedar rapids | USA          | lowa       |     120758 |
| 3982 | colar spring | USA          | florida    |      87456 |
+------+--------------+--------------+------------+------------+
5 rows in set (0.00 sec)

mysql>










