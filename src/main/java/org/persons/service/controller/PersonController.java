package org.persons.service.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import org.persons.service.data.Person;

@Controller("/persons")
public class PersonController {

    @Get("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(Integer id) {
        Person person = new Person();
        person.setId(id);
        person.setfName("Narasimha");
        person.setlName("Gujja");
        person.setNickName("nani");
        return person;
    }
}
