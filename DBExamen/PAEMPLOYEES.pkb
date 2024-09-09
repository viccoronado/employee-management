-- Package body for CRUD operations on EMPLOYEES

CREATE OR REPLACE PACKAGE BODY PAEMPLOYEES AS

    -- Function to insert a new employee
    FUNCTION FNINSERT(
        P_GENDER_ID IN NUMBER,
        P_JOB_ID IN NUMBER,
        P_NAME IN VARCHAR2,
        P_LAST_NAME IN VARCHAR2,
        P_BIRTHDATE IN DATE
    ) RETURN NUMBER IS
        V_ID NUMBER;
    BEGIN
        -- Generate new ID for the employee
        SELECT EMPLOYEES_SEQ.NEXTVAL INTO V_ID FROM DUAL;

        -- Insert the new employee
        INSERT INTO EMPLOYEES (ID, GENDER_ID, JOB_ID, NAME, LAST_NAME, BIRTHDATE)
        VALUES (V_ID, P_GENDER_ID, P_JOB_ID, P_NAME, P_LAST_NAME, P_BIRTHDATE);

        RETURN V_ID; -- Return the generated ID
    EXCEPTION
        WHEN OTHERS THEN
            -- Error handling
            RAISE_APPLICATION_ERROR(-20001, 'Error inserting the employee: ' || SQLERRM);
    END FNINSERT;

    -- Function to update an employee
    FUNCTION FNUPDATE(
        P_ID IN NUMBER,
        P_GENDER_ID IN NUMBER,
        P_JOB_ID IN NUMBER,
        P_NAME IN VARCHAR2,
        P_LAST_NAME IN VARCHAR2,
        P_BIRTHDATE IN DATE
    ) RETURN NUMBER IS
    BEGIN
        -- Update employee data
        UPDATE EMPLOYEES
        SET GENDER_ID = P_GENDER_ID,
            JOB_ID = P_JOB_ID,
            NAME = P_NAME,
            LAST_NAME = P_LAST_NAME,
            BIRTHDATE = P_BIRTHDATE
        WHERE ID = P_ID;

        RETURN P_ID; -- Return the employee ID
    EXCEPTION
        WHEN OTHERS THEN
            -- Error handling
            RAISE_APPLICATION_ERROR(-20002, 'Error updating the employee: ' || SQLERRM);
    END FNUPDATE;

    -- Function to delete an employee
    FUNCTION FNDELETE(
        P_ID IN NUMBER
    ) RETURN NUMBER IS
    BEGIN
        -- Delete the employee
        DELETE FROM EMPLOYEES WHERE ID = P_ID;

        RETURN P_ID; -- Return the deleted employee's ID
    EXCEPTION
        WHEN OTHERS THEN
            -- Error handling
            RAISE_APPLICATION_ERROR(-20003, 'Error deleting the employee: ' || SQLERRM);
    END FNDELETE;

    -- Function to fetch an employee by ID
    FUNCTION FNSELECT(
        P_ID IN NUMBER
    ) RETURN SYS_REFCURSOR IS
        EMP_CURSOR SYS_REFCURSOR;
    BEGIN
        -- Open cursor to select employee by ID
        OPEN EMP_CURSOR FOR
        SELECT * FROM EMPLOYEES WHERE ID = P_ID;

        RETURN EMP_CURSOR; -- Return the cursor with employee data
    EXCEPTION
        WHEN OTHERS THEN
            -- Error handling
            RAISE_APPLICATION_ERROR(-20004, 'Error fetching the employee: ' || SQLERRM);
    END FNSELECT;
END PAEMPLOYEES;
/
