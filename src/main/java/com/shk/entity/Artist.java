package com.shk.entity;


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
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "artist_location",
            joinColumns = { @JoinColumn(name = "artist_id") },
            inverseJoinColumns = { @JoinColumn(name = "location_id") }
    )
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
}
