package dao;

import com.google.gson.Gson;
import models.Country;
import models.JsonFileReader;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oCountriesDao implements CountriesDao {
    private Sql2o sql2o;

    public Sql2oCountriesDao (Sql2o sql2o) {
        this.sql2o = sql2o;
    }



    @Override
    public void populate(String filepath) {
        List<Country> countries = new JsonFileReader(filepath).readJson();
        String sql ="INSERT INTO countries (name, budget, season, latitude, longitude, nightlife, arts, outdoorsy) VALUES (:name, :budget, :season, :latitude, :longitude, :nightlife, :arts, :outdoorsy)";

        try (Connection con = sql2o.open()) {
            for (Country country: countries) {
                int id = (int) con.createQuery(sql)
                        .bind(country)
                        .executeUpdate()
                        .getKey();
                country.setId(id);
            }
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }

    }

    @Override
    public void add(Gson countryGson) {

    }


    @Override
    public List<Country> getAll() {
        String sql = "SELECT * FROM countries";
        try (Connection con = sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Country.class);
        }
    }

    @Override
    public Country findByname(String name) {
        String query = "SELECT * FROM countries WHERE name = :name";
        try(Connection con = sql2o.open()){
            return con.createQuery(query)
                    .addParameter("name", name)
                    .executeAndFetchFirst(Country.class);
        }
    }

    @Override
    public Country pickARandomCountry() {
        String query = "SELECT * FROM countries ORDER BY RANDOM() LIMIT 1";
        try(Connection con = sql2o.open()){
            return con.createQuery(query)
                    .executeAndFetchFirst(Country.class);
        }
    }
}
