package org.app.spring.dao;

import org.app.spring.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by meghad on 17/12/16.
 *
 * not using Hibernate Transaction, that is because it will be taken care by Spring framework.
 */
@Repository
public class PersonDAOImpl implements PersonDAO{
    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public void addPerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(p);
        logger.info("Person saved successfully, Person Details="+ p);
    }

    public void updatePerson(Person p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("Person updated successfully, Person Details="+p);
    }

    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        return personsList;
    }

    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+p);
        return p;
    }

    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = (Person) session.load(Person.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Person deleted successfully, person details="+p);
    }
}
