package models;

/**
 * Created by EVZabinskaya on 16.12.2017.
 */

import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entrant_data", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
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

    @Column (name = "birth_date")
    private Date birthDate;

    private String citizenship;

    @Column (name = "edu_document_kind_id")
    private int eduDocumentKindId;

    @Column (name = "edu_document_number")
    private String eduDocumentNumber;

    @Column (name = "edu_document_average_mark")
    private double eduDocumentAverageMark;
}
