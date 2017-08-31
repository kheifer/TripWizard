package models;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonFileReader {
    private String fileName;

    public JsonFileReader(String fileName) {
        this.fileName = fileName;
    }

    public List<Country> readJson() {
        ArrayList<Country> countries = new ArrayList<>();
        BufferedReader reader = null;
        Gson gson = new Gson();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            Country[] countryArr = gson.fromJson(reader, Country[].class);
            for (Country c : countryArr) {
                countries.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return countries;
    }
}
