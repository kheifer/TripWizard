SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS users(
    id int PRIMARY KEY auto_increment,
    name VARCHAR,
    duration INTEGER
);

CREATE TABLE IF NOT EXISTS users_preferences(
    id int PRIMARY KEY auto_increment,
    maxBudget DOUBLE,
    season VARCHAR,
    latitude DOUBLE,
    longitude DOUBLE,
    nightLife INTEGER,
    arts INTEGER,
    outDoors INTEGER,
    userId INTEGER
);



