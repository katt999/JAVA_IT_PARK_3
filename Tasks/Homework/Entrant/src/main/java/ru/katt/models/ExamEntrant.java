package ru.katt.models;

/**
 * Created by user on 08.02.2018.
 */
import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "exam_entrant", schema = "public")
//@IdClass(ExamAssociationId.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"entrant", "discipline"})
@Builder
public class ExamEntrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "entrant_id", updatable = false, insertable = false, referencedColumnName = "id")
    private Entrant entrant;

    @ManyToOne
    @JoinColumn(name = "discipline_id", updatable = false, insertable = false, referencedColumnName = "id")
    private Discipline discipline;

    private int mark;
}
