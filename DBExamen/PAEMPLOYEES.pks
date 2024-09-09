-- Package specification for CRUD operations on EMPLOYEES

CREATE OR REPLACE PACKAGE PAEMPLOYEES AS
    -- Function to insert a new employee
    FUNCTION FNINSERT(
        P_GENDER_ID IN NUMBER,
        P_JOB_ID IN NUMBER,
        P_NAME IN VARCHAR2,
        P_LAST_NAME IN VARCHAR2,
        P_BIRTHDATE IN DATE
    ) RETURN NUMBER;
    
    -- Function to update an existing employee
    FUNCTION FNUPDATE(
        P_ID IN NUMBER,
        P_GENDER_ID IN NUMBER,
        P_JOB_ID IN NUMBER,
        P_NAME IN VARCHAR2,
        P_LAST_NAME IN VARCHAR2,
        P_BIRTHDATE IN DATE
    ) RETURN NUMBER;

    -- Function to delete an employee
    FUNCTION FNDELETE(
        P_ID IN NUMBER
    ) RETURN NUMBER;

    -- Function to fetch an employee by ID
    FUNCTION FNSELECT(
        P_ID IN NUMBER
    ) RETURN SYS_REFCURSOR;
END PAEMPLOYEES;
/
