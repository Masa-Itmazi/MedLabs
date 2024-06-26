#create database sql_labs;

use med_lab;

create table employee(
eid INT PRIMARY KEY auto_increment, #100,101,102,.....,n
employee_name varchar(64),
employee_dob date default(current_date()),
employee_Address varchar(64),
employee_number varchar(32)
);
ALTER TABLE employee AUTO_INCREMENT = 1000;
INSERT INTO employee (employee_name, employee_dob, employee_address, employee_number)
VALUES 
  ('Jehad halahla', '2002-09-13', '456 Jafnna St, Birzeit', '+970-569-630-894'),
  ('Masa Itmazi', '2002-12-18', '789  ballo\' St, Bireh', '+970-599-222-111'),
  ('Rana Deek', '2002-07-19', '321 Pine St, Bireh', '+970-589-124-311');
  select * from employee;
  
  
  create table equipment (
  equipment_id int primary key,
  equipment_name varchar(64),
  model varchar(64),
  price decimal(10, 2),
  date_of_purchase date
);

INSERT INTO equipment (equipment_id, equipment_name, model, price, date_of_purchase)
VALUES (1, 'X-Ray Machine', 'ABC123', 150000.00, '2022-03-15');

INSERT INTO equipment (equipment_id, equipment_name, model, price, date_of_purchase)
VALUES (2, 'MRI Scanner', 'DEF456', 2500000.00, '2021-08-27');

INSERT INTO equipment (equipment_id, equipment_name, model, price, date_of_purchase)
VALUES (3, 'Ultrasound Machine', 'GHI789', 75000.00, '2023-01-10');

INSERT INTO equipment (equipment_id, equipment_name, model, price, date_of_purchase)
VALUES (4, 'Defibrillator', 'JKL012', 5000.00, '2022-11-05');

select * from equipment;

CREATE TABLE equipment_employee (
  equipment_id INT,
  employee_id INT,
  PRIMARY KEY (equipment_id, employee_id),
  FOREIGN KEY (equipment_id) REFERENCES equipment(equipment_id),
  FOREIGN KEY (employee_id) REFERENCES employee(eid)
);

select * from equipment_employee;

INSERT INTO equipment_employee (equipment_id, employee_id)
VALUES (1, 1000); -- Equipment with ID 1 is associated with Employee with ID 1001

INSERT INTO equipment_employee (equipment_id, employee_id)
VALUES (1, 1001); -- Equipment with ID 1 is associated with Employee with ID 1002

INSERT INTO equipment_employee (equipment_id, employee_id)
VALUES (2, 1000); -- Equipment with ID 2 is associated with Employee with ID 1001

INSERT INTO equipment_employee (equipment_id, employee_id)
VALUES (3, 1002); -- Equipment with ID 3 is associated with Employee with ID 1003
select * from equipment_employee;

CREATE TABLE test (
  test_id INT PRIMARY KEY,
  test_date DATE,
  test_name VARCHAR(64),
  equipment_id INT,
  FOREIGN KEY (equipment_id) REFERENCES equipment(equipment_id)
);
ALTER TABLE test MODIFY COLUMN test_id INT AUTO_INCREMENT;
ALTER TABLE test AUTO_INCREMENT = 100;

INSERT INTO test (test_date, test_name, equipment_id)
VALUES ('2023-06-24', 'Blood Test', 1); -- Test ID 100, Blood Test performed using Equipment with ID 1

INSERT INTO test (test_date, test_name, equipment_id)
VALUES ('2023-06-25', 'CT Scan', 2); -- Test ID 101, CT Scan performed using Equipment with ID 2

INSERT INTO test (test_date, test_name, equipment_id)
VALUES ('2023-06-26', 'Mammogram', 3); -- Test ID 102, Mammogram performed using Equipment with ID 3
INSERT INTO test (test_date, test_name, equipment_id)
VALUES ('2023-06-27', 'Echocardiogram', 4); -- Test ID 103, Echocardiogram performed using Equipment with ID 4

INSERT INTO test (test_date, test_name, equipment_id)
VALUES ('2023-06-28', 'Pulmonary Function Test', 1); -- Test ID 104, Pulmonary Function Test performed using Equipment with ID 1

INSERT INTO test (test_date, test_name, equipment_id)
VALUES ('2023-06-29', 'Colonoscopy', 2); -- Test ID 105, Colonoscopy performed using Equipment with ID 2
select * from test;

CREATE TABLE report (
  report_id INT AUTO_INCREMENT PRIMARY KEY,
  report_date DATE,
  test_result VARCHAR(255),
  test_id INT,
  FOREIGN KEY (test_id) REFERENCES test(test_id) ON DELETE CASCADE ON UPDATE CASCADE
);

ALTER TABLE report AUTO_INCREMENT = 10;
INSERT INTO report (report_date, test_result, test_id)
VALUES
  ('2023-06-24', 'Normal', 100), -- Report ID 1, Report Date: 2023-06-24, Test Result: Normal, Test ID: 100
  ('2023-06-25', 'Abnormal', 101), -- Report ID 2, Report Date: 2023-06-25, Test Result: Abnormal, Test ID: 101
  ('2023-06-26', 'Normal', 102), -- Report ID 3, Report Date: 2023-06-26, Test Result: Normal, Test ID: 102
  ('2023-06-27', 'Abnormal', 103), -- Report ID 4, Report Date: 2023-06-27, Test Result: Abnormal, Test ID: 103
  ('2023-06-28', 'Normal', 104), -- Report ID 5, Report Date: 2023-06-28, Test Result: Normal, Test ID: 104
  ('2023-06-29', 'Abnormal', 105); -- Report ID 6, Report Date: 2023-06-29, Test Result: Abnormal, Test ID: 105
  select * from report;
  
  CREATE TABLE test_type (
  test_id INT PRIMARY KEY,
  test_cost DECIMAL(10, 2),
  notes VARCHAR(255),
  range_of_values VARCHAR(255),
  test_name VARCHAR(64),
  test_category VARCHAR(64),
  turn_around_time INT
);

ALTER TABLE test ADD COLUMN test_type_id INT;
ALTER TABLE test ADD FOREIGN KEY (test_type_id) REFERENCES test_type(test_id);
INSERT INTO test_type (test_id, test_cost, notes, range_of_values, test_name, test_category, turn_around_time)
VALUES (1, 50.00, 'No special notes.', '0-100', 'Blood Test', 'Laboratory', 2);
INSERT INTO test_type (test_id, test_cost, notes, range_of_values, test_name, test_category, turn_around_time)
VALUES (2, 150.00, 'Requires fasting for 12 hours prior to the test.', 'Negative, Positive', 'Cholesterol Test', 'Laboratory', 1);
INSERT INTO test_type (test_id, test_cost, notes, range_of_values, test_name, test_category, turn_around_time)
VALUES (3, 80.00, 'No special notes.', '0-50', 'Hemoglobin Test', 'Laboratory', 2);
create Table Patient ( 
PatientEmail varchar(30),
DateOFBirthday Date,
PatientID int primary KEY,
Gender varchar(20),
PatientAddress varchar(40),
PatientName varchar(20));
INSERT INTO patient (PatientEmail, DateOFBirthday, PatientID, Gender, PatientAddress, PatientName)
VALUES 
  ('janeSmith@gmail.com', '1985-09-10', 2, 'Female', '456 Elm Street', 'Jane Smith'),
  ('mikeJohnson@gmail.com', '1978-03-22', 3, 'Male', '789 Oak Avenue', 'Mike Johnson'),
  ('EmilyDavis@gmail.com', '1995-11-27', 4, 'Female', '321 Maple Road', 'Emily Davis');
    select * from patient;
create TABLE Payment(SerialNum INT primary key);
INSERT INTO Payment (SerialNum)
VALUES (1), (2), (3);
create TABLE Insurance(
Customer_Insurance_ID INT primary key, 
Customer_Name varchar(20),
Date_INSU date);
INSERT INTO Insurance (Customer_Insurance_ID, Customer_Name, Date_INSU)
VALUES (1, 'John Doe', '2022-01-15'), (2, 'Jane Smith', '2022-02-20'), (3, 'Mike Johnson', '2022-03-10');
  select * from Payment;
create TABLE Cash_ORDER(date_Cash Date);
INSERT INTO Cash_ORDER (date_Cash)
VALUES ('2022-01-15'), ('2022-02-20'), ('2022-03-10');
  select * from Cash_ORDER;
create table bill( 
bill_ID int primary key,
Price int,
profits int ,
Bill_Type varchar(20)); 
INSERT INTO bill (bill_ID, Price, profits, Bill_Type)
VALUES (1, 100, 20, 'Sales'), (2, 200, 40, 'Expenses'), (3, 150, 30, 'Revenue');
  select * from bill;
create table Insurance_Company(
name varchar(20) primary key,
discount_in_price int);
INSERT INTO Insurance_Company (name, discount_in_price)
VALUES ('ABC Insurance', 10), ('XYZ Insurance', 5), ('PQR Insurance', 15);
  select * from Insurance_Company;
create table insurance_customer( 
ID int primary key,
name varchar(20));
INSERT INTO insurance_customer (ID, name)
VALUES (1, 'John Doe'), (2, 'Jane Smith'), (3, 'Mike Johnson');
 select * from insurance_customer;

ALTER TABLE patient
ADD COLUMN PatientNumber int;

ALTER TABLE patient
MODIFY COLUMN  PatientNumber varchar(30);

UPDATE patient
SET PatientNumber = '+970-569630-894'
WHERE PatientID=2;
UPDATE patient
SET PatientNumber = '+970-569-457-832'
WHERE PatientID=3;
UPDATE patient
SET PatientNumber = '+970-569-632-587'
WHERE PatientID=4;