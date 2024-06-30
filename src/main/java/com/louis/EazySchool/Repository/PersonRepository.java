package com.louis.EazySchool.Repository;

import com.louis.EazySchool.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
}
