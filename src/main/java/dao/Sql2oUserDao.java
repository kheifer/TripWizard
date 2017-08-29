package dao;

import models.User;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oUserDao implements UserDao {
    private final Sql2o sql2o;

    public Sql2oUserDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(User newUser) {
        String sql = "INSERT INTO users (name, duration) VALUES (:name, :duration)";
        try (Connection conn = sql2o.open()) {
            int id = (int) conn.createQuery(sql)
                    .bind(newUser)
                    .executeUpdate()
                    .getKey();
            newUser.setId(id);
        } catch (Sql2oException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateDuration(int id, int duration) {
        String sql = "UPDATE users SET duration = :duration WHERE id = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .addParameter("duration", duration)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM users WHERE id = :id";
        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User findById(int id) {
        String sql = "SELECT * FROM users WHERE id = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(User.class);
        }
    }

    @Override
    public List<User> getAll() {
        String sql = "SELECT * FROM users";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(User.class);
        }
    }
}
