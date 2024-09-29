package Service;

import Binding.ContactForm;
import Entity.Contact;
import Repsitory.ContactRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImplement implements ContactService{

    @Autowired
    private ContactRepo contactRepository;

    @Override
    public String saveContact(ContactForm form) {
        // here we will be copying the data from binding object to entity object.

        Contact entity =  new Contact();
        BeanUtils.copyProperties(form,entity);

        entity = contactRepository.save(entity);

        if(entity != null){
            return "CONTACT SAVED!!";
        }
        return "FAILED TO SAVE!!";
    }

    @Override
    public List<ContactForm> viewContacts() {

        List<ContactForm> contactData = new ArrayList<>();

        List<Contact> findall  = contactRepository.findAll();
        for(Contact entity : findall){
            ContactForm form = new ContactForm();
            BeanUtils.copyProperties(entity,form);
            contactData.add(form);
        }
        return contactData;
    }

    @Override
    public ContactForm editContact(Integer contact_Id) {

        Optional<Contact> findById = contactRepository.findById(contact_Id);
        if (findById.isPresent()){
            Contact entity = findById.get();
            ContactForm form = new ContactForm();
            BeanUtils.copyProperties(entity,form);
            return form;
        }
        return null;
    }

    @Override
    public List<ContactForm> deleteContact(Integer contact_id) {
        //Hard Delete -> It will be removed from Database also
        //Soft Delete -> It will only remove from UI.
        contactRepository.deleteById(contact_id);
        return viewContacts(); //beacuse we want the active records after the one record is deleted.
                               // so instead of writing sma ecode we are returning same viewContact() method.
    }
}
