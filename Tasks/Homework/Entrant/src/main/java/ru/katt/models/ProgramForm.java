package ru.katt.models;

/**
 * Created by EVZabinskaya on 19.12.2017.
 */
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "program_form", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class ProgramForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}
