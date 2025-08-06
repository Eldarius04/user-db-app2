package ru.school.userdbapp.service;

import org.springframework.stereotype.Service;
import ru.school.userdbapp.entity.Person;
import ru.school.userdbapp.repository.PersonRepository;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }
}