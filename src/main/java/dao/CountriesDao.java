package dao;

import com.google.gson.Gson;

public interface CountriesDao {

    void populate(Gson countryGson);

    void deleteById(int id);

    void add(Gson countryGson);



}
