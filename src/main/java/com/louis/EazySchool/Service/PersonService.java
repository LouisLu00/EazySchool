package com.louis.EazySchool.Service;

import com.louis.EazySchool.Repository.PersonRepository;
import com.louis.EazySchool.Repository.RolesRepository;
import com.louis.EazySchool.constants.EazySchoolConstants;
import com.louis.EazySchool.model.Person;
import com.louis.EazySchool.model.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    PersonRepository personRepository;

    @Autowired
    PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person) {
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(EazySchoolConstants.STUDENT_ROLE);
        person.setRole(role);
        personRepository.save(person);

        if(null != person && person.getPersonId() > 0){
            isSaved = true;
        }
        return isSaved;
    }

}
