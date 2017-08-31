import dao.Sql2oCountriesDao;
import dao.Sql2oUserDao;
import dao.Sql2oUserPreferencesDao;
import models.Country;
import models.User;
import models.UserPreferences;
import models.GetCountries;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.staticFileLocation;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/tripwizard.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oUserPreferencesDao userPreferencesDao = new Sql2oUserPreferencesDao(sql2o);
        Sql2oCountriesDao countriesDao = new Sql2oCountriesDao(sql2o);
        Sql2oUserDao userDao = new Sql2oUserDao(sql2o);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int size = countriesDao.getAll().size();
            if (size <= 0) {
                countriesDao.populate("/Users/Guest/Desktop/TripWizard/src/main/resources/json");
            }
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/homepage", (request, response) -> {

            return new ModelAndView(new HashMap<String, Object>(), "homepage.hbs");
        }, new HandlebarsTemplateEngine());


        post("/questions", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int duration = Integer.parseInt(request.queryParams("duration"));
            User newUser = new User(name, duration);
            userDao.add(newUser);
            model.put("id", newUser.getId());
            model.put("userName", newUser.getName());
            return new ModelAndView(model, "questions.hbs");
        }, new HandlebarsTemplateEngine());


        post("/:userId/suggestions", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int userId = Integer.parseInt(request.params("userId"));

            Double maxBudget = Double.parseDouble(request.queryParams("maxBudget"));
            String season = request.queryParams("season");
            int nightlife = Integer.parseInt(request.queryParams("nightlife"));
            int outdoorsy = Integer.parseInt(request.queryParams("outdoorsy"));
            int arts = Integer.parseInt(request.queryParams("arts"));

            UserPreferences newPref = new UserPreferences(maxBudget, season, "45.5266975", "-122.6880503", nightlife, outdoorsy, arts, userId);
            userPreferencesDao.add(newPref);
            int id = newPref.getId();

            List<Country> list1 = userPreferencesDao.arts(id);
            List<Country> list2 = userPreferencesDao.nightlife(id);
            List<Country> list3 = userPreferencesDao.outdoorsy(id);
            List<Country> list4 = userPreferencesDao.season(id);
            List<Country> list5 = userPreferencesDao.budget(id);
            List<Country> results = GetCountries.getResults(list1, list2, list3, list4, list5);

            model.put("matches", results);
            return new ModelAndView(model, "matchingCountries.hbs");
        }, new HandlebarsTemplateEngine());


        get("/:countryName/planning", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String countyName = request.params("countryName");
            model.put("name", countyName);
            return new ModelAndView(model, "planning.hbs");

        }, new HandlebarsTemplateEngine());


        //post: run a find function on the input
        post("/search", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String search1 = request.queryParams("search");
            Country newCountry = countriesDao.findByname(search1);
            model.put("country", newCountry);
            return new ModelAndView(model, "search.hbs");

        }, new HandlebarsTemplateEngine());
    }
}