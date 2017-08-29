package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class CountryTest {
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:epicodus;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void test() throws Exception {
       Country test =  conn.createQuery("SELECT * FROM countries WHERE id = :id")
                .addParameter("id", 3)
                .executeAndFetchFirst(Country.class);
       assertEquals("Nepal", test.getName());
    }

    @Test
    public void testBudget() throws Exception {
        List<Country> test = conn.createQuery("SELECT * FROM countries WHERE budget > :amount")
                .addParameter("amount", 100)
                .executeAndFetch(Country.class);
        assertEquals(2, test.size());
    }

}