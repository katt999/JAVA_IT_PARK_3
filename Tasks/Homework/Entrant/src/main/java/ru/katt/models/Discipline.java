package ru.katt.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "discipline", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

/**
 * Created by user on 06.02.2018.
 */
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy="discipline")
    private List<ExamEntrant> entrants;

}
