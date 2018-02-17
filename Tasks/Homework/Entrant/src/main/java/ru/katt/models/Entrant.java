package ru.katt.models;

/**
 * Created by EVZabinskaya on 16.12.2017.
 */

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "entrant_data", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "competitions")
@ToString(exclude = "competitions")
@Builder
public class Entrant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "middle_name")
    private String middleName;

    private String citizenship;

    @Column (name = "edu_document_number")
    private String eduDocumentNumber;

    @Column (name = "email")
    private String email;

    @ManyToMany
    @JoinTable(
            name="entrant_competition",
            joinColumns=@JoinColumn(name="entrant_id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="competition_id", referencedColumnName="id"))
    private List<Competition> competitions;

    @OneToMany(mappedBy="entrant")
    private List<ExamEntrant> examEntrants;

}
