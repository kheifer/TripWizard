package dao;


import models.Country;
import models.User;
import models.UserPreferences;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserPreferencesDao implements UserPreferencesDao{
    private Sql2o sql2o;

    public Sql2oUserPreferencesDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(UserPreferences userPreferences) {
        String query = "INSERT INTO user_preferences( maxBudget,  season,  latitude,  longitude, nightLife,  arts,  outdoorsy,  userId) VALUES ( :maxBudget,  :season,  :latitude,  :longitude, :nightLife,  :arts,  :outdoorsy,  :userId)";
   try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(query)
                    .bind(userPreferences)
                    .executeUpdate()
                    .getKey();
            userPreferences.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public UserPreferences findById(int id) {
        String query = "SELECT * FROM user_preferences WHERE id = :id";
        try(Connection con = sql2o.open()){
            return con.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(UserPreferences.class);
        }
    }

    @Override
    public List<UserPreferences> getAll() {
        String query = "SELECT * FROM user_preferences";
        try(Connection con = sql2o.open()){
            return con.createQuery(query)
                    .executeAndFetch(UserPreferences.class);
        }
    }

    @Override
    public void update(Double maxBudget, String season, String latitude, String longitude, int nightLife, int arts, int outdoorsy, int userId, int id) {
        String query = "UPDATE user_preferences SET (maxBudget, season, latitude, longitude, nightLife, arts, outdoorsy, userId) =(:maxBudget, :season, :latitude, :longitude, :nightLife, :arts, :outdoorsy, :userId) WHERE id = :id";
        try(Connection con = sql2o.open()){
            con.createQuery(query)
                    .addParameter("maxBudget", maxBudget)
                    .addParameter("season", season)
                    .addParameter("latitude", latitude)
                    .addParameter("longitude", longitude)
                    .addParameter("nightLife", nightLife)
                    .addParameter("arts", arts)
                    .addParameter("outdoorsy", outdoorsy)
                    .addParameter("userId", userId)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String query = "DELETE FROM user_preferences WHERE id = :id";
        try(Connection con = sql2o.open()){
             con.createQuery(query)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Country> budget(int id) {
        String query = "SELECT maxBudget FROM user_preferences WHERE id = :id";
        try(Connection con = sql2o.open()){
            Double maxBudget = (Double) con.createQuery(query)
                    .addParameter("id",id)
                    .executeAndFetchFirst(Double.class);
            String budget ="SELECT * FROM countries WHERE budget BETWEEN 0 AND :maxBudget";
            return con.createQuery(budget)
                    .addParameter("maxBudget", maxBudget)
                    .executeAndFetch(Country.class);
        }
    }

    @Override
    public List<Country> getAllCountries() {
        String query = "SELECT * FROM countries";
        try(Connection con = sql2o.open()){
            return con.createQuery(query)
                    .executeAndFetch(Country.class);
        }
    }

    @Override
    public List<Country> season(int id) {
        String query = "SELECT season FROM user_preferences WHERE id = :id";
        try(Connection con = sql2o.open()){
            String season = con.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(String.class);
            return con.createQuery("SELECT * FROM countries WHERE season = :season")
                    .addParameter("season", season)
                    .executeAndFetch(Country.class);
        }
    }

    public void seeder(){
        String first = "INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('America', 200, 'Summer','40.714846', '-74.004423', 5, 5, 4)";
        String second = "INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Belarus', 50,'Spring','53.912691', '27.563156',4, 1, 4)";
        String third = "INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Nepal', 25,'Summer', '27.717245','85.32396', 1, 1, 5)";
        String fourth = "INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ( 'Australia', 250,'Fall','-33.86882', '151.209296', 4, 3, 2)";
        String fifth = "INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Italy',130,'Fall','41.902783','12.496366', 4, 5, 4)";
       String sixth ="INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Ireland', 150,'Summer', '53.349805','-6.26031', 3, 3, 2)";
        String seventh = "INSERT INTO countries (name, budget, season, latitude, longitude, nightLife, arts, outdoorsy) VALUES ('Canada', 180,'Summer', '43.653226','-79.383184',3, 3, 5)";

        try(Connection con = sql2o.open()){
             con.createQuery(first)
                    .executeUpdate();
            con.createQuery(second)
                    .executeUpdate();
            con.createQuery(third)
                    .executeUpdate();
            con.createQuery(fourth)
                    .executeUpdate();
            con.createQuery(fifth)
                    .executeUpdate();
            con.createQuery(sixth)
                    .executeUpdate();
            con.createQuery(seventh)
                    .executeUpdate();
        }
    }
}
