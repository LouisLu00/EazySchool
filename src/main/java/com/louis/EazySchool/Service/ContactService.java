package com.louis.EazySchool.Service;

import com.louis.EazySchool.controller.ContactController;
import com.louis.EazySchool.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j // generate a log object by using lombok
@Service
public class ContactService {

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        // To Do: need to save the data into the database table
        log.info(contact.toString());
        return isSaved;
    }
}
