USE hotelbookingsystemdb;

CREATE TABLE hotel (
	hotel_id INT NOT NULL AUTO_INCREMENT,
    hotel_name VARCHAR(15),
    hotel_type VARCHAR(10),
    hotel_rating CHAR,
    hotel_desc TEXT,
	hotel_city VARCHAR(15),
    hotel_state VARCHAR(15),
    hotel_phone_no VARCHAR(10),
    hotel_email_id VARCHAR(25),
    PRIMARY KEY (hotel_id)
);

alter table hotel auto_increment=1;

insert into hotel (hotel_name, hotel_type, hotel_rating, hotel_desc, hotel_city, hotel_state, hotel_phone_no, hotel_email_id) VALUES  
	("the oberoi", "luxury", "5", "suites with cutting-edge technology", "new delhi", "delhi", 0112485365, "oberoi@gmail.com"),
    ("the taj mahal", "luxury", "5", "architectural wonder", "mumbai", "maharashtra", 0222586459, "taj@gmail.com"),
    ("the govardhan", "business", "4", "Polished business hotel", "chennai", "tamilnadu", 0442876423, "govardhan@gmail.com"),
	("the village", "budget", "3", "down-to-earth resort", "mysore", "karnataka", 0822658974, "village@gmail.com");    

CREATE TABLE room (
	room_id INT NOT NULL AUTO_INCREMENT,
    hotel_id INT,
	room_type VARCHAR(15),
    room_desc TEXT,
    room_service_no INT,
    room_rent FLOAT,
    PRIMARY KEY (room_id),
    FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id)
);

alter table room AUTO_INCREMENT = 101;

insert into room (hotel_id, room_type, room_desc, room_service_no, room_rent) values
(1, 'single', 'a room assigned to one person', 1001, 1500.00),
(2, 'double', 'room for two', 1002, 3000.00),
(3, 'triple', 'room for three', 1003, 4500.00),
(4, 'quad', 'room for four', 1004, 6000.00);

insert into room (hotel_id, room_type, room_desc, room_service_no, room_rent) values
(1, 'double', 'a room for two', 1002, 3000.00);

CREATE TABLE service (
	service_id INT NOT NULL AUTO_INCREMENT,
    service_type VARCHAR(15),
    service_desc TEXT,
    PRIMARY KEY (service_id)
);

alter table service AUTO_INCREMENT=201;

insert into service (service_type, service_desc) values 
('laundry', 'Give your laundry routine a makeover'),
('room', 'in-room dining'),
('doctor on call', 'available 24 hours'),
('car rental', 'also available with driver');

CREATE TABLE customer (
    customer_id INT NOT NULL AUTO_INCREMENT,
    customer_f_name VARCHAR(10),
    customer_l_name VARCHAR(10),
    customer_city VARCHAR(15),
    customer_state VARCHAR(15),
    customer_phone_no VARCHAR(10),
    customer_email_id VARCHAR(35),
    PRIMARY KEY (customer_id)
);

alter table customer AUTO_INCREMENT=301;
select * from customer;

insert into customer (customer_f_name, customer_l_name, customer_city, customer_state, customer_phone_no, customer_email_id) values 
('sujith', 'kumar', 'kochi', 'kerala', '9446024292', 'suj@gmail.com'),
('sreekumar', 'vs', 'kochi', 'kerala', '9847516461', 'sree@yahoo.com'),
('deepak', 'sreeraj', 'bangalore', 'karnataka', '9845451987', 'deepak@gmail.com'),
('pradeep', 'pa', 'chennai', 'tamilnadu', '9495031654', 'paara@gmail.com');

CREATE TABLE employee (
    ssn INT NOT NULL AUTO_INCREMENT,
    hotel_id INT,
    employee_f_name VARCHAR(10),
    employee_l_name VARCHAR(10),
    employee_gender CHAR(1),
    employee_emoluments FLOAT(10),
    employee_dob DATE,
    employee_doj DATE,
    employee_address TEXT,
    PRIMARY KEY (ssn),
    FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id)
);

alter table employee AUTO_INCREMENT=401;

select * from employee;

insert into employee (hotel_id, employee_f_name, employee_l_name, employee_gender, employee_emoluments, employee_dob, employee_doj, employee_address) values
(1, 'vinod', 'rajan', 'm', 20000.00, '1977-06-15', '2003-02-03', 'aluva'),
(2, 'ajesh', 'thampi', 'm', 25000.00, '1980-08-20', '2005-09-01', 'thrissur'),
(3, 'akhil', 'mohan', 'm', 30000.00, '1975-01-10', '2000-01-01', 'kochi'),
(4, 'soumya', 'og', 'f', 40000.00, '1985-12-17', '2010-05-10', 'kannur');

CREATE TABLE booking (
    booking_id INT NOT NULL AUTO_INCREMENT,
    customer_id INT,
    hotel_id INT,
    room_id INT,
    ssn INT,    
    booking_start_date DATE,
    booking_vacate_date DATE,
    booking_customer VARCHAR(15),
    PRIMARY KEY (booking_id),
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
    FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id),
    FOREIGN KEY (room_id) REFERENCES room (room_id),
    FOREIGN KEY (ssn) REFERENCES employee (ssn)
);

alter table booking AUTO_INCREMENT=501;

insert into booking (customer_id, hotel_id, room_id, ssn, booking_start_date, booking_vacate_date, booking_customer) values
(301, 1, 101, 401, '2022-04-01', '2022-04-03', 'sujith kumar'),
(302, 2, 102, 402, '2022-04-10', '2022-04-15', 'sreekumar vs'),
(303, 3, 103, 403, '2022-05-01', '2022-05-02', 'deepak sreeraj'),
(304, 4, 104, 404, '2022-05-10', '2022-05-13', 'pradeep pa'); 

insert into booking (customer_id, hotel_id, room_id, ssn, booking_start_date, booking_vacate_date, booking_customer) values
(302, 1, 101, 401, '2022-04-10', '2022-04-15', 'sreekumar vs');

insert into booking (customer_id, hotel_id, room_id, ssn, booking_start_date, booking_vacate_date, booking_customer) values
(302, 1, 101, 402, '2022-04-10', '2022-04-15', 'sreekumar vs'); 

insert into booking (customer_id, hotel_id, room_id, ssn, booking_start_date, booking_vacate_date, booking_customer) values
(301, 1, 105, 403, '2022-05-01', '2022-05-02', 'deepak sreeraj'); 

insert into booking (customer_id, hotel_id, room_id, ssn, booking_start_date, booking_vacate_date, booking_customer) values
(301, 2, 102, 402, '2022-05-01', '2022-05-02', 'deepak sreeraj'); 

CREATE TABLE bill (
	bill_id INT NOT NULL AUTO_INCREMENT,
    customer_id INT,
    booking_id INT,
    bill_date DATE,
    bill_customer_name VARCHAR(15),
    PRIMARY KEY (bill_id),
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id),
    FOREIGN KEY (booking_id) REFERENCES booking (booking_id)
);

alter table bill AUTO_INCREMENT=601;

insert into bill (customer_id, booking_id, bill_date, bill_customer_name) values
(301, 501, '2022-04-03', 'sujith kumar'),
(302, 502, '2022-04-15', 'sreekumar vs'),
(303, 503, '2022-05-02', 'deepak sreeraj'),
(304, 504, '2022-05-13', 'pradeeep pa');

CREATE TABLE hotel_service (
	hotel_id INT,
    service_id INT,
    FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id),
    FOREIGN KEY (service_id) REFERENCES service (service_id)
);

insert into hotel_service (hotel_id, service_id) values
(1, 201),
(2, 202),
(3, 203),
(4, 204);

insert into hotel_service (hotel_id, service_id) values (2, 201), (3, 201);

CREATE TABLE booking_service (
	booking_id INT,
    service_id INT,
    FOREIGN KEY (booking_id) REFERENCES booking (booking_id),
    FOREIGN KEY (service_id) REFERENCES service (service_id)
);

insert into booking_service (booking_id, service_id) values
(501, 201),
(502, 202),
(503, 203),
(504, 204);

insert into booking_service (booking_id, service_id) values (502, 201);

CREATE TABLE hotel_customer (
	hotel_id INT,
    customer_id INT,
    FOREIGN KEY (hotel_id) REFERENCES hotel (hotel_id),
    FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

insert into hotel_customer (hotel_id, customer_id) values
(1, 301), 
(2, 302),
(3, 303),
(4, 304);

insert into hotel_customer (hotel_id, customer_id) values (1, 302), (1, 303);