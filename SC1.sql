DECLARE

    CURSOR customer_cursor IS
    SELECT customer_id, age
    FROM customers;

BEGIN

    FOR customer_record IN customer_cursor LOOP

        IF customer_record.age > 60 THEN

            UPDATE loans
            SET interest_rate = interest_rate - 1
            WHERE customer_id = customer_record.customer_id;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Interest rate updated successfully.');

END;
/