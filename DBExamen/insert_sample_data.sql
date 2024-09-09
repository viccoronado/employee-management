-- Insertar géneros
INSERT INTO GENDERS (ID, NAME) VALUES (1, 'Male');
INSERT INTO GENDERS (ID, NAME) VALUES (2, 'Female');

-- Insertar trabajos
INSERT INTO JOBS (ID, NAME, SALARY) VALUES (1, 'Backend Engineer', 5000);
INSERT INTO JOBS (ID, NAME, SALARY) VALUES (2, 'Frontend Engineer', 5000);

-- Insertar empleados
INSERT INTO EMPLOYEES (ID, GENDER_ID, JOB_ID, NAME, LAST_NAME, BIRTHDATE)
VALUES (1, 1, 1, 'Juan', 'Pérez', '1995-01-06');
INSERT INTO EMPLOYEES (ID, GENDER_ID, JOB_ID, NAME, LAST_NAME, BIRTHDATE)
VALUES (2, 2, 2, 'Mariana', 'García', '1985-02-18');
