-- GENDERS
CREATE TABLE GENDERS (
    ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(255) NOT NULL
);

-- JOBS
CREATE TABLE JOBS (
    ID NUMBER PRIMARY KEY,
    NAME VARCHAR2(255) NOT NULL,
    SALARY NUMBER(9, 2)
);

-- EMPLOYEES
CREATE TABLE EMPLOYEES (
    ID NUMBER PRIMARY KEY,
    GENDER_ID NUMBER REFERENCES GENDERS(ID),
    JOB_ID NUMBER REFERENCES JOBS(ID),
    NAME VARCHAR2(255) NOT NULL,
    LAST_NAME VARCHAR2(255) NOT NULL,
    BIRTHDATE DATE
);

-- EMPLOYEE_WORKED_HOURS
CREATE TABLE EMPLOYEE_WORKED_HOURS (
    ID NUMBER PRIMARY KEY,
    EMPLOYEE_ID NUMBER REFERENCES EMPLOYEES(ID),
    WORKED_HOURS NUMBER(9, 2),
    WORKED_DATE DATE
);
