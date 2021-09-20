package org.persons.service;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.persons.service.data.Person;

@MicronautTest
class ApplicationTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Inject
    EmbeddedApplication<?> application;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testById() {
        Person person = client.toBlocking().retrieve(HttpRequest.GET("persons/100"), Person.class);

        Assertions.assertEquals("Narasimha", person.getfName());
    }
}
