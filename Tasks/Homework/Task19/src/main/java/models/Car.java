package models;

/**
 * Created by EVZabinskaya on 05.12.2017.
 */
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode//(exclude = "owner")
@ToString//(exclude = "owner")
public class Car {
    private int id;
    private String number;
    private String color;
    private String model;
    private Human owner;
}