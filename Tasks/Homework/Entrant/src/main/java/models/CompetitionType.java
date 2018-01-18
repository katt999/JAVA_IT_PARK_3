package models;

/**
 * Created by EVZabinskaya on 19.12.2017.
 */
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "competition_type", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class CompetitionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
}
