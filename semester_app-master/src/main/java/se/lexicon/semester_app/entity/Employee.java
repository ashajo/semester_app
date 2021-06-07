package se.lexicon.semester_app.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Employee extends Person {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String mobile;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.DETACH, CascadeType.PERSIST,CascadeType.REFRESH})
    private List<VacationDay> vacationDay;
    private int savedVacation;
    private int yearlyVacationDay;
    private LocalDate dateOfEmployment;
    @ManyToOne
    private Company company;
//    private int userType;
//    @Column(nullable = false)
//    private String password;


}
