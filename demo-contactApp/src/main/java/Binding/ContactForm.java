package Binding;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ContactForm {

    private Integer contact_Id;
    private String  contact_Name;
    private String  contact_Email;
    private Long  contact_Number;
    private String  active_Sw;
    private LocalDate created_Date;
    private LocalDate  updated_Date;
}
