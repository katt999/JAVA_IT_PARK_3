package models;

/**
 * Created by EVZabinskaya on 19.12.2017.
 */
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder

public class ProgramForm {
    private int id;
    private String title;
}
