package models;

/**
 * Created by Guest on 8/28/17.
 */
public class UserPreferences {
    private Double maxBudget;
    private String season;
    private String latitude;
    private String longitude;
    private int nightLife;
    private int arts;
    private int outdoorsy;
    private int userId;
    private int id;

    public UserPreferences(Double maxBudget, String season, String latitude, String longitude, int nightLife, int arts, int outdoorsy, int userId) {
        this.maxBudget = maxBudget;
        this.season = season;
        this.latitude = latitude;
        this.longitude = longitude;
        this.nightLife = nightLife;
        this.arts = arts;
        this.outdoorsy= outdoorsy;
        this.userId = userId;
    }

    //Getter
    public Double getMaxBudget() {
        return maxBudget;
    }
    public String getSeason() {
        return season;
    }
    public String getLatitude() {
        return latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public int getNightLife() {
        return nightLife;
    }
    public int getArts() {
        return arts;
    }
    public int getOutdoorsy() {
        return outdoorsy;
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
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    public void setNightLife(int nightLife) {
        this.nightLife = nightLife;
    }
    public void setArts(int arts) {
        this.arts = arts;
    }
    public void setOutdoorsy(int outdoorsy) {
        this.outdoorsy= outdoorsy;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public void setId(int id) {
        this.id = id;
    }
}
