package persistence;

import entity.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class LocationDao {
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets all locations
     *
     * @return the list of all locations
     */
    public List<Location> getAllLocations() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Location> query = builder.createQuery(Location.class);
        Root<Location> root = query.from(Location.class);
        List<Location> locations = session.createQuery(query).getResultList();
        session.close();
        return locations;
    }

    /**
     * update location
     * @param location location to be updated
     */
    public void update(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(location);
        transaction.commit();
        session.close();
    }

    /**
     * insert location
     * @param location location to be inserted
     * @return id of location inserted
     */
    public int insert(Location location) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(location);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a Location
     * @param location location to be deleted
     */
    public void delete(Location location) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(location);
        transaction.commit();
        session.close();
    }
    /**
     * Gets a location by id
     * @param id location id to search by
     * @return a location
     */
    public Location getById(int id) {
        Session session = sessionFactory.openSession();
        Location location = session.get(Location.class, id);
        session.close();
        return location;
    }
}
