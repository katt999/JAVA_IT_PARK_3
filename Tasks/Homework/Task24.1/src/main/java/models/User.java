package models;

/**
 * Created by EVZabinskaya on 24.12.2017.
 */
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "cars")
@Builder
public class User {
    private Long id;
    private String name;
    private int age;
    private int height;
    private List<Car> cars;
}
