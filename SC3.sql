DECLARE

    CURSOR loan_cursor IS
    SELECT customer_id, loan_id, due_date
    FROM loans
    WHERE due_date BETWEEN SYSDATE AND SYSDATE + 30;

BEGIN

    FOR loan_record IN loan_cursor LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Customer ID ' || loan_record.customer_id ||
            ' has Loan ID ' || loan_record.loan_id ||
            ' due on ' || loan_record.due_date
        );

    END LOOP;

END;
/