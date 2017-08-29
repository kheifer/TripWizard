package dao;


import models.Country;
import models.UserPreferences;

import java.util.List;

public interface UserPreferencesDao {
    void add(UserPreferences userPreferences);

    UserPreferences findById(int id);

    List<UserPreferences> getAll();

    void update(Double maxBudget, String season, String latitude, String longitude, int nightLife, int arts, int outdoorsy, int userId, int id);

    void deleteById(int id);

    List<Country> budget(int id);

    List<Country> getAllCountries();

    List<Country> season(int id);

    List<Country> nightlife(int id);

    List<Country> outdoorsy(int id);

    List<Country> arts(int id);

}
