
mysql>  select d.department DEPT,e.name NAAM,e.salary SALARY,dense_rank() over (partition by d.department order by e.salary desc) as rank_ from emp e inner 
join dep d on d.id = e.deptid;
+-------+-------+--------+-------+
| DEPT  | NAAM  | SALARY | rank_ |
+-------+-------+--------+-------+
| IT    | Max   |   9000 |     1 |
| IT    | Randy |   8500 |     2 |
| IT    | joe   |   8500 |     2 |
| IT    | will  |   7000 |     3 |
| IT    | Janet |   6900 |     4 |
| sales | henry |   8000 |     1 |
| sales | sam   |   6000 |     2 |
+-------+-------+--------+-------+
7 rows in set (0.00 sec)

mysql> select naam,salary,dept from ( select d.department DEPT,e.name NAAM,e.salary SALARY,dense_rank() over (partition by d.department order by e.salary desc)
                                     as rank_ from emp e inner join dep d on d.id = e.deptid) a where rank_<=3;
+-------+--------+-------+
| naam  | salary | dept  |
+-------+--------+-------+
| Max   |   9000 | IT    |
| Randy |   8500 | IT    |
| joe   |   8500 | IT    |
| will  |   7000 | IT    |
| henry |   8000 | sales |
| sam   |   6000 | sales |
+-------+--------+-------+
6 rows in set (0.00 sec)

mysql>




