CREATE TABLE CUSTOMER (CUSTOMER_ID int,CUSTOMER_NAME VARCHAR2(50),EMAIL VARCHAR2(50),LONG_TERM_ACCESS_TOKEN VARCHAR2(100) );
CREATE TABLE TRANSACTION (TRANSACTION_ID int,CUSTOMER_ID int ,TRANSACTION_DATE DATE,AMOUNT int);