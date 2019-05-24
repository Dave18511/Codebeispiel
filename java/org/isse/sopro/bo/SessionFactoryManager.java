package org.isse.sopro.bo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 *
 * Generic Methods for the DB
 *
 */
public class SessionFactoryManager {

    private static SessionFactoryManager unique = null;
    private SessionFactory sessionFactory;

    private SessionFactoryManager() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     *
     * Saves an Entity in the Database
     *
     * @param entity
     * @param <T>
     */
    public <T> void save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
    }

    public <T> void merge(T entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.merge(entity);
        tx.commit();
    }

    /**
     *
     * Deletes the entity in the Database
     *
     * @param entity
     * @param <T>
     */
    public <T> void delete(T entity) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
    }

    /**
     *
     * Gets the User with the mail
     * TODO throwns an exception because Int expected but String found
     *
     * @param clazz
     * @param mail
     * @param <T>
     * @return
     */
    public <T> T getByMail(Class<T> clazz, String mail) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        T result = session.find(clazz, mail);
        tx.commit();
        return result;
    }

    /**
     *
     * gets all the User of given Typ from the Database in a List
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> getAll(Class<T> clazz) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        CriteriaQuery<T> criteria = session.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        List<T> result = session.createQuery(criteria).getResultList();
        tx.commit();
        return result;
    }

    /**
     *
     * Singleton instance of the Manager
     *
     * @return
     */
    public static SessionFactoryManager instance() {
        if (unique == null)
            unique = new SessionFactoryManager();
        return unique;
    }

    /**
     *
     * Closes the Connection to the Database
     *
     */
    public void close() {
        sessionFactory.close();
        unique = null;
    }
}
