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
    nightLife INTEGER,
    arts INTEGER,
    outdoorsy INTEGER,
);

INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ("America", 200, "Summer","40.714846", "-74.004423", 5, 5, 4);

