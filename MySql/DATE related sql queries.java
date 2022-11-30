select * from orders where weekday(orderdate) = weekday(deliverydate) and weekday(orderdate) = weekday(shipdate);
where you will get the output in the range from 0 to 6 i.e. mon to sun;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
select datediff(deliverydate,orderdate) df,count(orderid) from orders group by df order by df;
another query gives the day difference between date
