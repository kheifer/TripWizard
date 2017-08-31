package dao;

import models.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/29/17.
 */
public class Sql2oUserDaoTest {
    private Connection conn;
    private Sql2oUserDao userDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:tripwizard;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        userDao = new Sql2oUserDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    // helper to create a new user
    public User createUser() {
        return new User("Alice", 10);
    }

    @Test
    public void add() throws Exception {
        User user = createUser();
        User userOne = createUser();
        userDao.add(user);
        userDao.add(userOne);
        assertEquals(2, userDao.getAll().size());
    }

    @Test
    public void updateDuration() throws Exception {
        User user = createUser();
        userDao.add(user);
        userDao.updateDuration(user.getId(), 14);
        User updatedUser = userDao.findById(user.getId());
        assertEquals(14, updatedUser.getDuration());
    }

    @Test
    public void deleteById() throws Exception {
        User user = createUser();
        userDao.add(user);
        userDao.deleteById(user.getId());
        assertEquals(0, userDao.getAll().size());
    }
}