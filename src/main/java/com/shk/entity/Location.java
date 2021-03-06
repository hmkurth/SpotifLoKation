package com.shk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name="Location")
@Table(name="location")
public class Location {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator = "native")
    @GenericGenerator(name="native",strategy="native")
    private int id;
    private String country;
    private String region;
    private String city;
    @ManyToMany(mappedBy = "locations", fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<Artist> artists = new HashSet<>();

    /**
     * Instantiates a new location.
     */
    public Location() {
    }
    /**
     * Instantiates a new location.
     */
    public Location(String country, String region, String city) {

        this.country = country;
        this.region = region;
        this.city = city;
    }

    /**
     * @return
     */
    public Set<Artist> getArtists() {
        return artists;
    }

    /**
     * @param artists
     */
    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
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
