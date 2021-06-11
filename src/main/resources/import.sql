INSERT INTO UserRoles VALUES (1,'ADMIN'),(5,'BLOGGER'),(2,'CUSTOMER'),(3,'DELAER');


INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Wagon R 1.0')
INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Swift')
INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Baleno')
INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Celerio')
INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Swift Dzire')


INSERT INTO car_make(make, model) VALUES ('Hyundai', 'Grand i10')
INSERT INTO car_make(make, model) VALUES ('Hyundai', 'Elite i20')
INSERT INTO car_make(make, model) VALUES ('Hyundai', 'Eon')
INSERT INTO car_make(make, model) VALUES ('Hyundai', 'Creta')


INSERT INTO car_make(make, model) VALUES ('Honda', 'City')
INSERT INTO car_make(make, model) VALUES ('Honda', 'Amaze')
INSERT INTO car_make(make, model) VALUES ('Honda', 'Jazz')
INSERT INTO car_make(make, model) VALUES ('Honda', 'Brio')

INSERT INTO car_make(make, model) VALUES ('Volkswagen', 'Polo')
INSERT INTO car_make(make, model) VALUES ('Volkswagen', 'Ameo')
INSERT INTO car_make(make, model) VALUES ('Volkswagen', 'Vento')

INSERT INTO car_make(make, model) VALUES ('Renault', 'Kwid')
INSERT INTO car_make(make, model) VALUES ('Renault', 'Duster')

INSERT INTO car_make(make, model) VALUES ('Ford', 'EcoSport')
INSERT INTO car_make(make, model) VALUES ('Ford', 'Figo')
INSERT INTO car_make(make, model) VALUES ('Hyundai', 'Figo Aspire')


/* extras for test*/
INSERT INTO common_extras (description_extra, price) VALUES  ('Baby seat guaranteed (0-13kg / Group 0+)', '11.99')
INSERT INTO common_extras (description_extra, price) VALUES  ('Child seat guaranteed (9-36kg / Group 1/2/3)', '11.99')
INSERT INTO common_extras (description_extra, price) VALUES  ('Booster seat guaranteed (15 - 36kg / Group 2/3)', '9.99')
INSERT INTO common_extras (description_extra, price) VALUES  ('Snow chains', '18.33')
INSERT INTO common_extras (description_extra, price) VALUES  ('Ski & Snowboard rack', '18.33')
/*clients*/
INSERT INTO clients (name, surname, id_number, phone_number, email, address, city, country, user_name, password) VALUES ('Floren', 'Lopez', '53647852', '667854120', 'florentinolopez@gmail.com', 'C/ Roger de Lluria, 23','Sta Coloma de Gr', 'Spain', 'Flonchi', '3333')
INSERT INTO clients (name, surname, id_number, phone_number, email, address, city, country, user_name, password) VALUES ('Laura', 'García', '48569953', '688547412', 'lauris84@gmail.com', 'C/ Biscaia, 125','Barcelona', 'Spain', 'Lauriss', '2552')