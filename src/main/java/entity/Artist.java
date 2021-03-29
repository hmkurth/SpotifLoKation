package entity;


/**
 * A class to represent an Artist.
 */
public class Artist {
    private String id;
    private String artist_name;
    private int location_id;

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
     * @param location_id  the location's id
     */
    public Artist(String id, String artist_name, int location_id) {
        this.id = id;
        this.artist_name = artist_name;
        this.location_id = location_id;
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
    /**
     * Gets id of artists location
     *
     * @return the artist's location as id
     */
    public int getLocation_id() {
        return location_id;
    }
    /**
     * Sets the artist location as id
     *
     * @param location_id the artists location
     */
    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", artist_name='" + artist_name + '\'' +
                ", location_id=" + location_id +
                '}';
    }
}
