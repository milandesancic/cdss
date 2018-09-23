--Dodavanje doktora
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (1,'admin','admin','Milan','Desancic','ADMIN');
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (2,'doktor1','doktor1','Milica','Desancic','DOCTOR');
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (3,'doktor2','doktor2','Vladimir','Indjic','DOCTOR');
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (4,'doktor3','doktor3','Zarko','Drageljevic','DOCTOR');

--Dodavanje pacijenata
insert into cdss_db.patient(id,first_name,last_name) values (1,'Pera','Peric');
insert into cdss_db.patient(id,first_name,last_name) values (2,'Zika','Zikic');
insert into cdss_db.patient(id,first_name,last_name) values (3,'Aleksandar','Kolarov');

insert into cdss_db.patient(id,first_name,last_name) values (4,'Dusko','Tosic');
insert into cdss_db.patient(id,first_name,last_name) values (5,'Mile','Peric');
insert into cdss_db.patient(id,first_name,last_name) values (6,'Dusan','Tadic');

insert into cdss_db.patient(id,first_name,last_name) values (7,'Nemanja','Matic');
insert into cdss_db.patient(id,first_name,last_name) values (8,'Novak','Djokovic');

insert into cdss_db.patient(id,first_name,last_name) values (9,'Vladimir','Stojkovic');
insert into cdss_db.patient(id,first_name,last_name) values (10,'Filip','Kostic');

insert into cdss_db.patient(id,first_name,last_name) values (11,'Aleksandar','Mitorvic');
insert into cdss_db.patient(id,first_name,last_name) values (12,'Aleksandar','Prijovic');


--Dodavanje simpotoma
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(1,'Curenje iz nosa','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(2,'Bol u grlu','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(3,'Glavobolja','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(4,'Kijanje','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(5,'Kasalj','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(6,'Temperatura','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(7,'Drhtavica','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(8,'Bol koji se siri do usiju','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(9,'Umor','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(10,'Zuti sekret iz nosa','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(11,'Oticanje oko ociju','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(12,'Cesto uriniranje','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(13,'Gubitak telesne tezine','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(14,'Zamor','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(15,'Mucnina i povracanje','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(16,'Nocturia','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(17,'Otoci nogu i zglobova','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(18,'Gusenje','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(19,'Bol u grudima','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(20,'Oporavlja se od operacije','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(21,'Dijareja','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(22,'Gubitak apetita','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(23,'Visok krvni pritisak','GENERAL',0);
insert into cdss_db.symptom(id,name,symptom_type,symptom_value) values(24,'Oporavak od operacije','SPECIFIC',0);


--Dodavanje bolest
insert into cdss_db.disease(id,name) value (1,'Prehlada');
insert into cdss_db.disease(id,name) value (2,'Groznica');
insert into cdss_db.disease(id,name) value (3,'Upala krajnika');
insert into cdss_db.disease(id,name) value (4,'Sinusna infekcija');
insert into cdss_db.disease(id,name) value (5,'Hipertenzija');
insert into cdss_db.disease(id,name) value (6,'Dijabetes');
insert into cdss_db.disease(id,name) value (7,'Hronicna bubrezna bolest');
insert into cdss_db.disease(id,name) value (8,'Akutna bubrezna povreda');

--Dodavanje simptoma na prehladu
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (1,1);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (1,2);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (1,3);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (1,4);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (1,5);


--Dodavanje simptoma na groznicu
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (2,4);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (2,2);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (2,5);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (2,6);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (2,1);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (2,3);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (2,7);

--Dodavanje simptoma na upalu krjanika
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (3,2);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (3,8);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (3,3);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (3,6);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (3,7);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (3,22);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (3,9);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (3,10);

--Dodavanje simptoma na sinusnu infekciju
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (4,11);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (4,3);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (4,10);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (4,2);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (4,6);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (4,5);

--Dodavanje simptoma na  hipertenziju
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (5,23);

--Dodavanje simptoma na dijabetes
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (6,12);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (6,13);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (6,14);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (6,15);

--Dodavanje simptoma na hronicnu bubreznu bolest
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (7,14);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (7,16);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (7,17);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (7,18);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (7,19);

--Dodavanje simptoma na akutnu bureznu povredu
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (8,14);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (8,18);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (8,17);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (8,21);
insert into cdss_db.disease_symptoms(disease_id,symptoms_id) value (8,24);



--Dodavanje lekova
insert into cdss_db.medicine(id,medicine_type,name) value (1,'ANALGETIC','Aspirin');
insert into cdss_db.medicine(id,medicine_type,name) value (2,'ANALGETIC','Brufen');
insert into cdss_db.medicine(id,medicine_type,name) value (3,'ANALGETIC','Paracetamol');

insert into cdss_db.medicine(id,medicine_type,name) value (4,'ANTIBIOTIC','Amoksicilin');
insert into cdss_db.medicine(id,medicine_type,name) value (5,'ANTIBIOTIC','Cefaleksin');

insert into cdss_db.medicine(id,medicine_type,name) value (6,'OTHER','Aciklovir');
insert into cdss_db.medicine(id,medicine_type,name) value (7,'OTHER','Ranitidin');

--Dodavanje komponenti lekova
insert into cdss_db.medicine_component(id,name) values (1,'Komponenta 1');
insert into cdss_db.medicine_component(id,name) values (2,'Komponenta 2');
insert into cdss_db.medicine_component(id,name) values (3,'Komponenta 3');
insert into cdss_db.medicine_component(id,name) values (4,'Komponenta 4');
insert into cdss_db.medicine_component(id,name) values (5,'Komponenta 5');
insert into cdss_db.medicine_component(id,name) values (6,'Komponenta 6');
insert into cdss_db.medicine_component(id,name) values (7,'Komponenta 7');
insert into cdss_db.medicine_component(id,name) values (8,'Komponenta 8');



--Dodavanje komponente na lek

insert into cdss_db.medicine_components(medicine_id,components_id) values(1,1);
insert into cdss_db.medicine_components(medicine_id,components_id) values(1,4);
insert into cdss_db.medicine_components(medicine_id,components_id) values(1,6);

insert into cdss_db.medicine_components(medicine_id,components_id) values(2,1);
insert into cdss_db.medicine_components(medicine_id,components_id) values(2,2);
insert into cdss_db.medicine_components(medicine_id,components_id) values(2,7);

insert into cdss_db.medicine_components(medicine_id,components_id) values(3,6);
insert into cdss_db.medicine_components(medicine_id,components_id) values(3,1);
insert into cdss_db.medicine_components(medicine_id,components_id) values(3,2);

insert into cdss_db.medicine_components(medicine_id,components_id) values(4,3);
insert into cdss_db.medicine_components(medicine_id,components_id) values(4,5);
insert into cdss_db.medicine_components(medicine_id,components_id) values(5,8);

insert into cdss_db.medicine_components(medicine_id,components_id) values(5,3);
insert into cdss_db.medicine_components(medicine_id,components_id) values(5,5);

insert into cdss_db.medicine_components(medicine_id,components_id) values(6,2);
insert into cdss_db.medicine_components(medicine_id,components_id) values(6,8);
insert into cdss_db.medicine_components(medicine_id,components_id) values(6,6);

insert into cdss_db.medicine_components(medicine_id,components_id) values(7,1);
insert into cdss_db.medicine_components(medicine_id,components_id) values(7,4);
insert into cdss_db.medicine_components(medicine_id,components_id) values(7,8);


--Dodavanje na sta je pacijent alergican od lekova
insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (1,4);
insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (1,5);

insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (2,5);
insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (2,3);
insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (2,6);

insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (4,1);
insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (4,2);
insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (4,4);

insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (5,3);
insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (5,1);
insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (5,6);

insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (7,1);
insert into cdss_db.patient_medicine_allergies(patient_id,medicine_allergies_id) value (7,7);


--Dodavanje na sta je pacijent alergican od kompnenti lekova
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (1,8);
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (1,5);

insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (2,5);
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (2,3);
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (2,2);

insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (4,1);
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (4,4);
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (4,6);

insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (5,2);
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (5,4);
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (5,8);

insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (7,2);
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (7,1);
insert into cdss_db.patient_component_allergies(patient_id,component_allergies_id) value (7,7);

--Dodavanje bolesti na zapis

--1
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(1,'2018-03-10',1,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(2,'2018-06-15',2,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(3,'2018-09-15',1,3);
--2
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(4,'2018-04-02',1,4);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(5,'2018-06-27',3,2);


--4
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(6,'2018-08-15',1,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(7,'2018-08-30',2,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(8,'2018-09-10',2,3);
--5
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(9,'2018-08-15',2,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(10,'2018-08-30',1,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(11,'2018-09-10',2,3);
--6
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(12,'2018-08-15',1,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(13,'2018-08-30',1,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(14,'2018-09-10',2,3);

--7
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(15,'2018-04-10',2,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(16,'2018-05-02',1,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(17,'2018-05-22',4,4);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(18,'2018-06-01',5,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(19,'2018-06-30',4,4);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(20,'2018-07-03',4,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(21,'2018-07-15',3,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(22,'2018-07-30',1,4);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(23,'2018-08-10',4,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(24,'2018-08-25',4,4);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(25,'2018-09-10',2,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(26,'2018-09-20',4,3);

--8
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(27,'2018-04-10',2,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(28,'2018-05-02',1,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(29,'2018-05-22',3,4);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(30,'2018-06-01',3,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(31,'2018-06-30',3,4);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(32,'2018-07-03',3,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(33,'2018-07-15',3,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(34,'2018-07-30',1,4);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(35,'2018-08-10',5,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(36,'2018-08-25',3,4);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(37,'2018-09-10',2,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(38,'2018-09-20',1,3);

--9
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(39,'2015-02-01',5,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(40,'2018-04-12',6,2);
--insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(41,'2018-05-22',6,4);

--10
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(42,'2016-12-10',5,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(43,'2018-01-02',6,2);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(44,'2018-05-22',6,4);


--11
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(45,'2018-09-15',1,3);
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(46,'2018-09-18',2,2);


--12
insert into cdss_db.patient_record(id,date,disease_id,doctor_id) value(47,'2018-09-20',2,4);


--Dodavanje simptoma na bolest
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (15,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (16,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (17,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (18,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (19,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (20,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (21,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (22,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (23,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (24,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (25,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (26,23);

insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (27,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (28,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (29,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (30,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (31,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (32,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (33,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (34,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (35,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (36,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (37,23);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (38,23);


insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (45,6);
insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (46,6);

insert into cdss_db.patient_record_symptoms(record_id,symptoms_id) value (47,6);


--Dodavanje leka na zapis
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (45,4);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (46,5);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (47,4);

insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (15,4);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (16,5);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (17,5);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (18,4);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (19,5);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (20,4);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (22,5);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (23,4);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (24,5);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (25,4);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (26,4);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (27,4);

insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (28,1);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (29,2);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (30,3);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (31,1);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (32,2);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (33,3);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (34,2);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (35,2);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (36,3);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (37,1);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (38,1);
insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (39,2);

--Dodavanje bolesti na pacijenta

insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (1,1);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (1,2);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (1,3);

insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,4);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,5);


insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (4,6);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (4,7);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (4,8);

insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (5,9);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (5,10);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (5,11);

insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (6,12);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (6,13);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (6,14);


insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,15);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,16);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,17);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,18);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,19);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,20);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,21);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,22);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,23);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,24);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,25);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (7,26);

insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,27);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,28);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,29);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,30);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,31);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,32);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,33);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,34);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,35);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,36);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,37);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (8,38);


insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (9,39);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (9,40);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (9,41);

insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (10,42);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (10,43);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (10,44);


insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (11,45);
insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (11,46);

insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (12,47);





--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (1,1);
--
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,2);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,3);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,4);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,5);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,6);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,7);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,8);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,9);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,10);
--insert into cdss_db.patient_patient_history(patient_id,patient_history_id) value (2,11);









--Dodavanje leka na bolest
--insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (2,1);
--insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (3,2);
--insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (4,3);
--insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (5,1);
--insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (6,1);
--insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (7,2);
--insert into cdss_db.patient_record_medicine(record_id,medicine_id) value (8,2);









