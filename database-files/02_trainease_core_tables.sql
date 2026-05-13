CREATE TABLE administration(AdminName VARCHAR(20),Username VARCHAR(20),Password VARCHAR(20),Designation VARCHAR(30));
INSERT INTO administration VALUES('Mr. Anand Shenoy','administrator','anand@admin','Designer & Developer');

CREATE TABLE otp(Mobile_No VARCHAR(15),Message VARCHAR(5));

CREATE TABLE notification(Mobile_No VARCHAR(15),DateTime VARCHAR(30),Message VARCHAR(300));

CREATE TABLE registration(FirstName VARCHAR(20),LastName VARCHAR(20),MobileNo VARCHAR(15),Username VARCHAR(20),Password VARCHAR(20),DateTime VARCHAR(30));

CREATE TABLE account(UPI_Name VARCHAR(50),UPI_No VARCHAR(20),UPI_PIN VARCHAR(10),Account_No VARCHAR(20),Account_Balance VARCHAR(20));

CREATE TABLE warnings(Username VARCHAR(20));

CREATE TABLE bookings(TE_No VARCHAR(20),Route VARCHAR(50),TicketType VARCHAR(10),ClassType VARCHAR(10),TotalMembers VARCHAR(10),TotalTicketFare VARCHAR(10),TicketDateTime VARCHAR(30),Username VARCHAR(20));

CREATE TABLE feedbacks(Username VARCHAR(20),Navigation VARCHAR(20),Booking VARCHAR(20),Support VARCHAR(20),Performance VARCHAR(20),DateTime VARCHAR(30));

CREATE TABLE deactivation(FirstName VARCHAR(20),LastName VARCHAR(20),MobileNo VARCHAR(15),Username VARCHAR(20),Reason VARCHAR(50),DateTime VARCHAR(30));

SELECT * FROM centralfares;
SELECT * FROM westernfares;
SELECT * FROM harbourfares;
SELECT * FROM transharbourfares;
SELECT * FROM neruluranfares;

SELECT * FROM administration;
SELECT * FROM otp;
SELECT * FROM notification;
SELECT * FROM registration;
SELECT * FROM account;
SELECT * FROM warnings;
SELECT * FROM bookings;
SELECT * FROM feedbacks;
SELECT * FROM deactivation;
