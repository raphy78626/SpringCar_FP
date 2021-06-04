/* office master data */
INSERT INTO offices_master (office_code, office_name, address, post_code, city, country) VALUES ('SPR-CV', 'Ciutat Vella', 'address', '08015', 'Barcelona', 'Spain')
INSERT INTO offices_master (office_code, office_name, address, post_code, city, country) VALUES ('SPR-NB', 'Nou Barris', 'address', '08015', 'Barcelona', 'Spain')
INSERT INTO offices_master (office_code, office_name, address, post_code, city, country) VALUES ('SPR-HG', 'Horta-Guinardó', 'address', '08015', 'Barcelona', 'Spain')
INSERT INTO offices_master (office_code, office_name, address, post_code, city, country) VALUES ('SPR-SG', 'Sarrià-Sant Gervasi', 'address', '08015', 'Barcelona', 'Spain')
INSERT INTO offices_master (office_code, office_name, address, post_code, city, country) VALUES ('SPR-LC', 'Les Corts', 'address', '08015', 'Barcelona', 'Spain')
INSERT INTO offices_master (office_code, office_name, address, post_code, city, country) VALUES ('SPR-GR', 'Gracia', 'address', '08015', 'Barcelona', 'Spain')
INSERT INTO offices_master (office_code, office_name, address, post_code, city, country) VALUES ('SPR-SA', 'Sants', 'address', '08015', 'Barcelona', 'Spain')
INSERT INTO offices_master (office_code, office_name, address, post_code, city, country) VALUES ('SPR-SM', 'Sant-Martí', 'address', '08015', 'Barcelona', 'Spain')
INSERT INTO offices_master (office_code, office_name, address, post_code, city, country) VALUES ('SPR-SA', 'Sant Andreu', 'address', '08015', 'Barcelona', 'Spain')
/* category */
INSERT INTO categories (cod_category, price_base, price_base_insurance, price_top_insurance, price_tire_and_glass_protection) VALUES ('CAT_SUP', '100.0', '900.50', '1200.0', '300.0')
INSERT INTO categories (cod_category, price_base, price_base_insurance, price_top_insurance, price_tire_and_glass_protection) VALUES ('CAT_MED', '50.0', '90.50', '600.0', '50.0')
INSERT INTO categories (cod_category, price_base, price_base_insurance, price_top_insurance, price_tire_and_glass_protection) VALUES ('CAT_ECO', '25.0', '50.50', '300.0', '25.0')
/* cars master data*/
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Audi A3 Cabrio', 'Audi', 'MANUAL','/images/cat_sup/audi-a3-cabrio-2d-weiss-offen.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Mercedes-Benz Clase C', 'Mercedes', 'MANUAL','/images/cat_sup/mb-c-klasse-4d-silber.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('BMW Serie 2 Active Tourer', 'BMW', 'MANUAL','/images/cat_sup/bmw-2er-active-tourer-5d-blau.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('BMW Serie 3 SW', 'BMW', 'MANUAL','/images/cat_sup/bmw-3er-kombi-grau.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('BMW i8', 'BMW', 'AUTOMATIC','/images/cat_sup/bmw-i8-2d-weiss-us.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('BMW X1 Aut', 'BMW', 'AUTOMATIC','/images/cat_sup/bmw-x1-5d-weiss.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Jaguar F-Type Coupé', 'Jaguar', 'AUTOMATIC','/images/cat_sup/jaguar-f-type-coupe-2d-silber.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Mercedes-Benz Clase A Aut', 'Mercedes', 'AUTOMATIC','/images/cat_sup/mb-a-klasse-5d-weiss.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Mercedes-Benz SLC Cabrio', 'Mercedes', 'MANUAL','/images/cat_sup/mb-slc-cabrio-2d-grau-offen.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('MINI One Cabrio', 'MINI', 'MANUAL','/images/cat_sup/mini-cooper-cabrio-2d-schwarz-offen.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Citroën C4 Cactus Aut', 'Citroën', 'AUTOMATIC','/images/cat_med/citroen-c4-cactus-5d-weiss.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('MINI', 'MINI', 'MANUAL','/images/cat_med/mini-cooper-3d-schwarz.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Opel Zafira', 'Opel', 'MANUAL','/images/cat_med/opel-zafira-5d-silber.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Peugeot Partner', 'Peugeot', 'MANUAL','/images/cat_med/peugeot-partner-tepee-van-braun.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('VW Golf', 'VW', 'MANUAL','/images/cat_med/vw-golf-5d-weiss.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('VW Golf SW', 'VW', 'MANUAL','/images/cat_med/vw-golf-kombi-grau.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('VW Polo Aut', 'VW', 'AUTOMATIC','/images/cat_med/vw-polo-5d-schwarz.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Ford Ka', 'Ford', 'MANUAL','/images/cat_eco/ford-ka-3d-blau.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Opel Corsa', 'Opel', 'MANUAL','/images/cat_eco/opel-corsa-5d-weiss.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Peugeot 308', 'Peugeot', 'MANUAL','/images/cat_eco/peugeot-308-5d-weiss.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('Smart Forfour', 'Smart', 'MANUAL','/images/cat_eco/smart-for-four-4d-lava.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)
--INSERT INTO cars (model, make, transmission, photo, kilometers, make_year, registration_year, owner, rto, insurance_validity, car_location, fuel_type, price, make_id) VALUES  ('VW Polo', 'VW', 'MANUAL','/images/cat_eco/vw-polo-5d-schwarz.png',1234,'Jan 2008', 'May 2008',2, 'AP 09','JUN 2020', 'Shaikpet, Hyderabad','PETROL', 100000, 8)

INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Wagon R 1.0')
INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Swift')
INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Baleno')
INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Celerio')
INSERT INTO car_make(make, model) VALUES ('Maruti Suzuki', 'Swift Dzire')


INSERT INTO car_make(make, model) VALUES ('Hyundai', 'Wagon R 1.0')
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