package com.louis.EazySchool.Service;

import com.louis.EazySchool.controller.ContactController;
import com.louis.EazySchool.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private static Logger log = LoggerFactory.getLogger(ContactService.class);

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        // To Do: need to save the data into the database table
        log.info(contact.toString());
        return isSaved;
    }
}
