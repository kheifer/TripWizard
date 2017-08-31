package models;

/**
 * Created by Guest on 8/28/17.
 */
public class User {
    private String name;
    private int duration;
    private int id;

    public User (String name, int duration ){
        this.name = name;
        this.duration = duration;
    }

    //GETTERS
    public String getName() {
        return name;
    }
    public int getDuration() {
        return duration;
    }
    public int getId() {
        return id;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public void setId(int id) {
        this.id = id;
    }

    //EQUALS AND HASHCODE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (duration != user.duration) return false;
        return name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + duration;
        return result;
    }
}
