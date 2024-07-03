package com.louis.EazySchool.Repository;

import com.louis.EazySchool.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person readByEmail(String email);
    Person findByEmail(String email);
}
