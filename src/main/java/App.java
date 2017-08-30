import dao.Sql2oCountriesDao;
import dao.Sql2oUserDao;
import dao.Sql2oUserPreferencesDao;
import models.Country;
import models.User;
import models.UserPreferences;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

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
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/homepage", (request, response) -> {
           // Map<String, Object> model = new HashMap<>();
            return new ModelAndView(new HashMap<String, Object>(), "homepage.hbs");
        }, new HandlebarsTemplateEngine());

        post("/questions", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int duration = Integer.parseInt(request.queryParams("duration"));
            User newUser = new User(name, duration);
            userDao.add(newUser);
            model.put("userId", newUser.getId());
            model.put("userName", newUser.getName());
            return new ModelAndView(model, "questions.hbs");
        }, new HandlebarsTemplateEngine());

        post("/:userId/suggestions", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int userId = Integer.parseInt(request.params("userId"));
            Double maxBudget = Double.parseDouble(request.queryParams("maxBudget"));
            String season = request.queryParams("season");
//            String latitude = request.queryParams("latitude");
//            String longtitude = request.queryParams("longitude");
            int nightlife = Integer.parseInt(request.queryParams("nightlife"));
            int outdoorsy = Integer.parseInt(request.queryParams("outdoorsy"));
            int arts = Integer.parseInt(request.queryParams("arts"));
            userPreferencesDao.add(new UserPreferences(maxBudget, season, "112.232", "-12.324", nightlife, outdoorsy, arts, userId));
//            List<Country> matches = userPreferencesDao.findMatches(userId);
//            model.put("matches", matches);
            return new ModelAndView(model, "matchingCountries.hbs");
        }, new HandlebarsTemplateEngine());

    }
}