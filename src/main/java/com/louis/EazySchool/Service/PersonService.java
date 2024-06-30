package com.louis.EazySchool.Service;

import com.louis.EazySchool.Repository.PersonRepository;
import com.louis.EazySchool.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    PersonRepository personRepository;

    @Autowired
    PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

}
