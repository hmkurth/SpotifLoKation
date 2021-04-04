package com.shk.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * A class to represent an Artist.
 */
@Entity(name="Artist")
@Table(name="artist")
public class Artist {
    @Id
    private String id;
    private String artist_name;


    @ManyToMany(/*cascade = { CascadeType.ALL },*/ fetch = FetchType.EAGER)
    @JoinTable(
            name = "artist_location",
            joinColumns = { @JoinColumn(name = "artist_id") },
            inverseJoinColumns = { @JoinColumn(name = "location_id") }
    )
    @JsonIgnore
    Set<Location> locations = new HashSet<>();

    /**
     * Instantiates a new Artist.
     */
    public Artist() {
    }
    /**
     * Instantiates a new Artist
     *
     * @param id the artists id
     * @param artist_name  the artist's name
     *
     */
    public Artist(String id, String artist_name) {
        this.id = id;
        this.artist_name = artist_name;
    }

    /**
     * @return an artist's locations
     */
    public Set<Location> getLocations() {
        return locations;
    }

    /**
     * @param locations
     */
    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    /**
     * Gets id.
     *
     * @return the artist's id
     */
    public String getId() {
        return id;
    }
    /**
     * Sets the artist id
     *
     * @param id the artists id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Gets aritsit's name
     *
     * @return the artist's name
     */
    public String getArtist_name() {
        return artist_name;
    }
    /**
     * Sets the artist name
     *
     * @param artist_name the artists name
     */
    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", artist_name='" + artist_name + '\'' +
                '}';
    }

    /**
     * Adds a location to the Artist's set of locations
     * @param location
     */
    public void addLocation(Location location) {
        this.locations.add(location);
        location.getArtists().add(this);

    }

    /**
     * Removes a location from the Artist's set of locations
     * @param location
     */
    public void removeLocation(Location location) {
        for(Location nextLocation : this.locations)
        {
            if(nextLocation.getId() == location.getId())
            {
                this.locations.remove(nextLocation);
                break;
            }
        }
        location.getArtists().remove(this);
    }
}
