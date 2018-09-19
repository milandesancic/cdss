--Dodavanje doktora
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (1,'admin','admin','Milan','Desancic','ADMIN');
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (2,'doktor1','doktor1','Milica','Desancic','DOCTOR');
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (3,'doktor2','doktor2','Vladimir','Indjic','DOCTOR');
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (4,'doktor3','doktor3','Zarko','Drageljevic','DOCTOR');

--Dodavanje kartona

--insert into cdss_db.patient_record(id) values (1);
--insert into cdss_db.patient_record(id) values (2);
--insert into cdss_db.patient_record(id) values (3);
--insert into cdss_db.patient_record(id) values (4);

--Dodavanje pacijenata
--insert into cdss_db.patient(id,record_id,firstname,lastname) values (1,1,'Pera','Peric');
--insert into cdss_db.patient(id,record_id,firstname,lastname) values (2,2,'Zika','Zikic');
--insert into cdss_db.patient(id,record_id,firstname,lastname) values (3,3,'Aleksandar','Kolarov');
--insert into cdss_db.patient(id,record_id,firstname,lastname) values (4,4,'Dusko','Tosic');


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
