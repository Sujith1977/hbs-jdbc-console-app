-- (1) get all customers of a specific hotel
select c.customer_f_name, c.customer_l_name from customer c inner join hotel_customer hc on c.customer_id = hc.customer_id where hc.hotel_id = 1;

-- (2) get all hotels offering laundry service
select h.hotel_name from hotel h inner join hotel_service hs on h.hotel_id = hs.hotel_id where hs.service_id = 201;

-- (3) find the room with the highest number of bookings in a specific hotel
select r.room_id, count(r.room_id) noOfBookings from room r inner join booking b on r.room_id = b.room_id where b.hotel_id = 1 group by r.room_id order by count(r.room_id) desc limit 1;

-- (4) get all bookings of a specific customer in a specific hotel
select b.booking_id from booking b inner join customer c on b.customer_id = c.customer_id where c.customer_id = 304 and b.hotel_id = 4;

-- (5) find the hotel that has highest number of customers
select h.hotel_name, count(hc.customer_id) noOfCustomers from hotel h inner join hotel_customer hc on h.hotel_id = hc.hotel_id group by h.hotel_id order by count(hc.customer_id) desc limit 1;

-- (6) get all customers who have laundry service in their bookings across all hotel
select c.customer_id, c.customer_f_name, c.customer_l_name from customer c inner join booking b on c.customer_id = b.customer_id inner join booking_service bs on bs.booking_id = b.booking_id where bs.service_id = 201;

SHOW VARIABLES LIKE 'sql_mode';
set global sql_mode='';
-- set global sql_mode='STRICT_TRANS_TABLES';

-- (7) Find the employee who has taken highest number of bookings in a specific hotel
select concat(e.employee_f_name, ' ', e.employee_l_name) employeeName, count(b.booking_id) noOfBookings from employee e inner join booking b on e.ssn = b.ssn where b.hotel_id = 1 group by e.employee_f_name, e.employee_l_name order by count(b.booking_id) desc limit 1;


-- (8) Find the hotel that has second highest number of bookings
select h.hotel_name, count(b.booking_id) totalBookings from booking b inner join hotel h on b.hotel_id = h.hotel_id group by h.hotel_id order by count(b.booking_id) desc limit 1,1;

select h.hotel_name, count(b.booking_id) totalBookings from booking b inner join hotel h on b.hotel_id = h.hotel_id group by h.hotel_id order by count(b.booking_id) desc limit 1;