package org.app.spring.service;

//import org.app.spring.model.Person;

import org.app.spring.entity.Person;

import java.util.List;

/**
 * Created by meghad on 17/12/16.
 */
public interface PersonService {
    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);
}
