#Sumith Gannarapu

#SELECT STATEMENTS
SELECT * FROM EMPLOYEE_TAB;
SELECT * FROM DOCTOR_TAB;
SELECT * FROM NURSE_TAB;
SELECT * FROM PATIENT_TAB;
SELECT * FROM ROOM_TAB;
SELECT * FROM MEDICINE_TAB;
SELECT * FROM CARES_TAB;
SELECT * FROM ASSIGNED_TAB;
SELECT * FROM IS_GIVEN_TAB;
SELECT * FROM ATTENDS_TO_TAB;

#DROP STATEMENTS
DROP TABLE EMPLOYEE_TAB FORCE;
DROP TABLE DOCTOR_TAB FORCE;
DROP TABLE NURSE_TAB FORCE;
DROP TABLE PATIENT_TAB FORCE;
DROP TABLE ROOM_TAB FORCE;
DROP TABLE MEDICINE_TAB FORCE;
DROP TABLE CARES_TAB FORCE;
DROP TABLE ASSIGNED_TAB FORCE;
DROP TABLE IS_GIVEN_TAB FORCE;
DROP TABLE ATTENDS_TO_TAB FORCE;

DROP TYPE E_ADDRESS_TYP FORCE;
DROP TYPE EMPLOYEE_TYP FORCE;
DROP TYPE DOCTOR_TYP FORCE;
DROP TYPE NURSE_TYP FORCE;
DROP TYPE DATE_DISCHARGED_TYP FORCE;
DROP TYPE DATE_ADMITTED_TYP FORCE;
DROP TYPE CONTACT_NO_TYP FORCE;
DROP TYPE STAY_PERIOD_TYP FORCE;
DROP TYPE PATIENT_TYP FORCE;
DROP TYPE CARES_TYP FORCE;
DROP TYPE MEDICINE_TYP FORCE;
DROP TYPE ROOM_TYP FORCE;
DROP TYPE ASSIGNED_TYP FORCE;
DROP TYPE IS_GIVEN_TYP FORCE;
DROP TYPE ATTENDS_TO_TYP FORCE;

#Employee Type & Doctor Type
CREATE TYPE E_ADDRESS_TYP AS OBJECT(STREET VARCHAR2(25),CITY VARCHAR2(25), STATE VARCHAR2(25), ZIPCODE NUMBER(5));
CREATE TYPE EMPLOYEE_TYP AS OBJECT(EID NUMBER(9),E_NAME VARCHAR2(25), CONTACT_NO NUMBER(10), SEX VARCHAR2(8), SALARY NUMBER(20), E_ADDRESS E_ADDRESS_TYP) NOT FINAL;
CREATE TYPE DOCTOR_TYP UNDER EMPLOYEE_TYP(SPECIALIZATION VARCHAR(25));
CREATE TYPE NURSE_TYP UNDER  EMPLOYEE_TYP(LEVEL1 VARCHAR2(25));

#PATIENT
CREATE TYPE DATE_DISCHARGED_TYP AS OBJECT(DAY NUMBER(25), MONTH NUMBER(25), YEAR NUMBER(4));
CREATE TYPE DATE_ADMITTED_TYP AS OBJECT(DAY NUMBER(25), MONTH NUMBER(25), YEAR NUMBER(4));
CREATE TYPE CONTACT_NO_TYP AS VARRAY(10) OF VARCHAR2(25);
CREATE TYPE STAY_PERIOD_TYP AS OBJECT(DATE_ADMITTED DATE_ADMITTED_TYP, DATE_DISCHARGED DATE_DISCHARGED_TYP);
CREATE TYPE PATIENT_TYP AS OBJECT(PID NUMBER(9), NAME VARCHAR2(25), SEX VARCHAR2(25), ADDRESS VARCHAR2(25), STAY_PERIOD STAY_PERIOD_TYP, CONTACT_NO CONTACT_NO_TYP) NOT FINAL;

#Patient and doctor
CREATE TYPE CARES_TYP AS OBJECT(PID REF PATIENT_TYP, EID REF DOCTOR_TYP);

#MEDICINE
CREATE TYPE MEDICINE_TYP AS OBJECT(CODE VARCHAR2(25), NAME VARCHAR2(20));

#ROOM
CREATE TYPE ROOM_TYP AS OBJECT(ROOM_ID VARCHAR2(20), ROOM_TYPE VARCHAR2(20));

#PATIENT AND ROOM
CREATE TYPE ASSIGNED_TYP AS OBJECT(PID REF PATIENT_TYP, ROOM_ID REF ROOM_TYP);

#PATIENT AND MEDICINE
CREATE TYPE IS_GIVEN_TYP AS OBJECT(QUANTITY NUMBER(20), PID REF PATIENT_TYP, CODE REF MEDICINE_TYP); 

#ROOM AND NURSE(EMPLOYEE)
CREATE TYPE ATTENDS_TO_TYP AS OBJECT(EID REF NURSE_TYP, ROOM_ID REF ROOM_TYP);

#TABLES
CREATE TABLE EMPLOYEE_TAB OF EMPLOYEE_TYP(EID PRIMARY KEY) OBJECT ID PRIMARY KEY;
CREATE TABLE DOCTOR_TAB OF DOCTOR_TYP;
CREATE TABLE NURSE_TAB OF NURSE_TYP;
CREATE TABLE PATIENT_TAB OF PATIENT_TYP(PID PRIMARY KEY) OBJECT ID PRIMARY KEY;
CREATE TABLE ROOM_TAB OF ROOM_TYP(ROOM_ID PRIMARY KEY) OBJECT ID PRIMARY KEY;
CREATE TABLE MEDICINE_TAB OF MEDICINE_TYP(CODE PRIMARY KEY) OBJECT ID PRIMARY KEY;

CREATE TABLE CARES_TAB OF CARES_TYP(FOREIGN KEY(PID) REFERENCES PATIENT_TAB, FOREIGN KEY (EID) REFERENCES DOCTOR_TAB ON DELETE CASCADE); 
CREATE TABLE ASSIGNED_TAB OF ASSIGNED_TYP(FOREIGN KEY(PID) REFERENCES PATIENT_TAB, FOREIGN KEY(ROOM_ID) REFERENCES ROOM_TAB ON DELETE CASCADE);
CREATE TABLE IS_GIVEN_TAB OF IS_GIVEN_TYP(FOREIGN KEY(PID) REFERENCES PATIENT_TAB, FOREIGN KEY(CODE) REFERENCES MEDICINE_TAB ON DELETE CASCADE);
CREATE TABLE ATTENDS_TO_TAB OF ATTENDS_TO_TYP(FOREIGN KEY(EID) REFERENCES NURSE_TAB, FOREIGN KEY(ROOM_ID) REFERENCES ROOM_TAB ON DELETE CASCADE)


#EMPLOYEE TABLE
INSERT INTO EMPLOYEE_TAB VALUES (1, 'PENKI', '1054641234', 'MALE', 50000, E_ADDRESS_TYP('EAST BROOKS', 'NORMAN', 'OK', 73071));
INSERT INTO EMPLOYEE_TAB VALUES (2, 'SUMITH', '2054641234', 'MALE', 150000, E_ADDRESS_TYP('SIDE STREET', 'DALLAS', 'TX', 53071));
INSERT INTO EMPLOYEE_TAB VALUES (3, 'PRAMOD', '3054641234', 'MALE', 80000, E_ADDRESS_TYP('HOO STREET', 'CALIFORNIA', 'CA', 63071));
INSERT INTO EMPLOYEE_TAB VALUES (4, 'RUSHI', '4054641234', 'MALE', 60000, E_ADDRESS_TYP('WEST BROOKS', 'OKLAHOMA CITY', 'OK', 73072));
INSERT INTO EMPLOYEE_TAB VALUES (5, 'AVINASH', '5054641234', 'MALE', 30000, E_ADDRESS_TYP('PEMBI STREET', 'HOUSTON', 'HU', 93071));
INSERT INTO EMPLOYEE_TAB VALUES (6, 'MAHESH', '6054641234', 'MALE', 90000, E_ADDRESS_TYP('NICE STREET', 'MIAMI', 'FL', 83071));
INSERT INTO EMPLOYEE_TAB VALUES (7, 'SURAJ', '7054641234', 'MALE', 95000, E_ADDRESS_TYP('SIDE STREET', 'DALLAS', 'TX', 53071));
INSERT INTO EMPLOYEE_TAB VALUES (8, 'LISA', '8054641234', 'FEMALE', 150000, E_ADDRESS_TYP('EAST BROOKS', 'BOSTON', 'MA', 93071));
INSERT INTO EMPLOYEE_TAB VALUES (9, 'GRUENWALD', '9054641234', 'FEMALE', 250000, E_ADDRESS_TYP('MAIN BROOKS', 'NORMAN', 'OK', 73071));
INSERT INTO EMPLOYEE_TAB VALUES (10, 'GRANT', '1054642345', 'MALE', 350000, E_ADDRESS_TYP('EAST BROOKS', 'NORMAN', 'OK', 73071));

#DOCTOR TABLE
INSERT INTO DOCTOR_TAB VALUES (1, 'PENKI', '1054641234', 'MALE', 50000, E_ADDRESS_TYP('EAST BROOKS', 'NORMAN', 'OK', 73071),'ENT SPECIALIST');
INSERT INTO DOCTOR_TAB VALUES (2, 'SUMITH', '2054641234', 'MALE', 150000, E_ADDRESS_TYP('SIDE STREET', 'DALLAS', 'TX', 53071), 'NEURO SURGEON');
INSERT INTO DOCTOR_TAB VALUES (4, 'RUSHI', '4054641234', 'MALE', 60000, E_ADDRESS_TYP('WEST BROOKS', 'OKLAHOMA CITY', 'OK', 73072), 'GENERAL PHISICIAN');
INSERT INTO DOCTOR_TAB VALUES (10, 'GRANT', '1054642345', 'MALE', 350000, E_ADDRESS_TYP('EAST BROOKS', 'NORMAN', 'OK', 73071), 'HAIR SPECIALIST');

#NURSE TABLE
INSERT INTO NURSE_TAB VALUES (3, 'PRAMOD', '3054641234', 'MALE', 80000, E_ADDRESS_TYP('HOO STREET', 'CALIFORNIA', 'CA', 63071), 'LEVEL1');
INSERT INTO NURSE_TAB VALUES (5, 'AVINASH', '5054641234', 'MALE', 30000, E_ADDRESS_TYP('PEMBI STREET', 'HOUSTON', 'HU', 93071), 'LEVEL2');
INSERT INTO NURSE_TAB VALUES (6, 'MAHESH', '6054641234', 'MALE', 90000, E_ADDRESS_TYP('NICE STREET', 'MIAMI', 'FL', 83071), 'LEVEL3');
INSERT INTO NURSE_TAB VALUES (7, 'SURAJ', '7054641234', 'MALE', 95000, E_ADDRESS_TYP('SIDE STREET', 'DALLAS', 'TX', 53071), 'LEVEL4');
INSERT INTO NURSE_TAB VALUES (8, 'LISA', '8054641234', 'FEMALE', 150000, E_ADDRESS_TYP('EAST BROOKS', 'BOSTON', 'MA', 93071), 'LEVEL5');
INSERT INTO NURSE_TAB VALUES (9, 'GRUENWALD', '9054641234', 'FEMALE', 250000, E_ADDRESS_TYP('MAIN BROOKS', 'NORMAN', 'OK', 73071), 'LEVEL6');

#PATIENT TABLE
INSERT INTO PATIENT_TAB VALUES ('101', 'SAMANTHA', 'FEMALE', 'OKLAHOMA', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(01, 2, 2018), DATE_DISCHARGED_TYP(22, 2, 2018)), CONTACT_NO_TYP('4054431345'));
INSERT INTO PATIENT_TAB VALUES ('102', 'RAM CHARAN', 'MALE', 'DALLAS', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(01, 1, 2016), DATE_DISCHARGED_TYP(21, 3, 2017)), CONTACT_NO_TYP('9054431345'));
INSERT INTO PATIENT_TAB VALUES ('103', 'MAHESH BABU', 'MALE', 'AUSTIN', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(29, 3, 2017), DATE_DISCHARGED_TYP(28, 7, 2018)), CONTACT_NO_TYP('6054431345'));
INSERT INTO PATIENT_TAB VALUES ('104', 'KAJAL', 'FEMALE', 'CALIFORNIA', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(10, 7, 2014), DATE_DISCHARGED_TYP(28, 8, 2015)), CONTACT_NO_TYP('7054431345'));
INSERT INTO PATIENT_TAB VALUES ('105', 'TAMANNA', 'FEMALE', 'HOUSTON', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(01, 1, 2015), DATE_DISCHARGED_TYP(01, 2, 2015)), CONTACT_NO_TYP('7054431345'));
INSERT INTO PATIENT_TAB VALUES ('106', 'TAMANNA', 'FEMALE', 'HOUSTON', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(01, 1, 2015), DATE_DISCHARGED_TYP(01, 2, 2015)), CONTACT_NO_TYP('7054431345','9876543210'));


#ROOM TABLE
INSERT INTO ROOM_TAB VALUES ('A101', 'TYPE 1');
INSERT INTO ROOM_TAB VALUES ('A102', 'TYPE 2');
INSERT INTO ROOM_TAB VALUES ('A103', 'TYPE 3');
INSERT INTO ROOM_TAB VALUES ('A104', 'TYPE 4');
INSERT INTO ROOM_TAB VALUES ('A105', 'TYPE 5');
INSERT INTO ROOM_TAB VALUES ('A106', 'TYPE 6');

#MEDICINE TABLE
INSERT INTO MEDICINE_TAB VALUES ('k1','citrizen');
INSERT INTO MEDICINE_TAB VALUES ('k2','biotin');
INSERT INTO MEDICINE_TAB VALUES ('k3','dolo');
INSERT INTO MEDICINE_TAB VALUES ('k4','keratin');
INSERT INTO MEDICINE_TAB VALUES ('k5','nice');
INSERT INTO MEDICINE_TAB VALUES ('k6','dizene');

#CARES TABLE
INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 101 AND D.EID = 1;
INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 102 AND D.EID = 1;
INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 103 AND D.EID = 2;
INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 104 AND D.EID = 4;
INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 105 AND D.EID = 10;

#ASSIGNED_TAB TABLE
INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 101 AND R.ROOM_ID = 'A101';
INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 102 AND R.ROOM_ID = 'A102';
INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 103 AND R.ROOM_ID = 'A101';
INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 104 AND R.ROOM_ID = 'A103';
INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 105 AND R.ROOM_ID = 'A104';

#IS_GIVEN_TAB TABLE
INSERT INTO IS_GIVEN_TAB SELECT 10, REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  101 AND M.CODE = 'k1';
INSERT INTO IS_GIVEN_TAB SELECT '20', REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  102 AND M.CODE = 'k3';
INSERT INTO IS_GIVEN_TAB SELECT '30', REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  101 AND M.CODE = 'k2';
INSERT INTO IS_GIVEN_TAB SELECT '20', REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  103 AND M.CODE = 'k1';
INSERT INTO IS_GIVEN_TAB SELECT '10', REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  104 AND M.CODE = 'k4';


INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 3 AND R.ROOM_ID = 'A102';
INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 5 AND R.ROOM_ID = 'A101';
INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 6 AND R.ROOM_ID = 'A104';
INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 7 AND R.ROOM_ID = 'A103';
INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 5 AND R.ROOM_ID = 'A104';


Queries:
#1
#PATIENT TABLE
INSERT INTO PATIENT_TAB VALUES ('101', 'SAMANTHA', 'FEMALE', 'OKLAHOMA', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(01, 2, 2018), DATE_DISCHARGED_TYP(22, 2, 2018)), CONTACT_NO_TYP('4054431345'));
INSERT INTO PATIENT_TAB VALUES ('102', 'RAM CHARAN', 'MALE', 'DALLAS', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(01, 1, 2016), DATE_DISCHARGED_TYP(21, 3, 2017)), CONTACT_NO_TYP('9054431345'));
INSERT INTO PATIENT_TAB VALUES ('103', 'MAHESH BABU', 'MALE', 'AUSTIN', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(29, 3, 2017), DATE_DISCHARGED_TYP(28, 7, 2018)), CONTACT_NO_TYP('6054431345'));
INSERT INTO PATIENT_TAB VALUES ('104', 'KAJAL', 'FEMALE', 'CALIFORNIA', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(10, 7, 2014), DATE_DISCHARGED_TYP(28, 8, 2015)), CONTACT_NO_TYP('7054431345'));
INSERT INTO PATIENT_TAB VALUES ('105', 'TAMANNA', 'FEMALE', 'HOUSTON', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(01, 1, 2015), DATE_DISCHARGED_TYP(01, 2, 2015)), CONTACT_NO_TYP('7054431345'));
INSERT INTO PATIENT_TAB VALUES ('106', 'TAMANNA', 'FEMALE', 'HOUSTON', STAY_PERIOD_TYP(DATE_ADMITTED_TYP(01, 1, 2015), DATE_DISCHARGED_TYP(01, 2, 2015)), CONTACT_NO_TYP('7054431345','9876543210'));


#2
INSERT INTO NURSE_TAB VALUES (3, 'PRAMOD', '3054641234', 'MALE', 80000, E_ADDRESS_TYP('HOO STREET', 'CALIFORNIA', 'CA', 63071), 'LEVEL1');
INSERT INTO NURSE_TAB VALUES (5, 'AVINASH', '5054641234', 'MALE', 30000, E_ADDRESS_TYP('PEMBI STREET', 'HOUSTON', 'HU', 93071), 'LEVEL2');
INSERT INTO NURSE_TAB VALUES (6, 'MAHESH', '6054641234', 'MALE', 90000, E_ADDRESS_TYP('NICE STREET', 'MIAMI', 'FL', 83071), 'LEVEL3');
INSERT INTO NURSE_TAB VALUES (7, 'SURAJ', '7054641234', 'MALE', 95000, E_ADDRESS_TYP('SIDE STREET', 'DALLAS', 'TX', 53071), 'LEVEL4');
INSERT INTO NURSE_TAB VALUES (8, 'LISA', '8054641234', 'FEMALE', 150000, E_ADDRESS_TYP('EAST BROOKS', 'BOSTON', 'MA', 93071), 'LEVEL5');
INSERT INTO NURSE_TAB VALUES (9, 'GRUENWALD', '9054641234', 'FEMALE', 250000, E_ADDRESS_TYP('MAIN BROOKS', 'NORMAN', 'OK', 73071), 'LEVEL6');

#3
Insert the complete information for a doctor and associate him/her with a patient.
INSERT INTO DOCTOR_TAB VALUES (1, 'PENKI', '1054641234', 'MALE', 50000, E_ADDRESS_TYP('EAST BROOKS', 'NORMAN', 'OK', 73071),'ENT SPECIALIST');
INSERT INTO DOCTOR_TAB VALUES (2, 'SUMITH', '2054641234', 'MALE', 150000, E_ADDRESS_TYP('SIDE STREET', 'DALLAS', 'TX', 53071), 'NEURO SURGEON');
INSERT INTO DOCTOR_TAB VALUES (4, 'RUSHI', '4054641234', 'MALE', 60000, E_ADDRESS_TYP('WEST BROOKS', 'OKLAHOMA CITY', 'OK', 73072), 'GENERAL PHISICIAN');
INSERT INTO DOCTOR_TAB VALUES (10, 'GRANT', '1054642345', 'MALE', 350000, E_ADDRESS_TYP('EAST BROOKS', 'NORMAN', 'OK', 73071), 'HAIR SPECIALIST');

INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 101 AND D.EID = 1;
INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 102 AND D.EID = 1;
INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 103 AND D.EID = 2;
INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 104 AND D.EID = 4;
INSERT INTO CARES_TAB SELECT REF(P), REF(D) FROM PATIENT_TAB P, DOCTOR_TAB D WHERE P.PID = 105 AND D.EID = 10;


#4
Insert the complete information for a room and associate it with a patient and a nurse.
INSERT INTO ROOM_TAB VALUES ('A101', 'TYPE 1');
INSERT INTO ROOM_TAB VALUES ('A102', 'TYPE 2');
INSERT INTO ROOM_TAB VALUES ('A103', 'TYPE 3');
INSERT INTO ROOM_TAB VALUES ('A104', 'TYPE 4');
INSERT INTO ROOM_TAB VALUES ('A105', 'TYPE 5');
INSERT INTO ROOM_TAB VALUES ('A106', 'TYPE 6');

INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 101 AND R.ROOM_ID = 'A101';
INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 102 AND R.ROOM_ID = 'A102';
INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 103 AND R.ROOM_ID = 'A101';
INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 104 AND R.ROOM_ID = 'A103';
INSERT INTO ASSIGNED_TAB SELECT REF(P), REF(R) FROM PATIENT_TAB P, ROOM_TAB R WHERE P.PID = 105 AND R.ROOM_ID = 'A104';

INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 3 AND R.ROOM_ID = 'A102';
INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 5 AND R.ROOM_ID = 'A101';
INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 6 AND R.ROOM_ID = 'A104';
INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 7 AND R.ROOM_ID = 'A103';
INSERT INTO ATTENDS_TO_TAB SELECT REF(N), REF(R) FROM NURSE_TAB N, ROOM_TAB R WHERE N.EID = 5 AND R.ROOM_ID = 'A104';

#5
nsert the complete information for a medicine and associate it with a patient.
INSERT INTO MEDICINE_TAB VALUES ('k1','citrizen');
INSERT INTO MEDICINE_TAB VALUES ('k2','biotin');
INSERT INTO MEDICINE_TAB VALUES ('k3','dolo');
INSERT INTO MEDICINE_TAB VALUES ('k4','keratin');
INSERT INTO MEDICINE_TAB VALUES ('k5','nice');
INSERT INTO MEDICINE_TAB VALUES ('k6','dizene');

INSERT INTO IS_GIVEN_TAB SELECT 10, REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  101 AND M.CODE = 'k1';
INSERT INTO IS_GIVEN_TAB SELECT '20', REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  102 AND M.CODE = 'k3';
INSERT INTO IS_GIVEN_TAB SELECT '30', REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  101 AND M.CODE = 'k2';
INSERT INTO IS_GIVEN_TAB SELECT '20', REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  103 AND M.CODE = 'k1';
INSERT INTO IS_GIVEN_TAB SELECT '10', REF(P), REF(M) FROM PATIENT_TAB P, MEDICINE_TAB M WHERE P.PID =  104 AND M.CODE = 'k4';

#6.
select p.pid, p.name, p.sex, p.address, p.stay_period.date_admitted.day, p.stay_period.date_admitted.month, p.stay_period.date_admitted.year, 
p.stay_period.date_discharged.day, p.stay_period.date_discharged.month, p.stay_period.date_discharged.year, p.contact_no from patient_tab p
WHERE (p.stay_period.date_admitted.year <=2017 AND
 p.stay_period.date_discharged.year>=2017)
AND (p.stay_period.date_admitted.month= 2)
OR 
(p.stay_period.date_admitted.month<2
AND p.stay_period.date_discharged.month >=2)

select p.pid, p.name, p.sex, p.address, p.stay_period.date_admitted.day, p.stay_period.date_admitted.month, p.stay_period.date_admitted.year, 
p.stay_period.date_discharged.day, p.stay_period.date_discharged.month, p.stay_period.date_discharged.year, p.contact_no from patient_tab p
WHERE (p.stay_period.date_admitted.year <=2016 AND
 p.stay_period.date_discharged.year>=2016)
AND (p.stay_period.date_admitted.month= 5)
OR 
(p.stay_period.date_admitted.month<5
AND p.stay_period.date_discharged.month >=5)

#7.
Find the complete information for all the doctors who care for more than two patients.
SELECT D.EID, D.E_NAME, D.CONTACT_NO, D.SEX, D.SALARY, D.E_ADDRESS.STREET, D.E_ADDRESS.CITY, D.E_ADDRESS.STATE, D.E_ADDRESS.ZIPCODE, D.SPECIALIZATION 
FROM DOCTOR_TAB D INNER JOIN CARES_TAB C ON D.EID = (C.EID).EID GROUP BY D.EID, D.E_NAME, D.CONTACT_NO, D.SEX, D.SALARY, D.E_ADDRESS.STREET, D.E_ADDRESS.CITY, D.E_ADDRESS.STATE, D.E_ADDRESS.ZIPCODE, D.SPECIALIZATION HAVING COUNT((C.PID).PID) > 2

#8.

SELECT N.EID, N.E_NAME, N.CONTACT_NO, N.SEX, N.SALARY, N.E_ADDRESS.STREET, N.E_ADDRESS.CITY, N.E_ADDRESS.STATE, N.E_ADDRESS.ZIPCODE, N.LEVEL1
FROM NURSE_TAB N 
INNER JOIN ATTENDS_TO_TAB AT ON N.EID = (AT.EID).EID
INNER JOIN ROOM_TAB R ON  (AT.ROOM_ID).ROOM_ID= R.ROOM_ID
INNER JOIN ASSIGNED_TAB A ON R.ROOM_ID = (A.ROOM_ID).ROOM_ID
INNER JOIN IS_GIVEN_TAB IG ON (A.PID).PID = (IG.PID).PID
WHERE (IG.CODE).CODE = 'k1'

SELECT N.EID, N.E_NAME, N.CONTACT_NO, N.SEX, N.SALARY, N.E_ADDRESS.STREET, N.E_ADDRESS.CITY, N.E_ADDRESS.STATE, N.E_ADDRESS.ZIPCODE, N.LEVEL1
FROM NURSE_TAB N 
INNER JOIN ATTENDS_TO_TAB AT ON N.EID = (AT.EID).EID
INNER JOIN ROOM_TAB R ON  (AT.ROOM_ID).ROOM_ID= R.ROOM_ID
INNER JOIN ASSIGNED_TAB A ON R.ROOM_ID = (A.ROOM_ID).ROOM_ID
INNER JOIN IS_GIVEN_TAB IG ON (A.PID).PID = (IG.PID).PID
WHERE (IG.CODE).CODE = 'k2'

#9
Delete all the patients who were discharged before a particular year.
DELETE
 from patient_tab p
WHERE p.stay_period.date_discharged.year < 2017

#10 Delete all the patients who have not been assigned a room.
DELETE FROM Patient_tab p
WHERE p.PID NOT IN (
SELECT (a.PID).PID FROM assigned_tab a
)








