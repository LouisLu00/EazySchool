package com.louis.EazySchool.Service;

import com.louis.EazySchool.Repository.ContactRepository;
import com.louis.EazySchool.constants.EazySchoolConstants;
import com.louis.EazySchool.controller.ContactController;
import com.louis.EazySchool.model.Contact;
import com.louis.EazySchool.rowmappers.ContactRowMapper;
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

@Slf4j // generate a log object by using lombok
@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = false;
        // Save the data into the database table
        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if (result > 0) {
            isSaved = true;
        }
        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(EazySchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsg(int contactID, String updatedBy) {
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactID, EazySchoolConstants.CLOSE, updatedBy);
        if (result > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
