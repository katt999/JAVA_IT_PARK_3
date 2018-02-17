package ru.katt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.katt.models.Entrant;

import java.util.List;
import java.util.stream.Collectors;


@Data
@AllArgsConstructor
@Builder
public class EntrantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private List<ExamEntrantDto> exams;

    public static EntrantDto from(Entrant model) {
        return EntrantDto.builder()
                .id(model.getId())
                .firstName(model.getFirstName())
                .lastName(model.getLastName())
                .middleName(model.getMiddleName())
                .exams(ExamEntrantDto.from(model.getExamEntrants()))
                .build();
    }

    public static List<EntrantDto> from(List<Entrant> entrants) {
        return entrants.stream().map(EntrantDto::from).collect(Collectors.toList());
    }
}
