package org.app.spring.service;

import org.app.spring.dao.PersonDAO;
//import org.app.spring.model.Person;
import org.app.spring.entity.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by meghad on 17/12/16.
 *
 * spring declarative transaction management is applied by using @Transactional annotation
 */

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDAO personDAO;

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Transactional
    public void addPerson(Person p) {
        this.personDAO.addPerson(p);
    }

    @Transactional
    public void updatePerson(Person p) {
        this.personDAO.updatePerson(p);
    }

    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }

    @Transactional
    public Person getPersonById(int id) {
        return this.personDAO.getPersonById(id);
    }

    @Transactional
    public void removePerson(int id) {
        this.personDAO.removePerson(id);
    }
}
