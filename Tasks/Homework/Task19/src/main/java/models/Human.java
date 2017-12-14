package models;

/**
 * Created by EVZabinskaya on 05.12.2017.
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
public class Human {
    private int id;
    private String name;
    private int age;
    private String height;
    private List<Car> cars;
}