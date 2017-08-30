import dao.Sql2oCountriesDao;
import dao.Sql2oUserDao;
import dao.Sql2oUserPreferencesDao;
import models.Country;
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

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String connectionString = "jdbc:h2:~/team.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oUserPreferencesDao userPreferencesDao = new Sql2oUserPreferencesDao(sql2o);
        Sql2oCountriesDao countriesDao = new Sql2oCountriesDao(sql2o);

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());









    }
}

//    Country c1 = new Country("Russia");
//    Country c2 = new Country("Canada");
//    Country c3 = new Country("USA");
//    Country c4 = new Country("Germany");
//    Country c5 = new Country("Italy");
//    Country c6 = new Country("Kenya");
//
//    List<Country> one = new ArrayList<>();
//    List<Country> two = new ArrayList<>();
//    List<Country> three = new ArrayList<>();
//    List<Country> four = new ArrayList<>();
//    List<Country> five = new ArrayList<>();
//
//
//        one.add(c1);
////        one.add(c2);
////        one.add(c3);
////        one.add(c6);
//
////        two.add(c3);
//                two.add(c3);
////        two.add(c4);
////        two.add(c6);
//
//
//                three.add(c5);
////        three.add(c2);
////        three.add(c3);
////        three.add(c6);
//
//                four.add(c2);
////        four.add(c4);
////        four.add(c5);
////        four.add(c6);
//
//                five.add(c4);
////        five.add(c4);
////        five.add(c5);
////        five.add(c6);
//
//
//
//                System.out.println(GetCountries.getResults(one, two, three, four, five));
////List<Country> finalList =   GetCountries.getResults(one, two);
//
////System.out.println(finalList);
