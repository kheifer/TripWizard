package dao;

import com.google.gson.Gson;

public interface CountriesDao {

    void populate(String filePath);

    void deleteById(int id);

    void add(Gson countryGson);



}
