SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS users(
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    duration INTEGER
);

CREATE TABLE IF NOT EXISTS users_preferences(
    id int PRIMARY KEY auto_increment,
    budget DOUBLE,
    season VARCHAR,
    latitude DOUBLE,
    longitude DOUBLE,
    nightlife INTEGER,
    arts INTEGER,
    outdoorsy INTEGER,
    userId INTEGER
);


CREATE TABLE IF NOT EXISTS countries (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    budget DOUBLE,
    season VARCHAR,
    latitude VARCHAR,
    longitude VARCHAR,
    nightlife INTEGER,
    arts INTEGER,
    outdoorsy INTEGER,
);


