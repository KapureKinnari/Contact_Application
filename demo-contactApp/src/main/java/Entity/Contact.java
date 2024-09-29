package Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="CONTACT_DETAILS")
@Data
public class Contact {

    @Id
    @GeneratedValue
    @Column(name="CONTACT_ID")
    private Integer contact_Id;

    @Column(name="CONTACT_NAME")
    private String  contact_Name;

    @Column(name="CONTACT_EMAIL")
    private String  contact_Email;

    @Column(name="CONTACT_NUMBER")
    private Long  contact_Number;

    @Column(name="ACTIVE_SW")
    private String  active_Sw;

    @Column(name="CREATED_DATE")
    @CreationTimestamp
    private LocalDate created_Date;

    @Column(name="UPDATED_DATE")
    @UpdateTimestamp
    private LocalDate  updated_Date;


}
