package dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import org.sql2o.Connection;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/29/17.
 */
public class Sql2oUserPreferencesDaoTest {

    private Sql2oUserPreferencesDao userPreferencesDao;
    private Connection con;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString,"","");
        userPreferencesDao = new Sql2oUserPreferencesDao((sql2o));
        con = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        con.close();
    }

    @Test
    public void add() throws Exception {

    }

    @Test
    public void findById() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

}