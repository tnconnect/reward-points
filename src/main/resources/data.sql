INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL,LONG_TERM_ACCESS_TOKEN) values (101,'John','john.miller@gmail.com','asdfg@2');
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL,LONG_TERM_ACCESS_TOKEN) values (102,'David','david.fax@gmail.com','asdfg@2');
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL,LONG_TERM_ACCESS_TOKEN) values (103,'Aron','aron.max@gmail.com','asdfg@2');
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL,LONG_TERM_ACCESS_TOKEN) values (104,'justin','justin.kile@gmail.com','asdfg@2');
INSERT INTO CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,EMAIL,LONG_TERM_ACCESS_TOKEN) values (105,'Arnold','arnold.swan@gmail.com','asdfg@2');
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1001,101,'2022-05-02',150);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1002,101,'2022-05-01',86);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1003,101,'2022-06-06',180);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1004,101,'2022-06-01',97);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1005,101,'2022-05-04',150);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1006,101,'2022-05-05',185);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1007,102,'2022-06-05',113);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1008,102,'2022-03-27',89);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1009,102,'2022-03-04',162);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1010,102,'2022-03-01',210);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1011,102,'2022-02-27',150);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1012,102,'2022-04-15',89);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1013,103,'2022-04-05',182);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1014,103,'2022-01-28',89);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1015,103,'2022-01-09',270);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1016,103,'2022-03-01',163);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1017,103,'2022-03-26',580);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1018,103,'2022-04-25',595);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1019,103,'2022-03-17',172);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1020,104,'2022-01-09',270);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1021,104,'2022-03-05',166);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1022,105,'2022-03-24',580);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1023,105,'2022-04-20',590);
INSERT INTO TRANSACTION(TRANSACTION_ID,CUSTOMER_ID,TRANSACTION_DATE,AMOUNT) VALUES (1024,105,'2022-03-16',170);
COMMIT;