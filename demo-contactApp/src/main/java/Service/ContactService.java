package Service;

import Binding.ContactForm;

import java.util.List;

public interface ContactService {

    public String saveContact(ContactForm form);

    public List<ContactForm> viewContacts();

    public ContactForm editContact(Integer contact_Id);

    public  List<ContactForm> deleteContact(Integer contact_id);
}
