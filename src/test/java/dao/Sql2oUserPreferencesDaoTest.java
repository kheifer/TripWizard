package dao;

import models.Country;
import models.UserPreferences;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import org.sql2o.Connection;

import java.util.List;

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
        UserPreferences userPreferences = newUserPref();
        int id = userPreferences.getId();
        userPreferencesDao.add(userPreferences);
        assertNotEquals(id, userPreferences.getId());
    }

    @Test
    public void findById() throws Exception {
        UserPreferences userPreferences = newUserPref();
        userPreferencesDao.add(userPreferences);
        int find = userPreferences.getId();
        UserPreferences found = userPreferencesDao.findById(find);
        assertEquals(userPreferences.getArts(), found.getArts());
    }
    public void getAll() throws Exception {
        UserPreferences userPreferences = newUserPref();
        UserPreferences userPreferences1 = newUserPref();
        userPreferencesDao.add(userPreferences);
        userPreferencesDao.add(userPreferences1);
        int count =userPreferencesDao.getAll().size();
        assertEquals(1, count);
    }

    @Test
    public void update() throws Exception {
        UserPreferences userPreferences = newUserPref();
        userPreferencesDao.add(userPreferences);
        userPreferencesDao.update(1200.0, "summer", "45", "45", 1, 3, 5, 1, 1);
        assertEquals("summer", userPreferencesDao.findById(1).getSeason());
    }

    @Test
    public void deleteById() throws Exception {
        UserPreferences userPreferences = newUserPref();
        userPreferencesDao.add(userPreferences);
        int count = userPreferencesDao.getAll().size();
        assertEquals(1, count);
        int find = userPreferences.getId();
        userPreferencesDao.deleteById(find);
        assertEquals(0, userPreferencesDao.getAll().size());
    }

    @Test
    public void budget() throws Exception{
        userPreferencesDao.seeder();
        UserPreferences userPreferences = newUserPref();
        userPreferencesDao.add(userPreferences);
        int id = userPreferences.getId();
        System.out.println(userPreferencesDao.getAllCountries().size());
        List<Country> countryList = userPreferencesDao.budget(1);
        System.out.println(userPreferencesDao.getAllCountries().size());
        System.out.println(userPreferencesDao.getAllCountries().size());
        System.out.println(userPreferencesDao.getAllCountries().size());
        assertEquals(6, countryList.size());
    }

    //helper method
    UserPreferences newUserPref(){
        return new UserPreferences(200.0, "spring", "45", "45", 3, 5, 5, 1);
    }

}