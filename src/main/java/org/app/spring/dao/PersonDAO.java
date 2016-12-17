package org.app.spring.dao;

import org.app.spring.entity.Person;

import java.util.List;

/**
 * Created by meghad on 17/12/16.
 * declare the methods
 */
public interface PersonDAO {

    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> listPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);
}
