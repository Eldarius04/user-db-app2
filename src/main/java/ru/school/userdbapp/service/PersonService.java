package ru.school.userdbapp.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.school.userdbapp.entity.Person;
import ru.school.userdbapp.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<Person> getPersonsByCity(String city) {
        return personRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonsYoungerThan(int age) {
        return personRepository.findByAgeLessThanOrderByAgeAsc(age);
    }

    public Optional<Person> getPersonByNameAndSurname(String name, String surname) {
        return personRepository.findByNameAndSurname(name, surname);
    }

    public Person savePerson(Person person) {
        log.info("Saving person: {}", person);
        try {
            Person saved = personRepository.save(person);
            log.info("Person saved successfully with ID: {} {} {}",
                    saved.getName(), saved.getSurname(), saved.getAge());
            return saved;
        } catch (Exception e) {
            log.error("Error saving person: {}", e.getMessage());
            throw e;
        }
    }

    public void deletePerson(Person person) {
        personRepository.delete(person);
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }
}