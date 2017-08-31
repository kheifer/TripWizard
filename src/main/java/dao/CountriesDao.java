package dao;

import com.google.gson.Gson;
import models.Country;

import java.util.List;

public interface CountriesDao {

    void populate(String filePath);

    void add(Gson countryGson);

    List<Country> getAll();

    Country findByname(String name);


}
