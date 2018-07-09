--Dodavanje doktora
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (1,'admin','admin','Milan','Desancic','ADMIN');
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (2,'doktor1','doktor1','Milica','Desancic','DOCTOR');
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (3,'doktor2','doktor2','Vladimir','Indjic','DOCTOR');
insert into cdss_db.cdss_user(id,username,password,firstname,lastname,role) values (4,'doktor3','doktor3','Zarko','Drageljevic','DOCTOR');

--Dodavanje kartona

insert into cdss_db.patient_record(id) values (1);
insert into cdss_db.patient_record(id) values (2);
insert into cdss_db.patient_record(id) values (3);
insert into cdss_db.patient_record(id) values (4);

--Dodavanje pacijenata
insert into cdss_db.patient(id,record_id,firstname,lastname) values (1,1,'Pera','Peric');
insert into cdss_db.patient(id,record_id,firstname,lastname) values (2,2,'Zika','Zikic');
insert into cdss_db.patient(id,record_id,firstname,lastname) values (3,3,'Aleksandar','Kolarov');
insert into cdss_db.patient(id,record_id,firstname,lastname) values (4,4,'Dusko','Tosic');


--Dodavanje simpotoma
insert into cdss_db.symptom(id,name) values(1,'Curenje iz nosa');
insert into cdss_db.symptom(id,name) values(2,'Bol u grlu');
insert into cdss_db.symptom(id,name) values(3,'Glavobolja');
insert into cdss_db.symptom(id,name) values(4,'Kijanje');
insert into cdss_db.symptom(id,name) values(5,'Kasalj');
insert into cdss_db.symptom(id,name) values(6,'Temperatura');
insert into cdss_db.symptom(id,name) values(7,'Drhtavica');
insert into cdss_db.symptom(id,name) values(8,'Bol koji se siri do usiju');
insert into cdss_db.symptom(id,name) values(9,'Umor');
insert into cdss_db.symptom(id,name) values(10,'Zuti sekret iz nosa');
insert into cdss_db.symptom(id,name) values(11,'Oticanje oko ociju');
insert into cdss_db.symptom(id,name) values(12,'Cesto uriniranje');
insert into cdss_db.symptom(id,name) values(13,'Gubitak telesne tezine');
insert into cdss_db.symptom(id,name) values(14,'Zamor');
insert into cdss_db.symptom(id,name) values(15,'Mucnina i povracanje	');
insert into cdss_db.symptom(id,name) values(16,'Nocturia');
insert into cdss_db.symptom(id,name) values(17,'Otoci nogu i zglobova');
insert into cdss_db.symptom(id,name) values(18,'Gusenje');
insert into cdss_db.symptom(id,name) values(19,'Bol u grudima');
insert into cdss_db.symptom(id,name) values(20,'Oporavlja se od operacije');
insert into cdss_db.symptom(id,name) values(21,'Dijareja');

--Dodavanje bolest
insert into cdss_db.disease(id,name) value (1,'Prehlada');
insert into cdss_db.disease(id,name) value (2,'Groznica');
insert into cdss_db.disease(id,name) value (3,'Upala krajnika');
insert into cdss_db.disease(id,name) value (4,'Sinusna infekcija');
insert into cdss_db.disease(id,name) value (5,'Hipertenzija');
insert into cdss_db.disease(id,name) value (6,'Dijabetes');
insert into cdss_db.disease(id,name) value (7,'Hronicna bubrezna bolest');
insert into cdss_db.disease(id,name) value (8,'Akutna bubrezna povreda');