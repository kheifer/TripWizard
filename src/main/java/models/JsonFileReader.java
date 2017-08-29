package models;

import jdk.nashorn.internal.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;

public class JsonFileReader {

    public void readJson() {
        JSONParser parser = new JSONParser();

        //FileReader fileReader = new FileReader("json/json.txt");
        BufferedReader reader = new BufferedReader(new FileReader("resources/json.txt"));
    }

}
