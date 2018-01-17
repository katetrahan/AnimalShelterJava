SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS animals (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  gender VARCHAR,
--  dateOfAdmit TIMESTAMP,
  type VARCHAR,
  breed VARCHAR,
  adopted BOOLEAN,
--  animalId INTEGER
);

CREATE TABLE IF NOT EXISTS customer (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  phone VARCHAR,
  typePref VARCHAR,
  breedPref VARCHAR
);