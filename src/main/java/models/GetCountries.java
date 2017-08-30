package models;

import java.util.*;


public class GetCountries {

    public static List<Country> getResults(List<Country> arts, List<Country> nightlife, List<Country> outdoorsy, List<Country> season, List<Country> budget) {

        arts.retainAll(nightlife);
        outdoorsy.retainAll(season);
        arts.retainAll(outdoorsy);
        arts.retainAll(budget);


        if (arts.isEmpty())
        {
            arts.add(season.get(0));
        }

        return arts;
    }
}
