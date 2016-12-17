package org.app.spring.entity;

import javax.persistence.*;

/**
 * Created by meghad on 17/12/16.
 *
 * Our entity bean maps to PERSON table in MySQL database,
 * notice that not annotated “name” and “country” fields with @Column annotation
 * because they are of same name.
 */
@Entity
@Table(name="person")
public class Person {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    private String country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
