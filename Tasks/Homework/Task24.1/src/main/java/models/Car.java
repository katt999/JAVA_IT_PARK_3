package models;

/**
 * Created by EVZabinskaya on 24.12.2017.
 */
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(exclude = "owner")
@ToString
public class Car {
    private Long id;
    private String number;
    private String color;
    private String model;
    private User owner;
}
