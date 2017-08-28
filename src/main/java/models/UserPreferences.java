package models;

/**
 * Created by Guest on 8/28/17.
 */
public class UserPreferences {
    private Double maxBudget;
    private String season;
    private double latitude;
    private double longitude;
    private int nightLife;
    private int arts;
    private int outDoors;
    private int userId;
    private int id;

    public UserPreferences(Double maxBudget, String season, double latitude, double longitude, int nightLife, int arts, int outDoors, int userId) {
        this.maxBudget = maxBudget;
        this.season = season;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nightLife = nightLife;
        this.arts = arts;
        this.outDoors = outDoors;
        this.userId = userId;
    }

    //Getter
    public Double getMaxBudget() {
        return maxBudget;
    }
    public String getSeason() {
        return season;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
    public int getNightLife() {
        return nightLife;
    }
    public int getArts() {
        return arts;
    }
    public int getOutDoors() {
        return outDoors;
    }
    public int getUserId() {
        return userId;
    }
    public int getId() {
        return id;
    }

    //Setters

    public void setMaxBudget(Double maxBudget) {
        this.maxBudget = maxBudget;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setNightLife(int nightLife) {
        this.nightLife = nightLife;
    }

    public void setArts(int arts) {
        this.arts = arts;
    }

    public void setOutDoors(int outDoors) {
        this.outDoors = outDoors;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }
}
