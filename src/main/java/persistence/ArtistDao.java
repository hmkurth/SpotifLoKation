package persistence;

import entity.Artist;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class ArtistDao {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all artists
     *
     * @return the list of all artists
     */
    public List<Artist> getAllArtists() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Artist> query = builder.createQuery(Artist.class);
        Root<Artist> root = query.from(Artist.class);
        List<Artist> artists = session.createQuery(query).getResultList();
        session.close();
        return artists;
    }

    /**
     * update artist
     * @param artist artist to be updated
     */
    public void update(Artist artist) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(artist);
        transaction.commit();
        session.close();
    }

    /**
     * insert artist
     * @param artist artist to be inserted
     * @return id of artist inserted
     */
    public int insert(Artist artist) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(artist);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete an Artist
     * @param artist artist to be deleted
     */
    public void delete(Artist artist) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(artist);
        transaction.commit();
        session.close();
    }
    /**
     * Gets a artist by id
     * @param id artist id to search by
     * @return a artist
     */
    public Artist getById(String id) {
        Session session = sessionFactory.openSession();
        Artist artist = session.get(Artist.class, id);
        session.close();
        return artist;
    }
}
