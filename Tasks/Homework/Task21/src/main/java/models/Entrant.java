package models;

/**
 * Created by EVZabinskaya on 16.12.2017.
 */

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class Entrant {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date birthDate;
    private String citizenship;
    private int eduDocumentKindId;
    private String eduDocumentNumber;
    private double eduDocumentAverageMark;
}
