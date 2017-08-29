package dao;


import models.UserPreferences;

public interface UserPreferencesDao {
    void add(UserPreferences userPreferences);

    UserPreferences findById(int id);

    void update(Double maxBudget, String season, String latitude, String longitude, int nightLife, int arts, int outDoors, int userId, int id);

    void deleteById(int id);
}
