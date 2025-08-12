package ru.school.userdbapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // Добавьте этот импорт
import org.springframework.stereotype.Repository;
import ru.school.userdbapp.entity.Person;
import ru.school.userdbapp.entity.PersonId;
import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, PersonId> {

    // Метод для поиска по городу
    List<Person> findByCityOfLiving(String city);

    // Метод для поиска по возрасту (меньше указанного) с сортировкой по возрастанию
    List<Person> findByAgeLessThanOrderByAgeAsc(int age);

    // Метод для поиска по имени и фамилии (возвращает Optional)
    Optional<Person> findByNameAndSurname(String name, String surname);

    // Дополнительный метод с использованием JPQL
    @Query("SELECT p FROM Person p WHERE p.cityOfLiving = :city")
    List<Person> findPersonsByCityCustomQuery(String city);
}