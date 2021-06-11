DROP TABLE IF EXISTS AppUsersRoles;
DROP TABLE IF EXISTS UserRoles;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS IMAGES;
DROP TABLE IF EXISTS CARS;
DROP TABLE IF EXISTS CAR_MAKE;

CREATE TABLE Users(
  id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  active int(11) NOT NULL,
  PRIMARY KEY(id),
  UNIQUE(email)
);

CREATE TABLE UserRoles(
   id INT NOT NULL AUTO_INCREMENT,
   type VARCHAR(30) NOT NULL,
   PRIMARY KEY (id),
   UNIQUE (type)
);

CREATE TABLE AppUsersRoles (
    userId INT NOT NULL,
    roleId INT NOT NULL,
    PRIMARY KEY (userId, roleId),
    FOREIGN KEY (userId) REFERENCES Users(id),
	FOREIGN KEY (roleId) REFERENCES UserRoles(id)
);

CREATE TABLE `images` (
  `image_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_car` int(11) DEFAULT NULL,
  `mimetype` varchar(255) DEFAULT NULL,
  `photo` longblob,
  PRIMARY KEY (`image_id`),
  FOREIGN KEY (id_car) REFERENCES cars(id_car)
);

CREATE TABLE `car_make` (
  `make_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `make` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`make_id`)
);
 CREATE TABLE `cars` (
  `id_car` bigint(20) NOT NULL AUTO_INCREMENT,
  `car_location` varchar(255) DEFAULT NULL,
  `fuel_type` varchar(255) DEFAULT NULL,
  `insurance_validity` varchar(255) DEFAULT NULL,
  `kilometers` int(11) NOT NULL,
  `make_id` bigint(20) DEFAULT NULL,
  `make_year` varchar(255) DEFAULT NULL,
  `owner` int(11) NOT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `price` int(11) NOT NULL,
  `registration_year` varchar(255) DEFAULT NULL,
  `rto` varchar(255) DEFAULT NULL,
  `transmission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_car`),
  FOREIGN KEY (make_id) REFERENCES car_make(make_id)
);


