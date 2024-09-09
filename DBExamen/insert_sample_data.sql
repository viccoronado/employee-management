-- Script to insert sample data into the tables

-- Insert genders
INSERT INTO GENDERS (ID, NAME) VALUES (1, 'Male');
INSERT INTO GENDERS (ID, NAME) VALUES (2, 'Male');

-- Insert jobs
INSERT INTO JOBS (ID, NAME, SALARY) VALUES (1, 'Backend Engineer', 5000);
INSERT INTO JOBS (ID, NAME, SALARY) VALUES (2, 'Frontend Engineer', 5000);

-- Insert employees
INSERT INTO EMPLOYEES (ID, GENDER_ID, JOB_ID, NAME, LAST_NAME, BIRTHDATE) 
VALUES (1, 1, 1, 'Juan', 'Pérez', TO_DATE('1995-01-06', 'YYYY-MM-DD'));
INSERT INTO EMPLOYEES (ID, GENDER_ID, JOB_ID, NAME, LAST_NAME, BIRTHDATE) 
VALUES (2, 2, 2, 'Mariano', 'García', TO_DATE('1985-02-18', 'YYYY-MM-DD'));
