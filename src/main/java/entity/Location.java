package entity;

public class Location {
    private int id;
    private String country;
    private String region;
    private String city;

    /**
     * Instantiates a new location.
     */
    public Location() {
    }
    /**
     * Instantiates a new location.
     */
    public Location(int id, String country, String region, String city) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.city = city;
    }
    /**
     * Gets id.
     *
     * @return the location id
     */
    public int getId() {
        return id;
    }
    /**
     * Sets the location id
     *
     * @param id the location id
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * Gets country
     *
     * @return the country
     */
    public String getCountry() {
        return country;
    }
    /**
     * Sets the country
     *
     * @param country the artists id
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * Gets region
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }
    /**
     * Sets the region
     *
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }
    /**
     * Gets city
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }
    /**
     * Sets the city
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
