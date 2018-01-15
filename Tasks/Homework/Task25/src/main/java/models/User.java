package models;

/**
 * Created by EVZabinskaya on 28.12.2017.
 */
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "owner")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
   // private int height;
}
