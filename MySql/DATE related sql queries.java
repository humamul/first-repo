select * from orders where weekday(orderdate) = weekday(deliverydate) and weekday(orderdate) = weekday(shipdate);
where you will get the output in the range from 0 to 6 i.e. mon to sun;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
select datediff(deliverydate,orderdate) df,count(orderid) from orders group by df order by df;
another query gives the day difference between date
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
select Month(dateentered) m, count(customerid) c from customers group by m having m in(3,4,5) order by c desc;
here starting of the month is from 1 o 12   and if you want from a particular year then add where extract(year from dateentered) = 2020 then group by m;
