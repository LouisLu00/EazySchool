package com.louis.EazySchool.Service;

import com.louis.EazySchool.Repository.ContactRepository;
import com.louis.EazySchool.constants.EazySchoolConstants;
import com.louis.EazySchool.controller.ContactController;
import com.louis.EazySchool.model.Contact;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j // generate a log object by using lombok
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;


    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        // Save the data into the database table
        contact.setStatus(EazySchoolConstants.OPEN);
        Contact savedContact = contactRepository.save(contact);
        if (savedContact.getContactId() > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findByStatus(EazySchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsg(int contactID) {
        boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactID);
        contact.ifPresent(contact1->{
            contact1.setStatus(EazySchoolConstants.CLOSE);
        });
        Contact updatedContact = contactRepository.save(contact.get());
        if (updatedContact != null && updatedContact.getUpdatedBy() != null) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
