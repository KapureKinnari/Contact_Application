package Rest;

import Binding.ContactForm;
import Service.ContactService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Slf4j
public class ContactRestController {

    @Autowired
    private ContactService service;

    @PostMapping("/save")
    public String saveContact(@RequestBody ContactForm form){
//        System.out.println(form);
        String status = service.saveContact(form);
        log.info("data added successfully");
        return status;
    }

    @GetMapping("/view")
    public List<ContactForm> viewContacts(){
        return service.viewContacts();
    }

    @GetMapping("/edit/{contactId}")
    public ContactForm editContact(@PathVariable  Integer contact_Id){
        return service.editContact(contact_Id);
    }

    @DeleteMapping("/delete/{contactId}")
    public List<ContactForm> deleteContacts(@PathVariable Integer contactId){
        return service.deleteContact(contactId);
    }
}
