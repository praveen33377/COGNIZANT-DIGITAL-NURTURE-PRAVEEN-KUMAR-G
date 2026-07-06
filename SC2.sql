DECLARE

    CURSOR customer_cursor IS
    SELECT customer_id, balance
    FROM customers;

BEGIN

    FOR customer_record IN customer_cursor LOOP

        IF customer_record.balance > 10000 THEN

            UPDATE customers
            SET IsVIP = 'TRUE'
            WHERE customer_id = customer_record.customer_id;

        END IF;

    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated successfully.');

END;
/