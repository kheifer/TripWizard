package dao;

import models.Country;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

import static org.junit.Assert.*;

public class Sql2oCountriesDaoTest {
    private Connection conn;
    private Sql2oCountriesDao countryDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:tripwizard;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        countryDao = new Sql2oCountriesDao(sql2o);
        conn = sql2o.open();
        countryDao.populate("/Users/Guest/Desktop/TripWizard/src/main/resources/json");
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void populate() throws Exception {
        assertEquals(19, countryDao.getAll().size() );
    }

    @Test
    public void populateAddsIds() throws Exception {
        List<Country> test = countryDao.getAll();
        assertEquals(19, test.get(18).getId());
    }
}