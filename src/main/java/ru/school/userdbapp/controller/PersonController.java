package ru.school.userdbapp.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.school.userdbapp.entity.Person;
import ru.school.userdbapp.service.PersonService;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @GetMapping("/by-city")
    public List<Person> getPersonsByCity(@RequestParam String city) {
        return personService.getPersonsByCity(city);
    }

    @GetMapping("/younger-than")
    public List<Person> getPersonsYoungerThan(@RequestParam int age) {
        return personService.getPersonsYoungerThan(age);
    }

    @GetMapping("/by-name-surname")
    public Optional<Person> getPersonByNameAndSurname(
            @RequestParam String name,
            @RequestParam String surname) {
        return personService.getPersonByNameAndSurname(name, surname);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createPerson(@RequestBody Map<String, Object> request) {
        try {
            log.info("Raw request: {}", request);
            log.info("Name class: {}", request.get("name").getClass());
            log.info("Name value: {}", request.get("name"));

            Person person = new Person();
            person.setName(request.get("name").toString());
            person.setSurname(request.get("surname").toString());
            person.setAge(Integer.parseInt(request.get("age").toString()));

            if (request.containsKey("phoneNumber")) {
                person.setPhoneNumber(request.get("phoneNumber").toString());
            }
            if (request.containsKey("cityOfLiving")) {
                person.setCityOfLiving(request.get("cityOfLiving").toString());
            }

            log.info("Person before save: {}", person);
            Person savedPerson = personService.savePerson(person);
            return ResponseEntity.ok(savedPerson);
        } catch (Exception e) {
            log.error("Error details:", e);
            return ResponseEntity.badRequest().body(Map.of(
                    "error", e.getClass().getSimpleName(),
                    "message", e.getMessage(),
                    "request", request
            ));
        }
    }

    @DeleteMapping
    public void deletePerson(@RequestBody Person person) {
        personService.deletePerson(person);
    }

    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @GetMapping("/test")
    public String test() {
        return "Application is working!";
    }
}