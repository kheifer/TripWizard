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

--    INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('America', 200, 'Summer','40.714846', '-74.004423', 5, 5, 4);
--    INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Belarus', 50,'Spring','53.912691', '27.563156',4, 1, 4);
--    INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Nepal', 25,'Summer', '27.717245','85.32396', 1, 1, 5);
--    INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ( 'Australia"', 250,'Fall','-33.86882', '151.209296', 4, 3, 2);
--    INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Italy',130,'Fall','41.902783','12.496366', 4, 5, 4);
--    INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Ireland', 150,'Summer', '53.349805','-6.26031', 3, 3, 2);
--    INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Canada', 180,'Summer', '43.653226','-79.383184',3, 3, 5);
