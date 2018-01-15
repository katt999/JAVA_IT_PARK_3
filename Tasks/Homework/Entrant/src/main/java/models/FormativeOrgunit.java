package models;

/**
 * Created by EVZabinskaya on 19.12.2017.
 */
import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "formative_orgunit", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class FormativeOrgunit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "short_title")
    private String shortTitle;

    @Column (name = "full_title")
    private String fullTitle;
}
