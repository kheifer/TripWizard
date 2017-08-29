package dao;


import models.User;

import java.util.List;

public interface UserDao {
    //Create
    void add(User newUser);

    //Update
    void updateDuration(int id, int duration);

    //Delete
    void deleteById(int id);

    //Read
    User findById(int id);
    List<User> getAll();
}
