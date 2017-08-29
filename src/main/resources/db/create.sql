SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS users(
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    duration INTEGER
);

CREATE TABLE IF NOT EXISTS user_preferences(
    id int PRIMARY KEY auto_increment,
    maxBudget DOUBLE,
    season VARCHAR,
    latitude DOUBLE,
    longitude DOUBLE,
    nightLife INTEGER,
    arts INTEGER,
    outdoors INTEGER,
    userId INTEGER
);


CREATE TABLE IF NOT EXISTS countries (
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    budget DOUBLE,
    season VARCHAR,
    latitude VARCHAR,
    longitude VARCHAR,
    nightLife INTEGER,
    arts INTEGER,
    outdoorsy INTEGER,
);


