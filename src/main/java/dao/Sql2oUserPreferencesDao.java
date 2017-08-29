package dao;


import models.UserPreferences;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

public class Sql2oUserPreferencesDao implements UserPreferencesDao{
    private Sql2o sql2o;

    public Sql2oUserPreferencesDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(UserPreferences userPreferences) {
        String query = "INSERT INTO user_preferences( maxBudget,  season,  latitude,  longitude, nightLife,  arts,  outDoors,  userId) VALUES( :maxBudget,  :season,  :latitude,  :longitude, :nightLife,  :arts,  :outDoors,  :userId)";
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
        return null;
    }

    @Override
    public void update(Double maxBudget, String season, String latitude, String longitude, int nightLife, int arts, int outDoors, int userId, int id) {

    }

    @Override
    public void deleteById(int id) {

    }

}
