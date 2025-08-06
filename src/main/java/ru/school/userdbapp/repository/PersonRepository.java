package ru.school.userdbapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.school.userdbapp.entity.Person;
import ru.school.userdbapp.entity.PersonId;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, PersonId> {

    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(@Param("city") String city);
}