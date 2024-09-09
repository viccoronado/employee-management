-- create_tables.sql

-- GENDERS
CREATE TABLE GENDERS (
                         ID INT PRIMARY KEY,
                         NAME VARCHAR(255) NOT NULL
);

-- JOBS
CREATE TABLE JOBS (
                      ID INT PRIMARY KEY,
                      NAME VARCHAR(255) NOT NULL,
                      SALARY DECIMAL(9, 2)
);

-- EMPLOYEES
CREATE TABLE EMPLOYEES (
                           ID INT PRIMARY KEY,
                           GENDER_ID INT,
                           JOB_ID INT,
                           NAME VARCHAR(255) NOT NULL,
                           LAST_NAME VARCHAR(255) NOT NULL,
                           BIRTHDATE DATE,
                           FOREIGN KEY (GENDER_ID) REFERENCES GENDERS(ID),
                           FOREIGN KEY (JOB_ID) REFERENCES JOBS(ID)
);

-- EMPLOYEE_WORKED_HOURS
CREATE TABLE EMPLOYEE_WORKED_HOURS (
                                       ID INT PRIMARY KEY,
                                       EMPLOYEE_ID INT,
                                       WORKED_HOURS DECIMAL(9, 2),
                                       WORKED_DATE DATE,
                                       FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEES(ID)
);