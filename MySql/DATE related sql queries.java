select * from orders where weekday(orderdate) = weekday(deliverydate) and weekday(orderdate) = weekday(shipdate);
where you will get the output in the range from 0 to 6 i.e. mon to sun;
