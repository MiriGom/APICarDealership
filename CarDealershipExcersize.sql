DROP DATABASE IF EXISTS cardealershipdb;

CREATE DATABASE cardealershipdb;
USE cardealershipdb;

CREATE TABLE `dealerships`(
`dealership_id` INT AUTO_INCREMENT,
`name` VARCHAR(50),
`address` VARCHAR(50),
`phone` VARCHAR(12),
PRIMARY KEY(`dealership_id`)
); 

INSERT INTO dealerships VALUES (NULL, "Tampa_Auto", "1234 orange st. orange FL 33756", "727-446-3020");


CREATE TABLE `vehicles` (
`vin` INT,
`year` INT,
`car_color` VARCHAR(10),
`make` VARCHAR(10),
`model` VARCHAR(10),
`vehicle_type` VARCHAR(10),
`odometer` INT,
`price` DOUBLE,
`sold` BOOLEAN,
PRIMARY KEY (vin)
);
INSERT INTO vehicles VALUES (1111 , 2020, "Red", "Ford", "Mustang", "Sedan", 15000, 22000.5, 0);
INSERT INTO vehicles VALUES (2222,  2021, "silver", "Toyota", "Camry", "Sedan", 1200, 25000, 0);
INSERT INTO vehicles VALUES (3333, 2019, "blue", "Toyota", "ForRunner", "Truck", 45000, 35000.75, 0);
INSERT INTO vehicles VALUES (4444, 2022, "White", "Ford", "F-150", "Truck", 36000, 46500.49, 0);
INSERT INTO vehicles VALUES (5555, 2024, "black", "Tesla", "Model 3", "Sedan", 1000, 55000.00, 0);
INSERT INTO vehicles VALUES (6666, 2018, "Gray", "Chevrolet", "Malibu", "Sedan", 50000, 18000.40, 0);
INSERT INTO vehicles VALUES (7777, 2020, "Silver", "BMW", "320i", "Sedan", 25000, 37000.99, 0 );
INSERT INTO vehicles VALUES (8888, 2023, "Green", "Suburu", "Outback", "SUV", 5000, 42000, 0);
INSERT INTO vehicles VALUES (9999, 2021, "Yellow", "Jeep", "Wrangler", "SUV", 15000, 40000.25, 0);

CREATE TABLE inventory (
`inventory_id` INT AUTO_INCREMENT,
`dealership_id` INT,
`vin` INT,
PRIMARY KEY (inventory_id), FOREIGN KEY (dealership_id) REFERENCES dealerships(dealership_id)ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (vin) REFERENCES vehicles(vin) ON DELETE CASCADE ON UPDATE CASCADE
);
INSERT INTO inventory VALUES (NULL, 1, "1111");
INSERT INTO inventory VALUES (NULL, 1, "2222");
INSERT INTO inventory VALUES (NULL, 1, "3333");
INSERT INTO inventory VALUES (NULL, 1, "4444");
INSERT INTO inventory VALUES (NULL, 1, "5555");
INSERT INTO inventory VALUES (NULL, 1, "6666");
INSERT INTO inventory VALUES (NULL, 1, "7777");
INSERT INTO inventory VALUES (NULL, 1, "8888");
INSERT INTO inventory VALUES (NULL, 1, "9999");

CREATE TABLE sales_contracts (
`sales_id` INT AUTO_INCREMENT,
`date` DATE,
`vin` INT,
`customer_name` VARCHAR(40),
`customer_email` VARCHAR(40),
`monthly_payment` DOUBLE,
`total_price` DOUBLE,
`sales_tax` DOUBLE,
`recording_fee` DOUBLE,
`processing_fee` DOUBLE,
`financing` BOOL,
PRIMARY KEY (sales_id), FOREIGN KEY (vin) REFERENCES vehicles(vin) ON DELETE CASCADE
);

INSERT INTO sales_contracts VALUES(NULL, "1996-01-24", 2222, "John Doe", "john.doe@email.com", 375, 25000, 8.00, 8.00, 8.00, 0);
INSERT INTO sales_contracts VALUES(NULL, "2020-03-22", 4444, "Sarah Smith", "sarah.smith@email.com", 530, 46500.49, 8.00, 8.00, 8.00, 0);
INSERT INTO sales_contracts VALUES(NULL, "2020-11-09", 8888, "Mark Johnson", "mark.johnson@email.com", 684, 42000, 8.00, 8.00, 8.00, 0);
INSERT INTO sales_contracts VALUES(NULL, "2024-06-17", 7777, "Emily Davis", "emily.davis@email.com", 490, 37000.99, 8.00, 8.00, 8.00, 0);

CREATE TABLE lease_contracts (
`sales_id` INT AUTO_INCREMENT,
`date` DATE,
`vin` INT,
`customer_name` VARCHAR(40),
`customer_email` VARCHAR(40),
`monthly_payment` DOUBLE,
`total_price` DOUBLE,
`expected_ending_value` DOUBLE,
`lease_fee` DOUBLE,
`monthly_lease_finance` DOUBLE,

PRIMARY KEY (sales_id), FOREIGN KEY (vin) REFERENCES vehicles(vin) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO lease_contracts VALUES(NULL, "1996-01-24", 3333, "Sonia Doe", "Sonia.doe@email.com", 375, 25000, 8.00, 8.00, 8.00);
INSERT INTO lease_contracts VALUES(NULL, "2020-03-22", 5555, "Rene Smith", "Rene.smith@email.com", 530, 46500.49, 8.00, 8.00, 8.00);
INSERT INTO lease_contracts VALUES(NULL, "2020-11-09", 6666, "Sam Johnson", "Sam.johnson@email.com", 684, 42000, 8.00, 8.00, 8.00);
INSERT INTO lease_contracts VALUES(NULL, "2024-06-17", 9999, "Bill Davis", "Bill.davis@email.com", 490, 37000.99, 8.00, 8.00, 8.00);



