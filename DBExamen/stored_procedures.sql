DELIMITER //

-- Procedure to insert a new employee
CREATE PROCEDURE InsertEmployee(
    IN P_GENDER_ID INT,
    IN P_JOB_ID INT,
    IN P_NAME VARCHAR(255),
    IN P_LAST_NAME VARCHAR(255),
    IN P_BIRTHDATE DATE,
    OUT P_NEW_ID INT
)
BEGIN
    -- Insert the new employee
INSERT INTO EMPLOYEES (GENDER_ID, JOB_ID, NAME, LAST_NAME, BIRTHDATE)
VALUES (P_GENDER_ID, P_JOB_ID, P_NAME, P_LAST_NAME, P_BIRTHDATE);

-- Get the new ID
SET P_NEW_ID = LAST_INSERT_ID();
END //

-- Procedure to update an existing employee
CREATE PROCEDURE UpdateEmployee(
    IN P_ID INT,
    IN P_GENDER_ID INT,
    IN P_JOB_ID INT,
    IN P_NAME VARCHAR(255),
    IN P_LAST_NAME VARCHAR(255),
    IN P_BIRTHDATE DATE
)
BEGIN
    -- Update employee data
UPDATE EMPLOYEES
SET GENDER_ID = P_GENDER_ID,
    JOB_ID = P_JOB_ID,
    NAME = P_NAME,
    LAST_NAME = P_LAST_NAME,
    BIRTHDATE = P_BIRTHDATE
WHERE ID = P_ID;
END //

-- Procedure to delete an employee
CREATE PROCEDURE DeleteEmployee(
    IN P_ID INT
)
BEGIN
    -- Delete the employee
DELETE FROM EMPLOYEES WHERE ID = P_ID;
END //

-- Procedure to fetch an employee by ID
CREATE PROCEDURE SelectEmployee(
    IN P_ID INT
)
BEGIN
    -- Select employee by ID
SELECT * FROM EMPLOYEES WHERE ID = P_ID;
END //

DELIMITER ;
