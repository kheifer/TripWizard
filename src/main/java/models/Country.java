package models;


public class Country {
    private int id;
    private String name;
    private String longitude;
    private String latitude;
    private double budget;
    private String season;
    private int arts;
    private int nightlife;
    private int outdoorsy;


    public Country(String name, String longitude, String latitude, double budget, String season, int arts, int nightlife, int outdoorsy) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.budget = budget;
        this.season = season;

        this.arts = arts;
        this.nightlife = nightlife;
        this.outdoorsy = outdoorsy;
    }

    // getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public double getBudget() {
        return budget;
    }

    public String getSeason() {
        return season;
    }

    public int getArts() {
        return arts;
    }

    public int getNightlife() {
        return nightlife;
    }

    public int getOutdoorsy() {
        return outdoorsy;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public void setArts(int arts) {
        this.arts = arts;
    }

    public void setNightlife(int nightlife) {
        this.nightlife = nightlife;
    }

    public void setOutdoorsy(int outdoorsy) {
        this.outdoorsy = outdoorsy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (Double.compare(country.budget, budget) != 0) return false;
        if (arts != country.arts) return false;
        if (nightlife != country.nightlife) return false;
        if (outdoorsy != country.outdoorsy) return false;
        if (!name.equals(country.name)) return false;
        if (!longitude.equals(country.longitude)) return false;
        if (!latitude.equals(country.latitude)) return false;
        return season.equals(country.season);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + longitude.hashCode();
        result = 31 * result + latitude.hashCode();
        temp = Double.doubleToLongBits(budget);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + season.hashCode();
        result = 31 * result + arts;
        result = 31 * result + nightlife;
        result = 31 * result + outdoorsy;
        return result;
    }
}
