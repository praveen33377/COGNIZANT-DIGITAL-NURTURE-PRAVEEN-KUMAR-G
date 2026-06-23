
-- Exercise 3: Stored Procedures (PL/SQL)

SET SERVEROUTPUT ON;

CREATE TABLE employees (
    emp_id NUMBER PRIMARY KEY,
    emp_name VARCHAR2(50),
    salary NUMBER
);

INSERT INTO employees VALUES (101, 'Praveen', 50000);
INSERT INTO employees VALUES (102, 'Rahul', 65000);
INSERT INTO employees VALUES (103, 'Anita', 72000);

COMMIT;

CREATE OR REPLACE PROCEDURE get_employee_details (
    p_emp_id IN NUMBER
)
AS
    v_name employees.emp_name%TYPE;
    v_salary employees.salary%TYPE;
BEGIN
    SELECT emp_name, salary
    INTO v_name, v_salary
    FROM employees
    WHERE emp_id = p_emp_id;

    DBMS_OUTPUT.PUT_LINE('Employee Name : ' || v_name);
    DBMS_OUTPUT.PUT_LINE('Salary        : ' || v_salary);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Employee not found.');
END;
/

BEGIN
    get_employee_details(102);
END;
/
