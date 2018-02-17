package ru.katt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.katt.models.Entrant;
import ru.katt.models.ExamEntrant;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Builder
public class ExamEntrantDto {
    private int mark;
    private Long disciplineId;

    public static ExamEntrantDto from(ExamEntrant model) {
        return ExamEntrantDto.builder()
                .mark(model.getMark())
                .disciplineId(model.getDiscipline().getId())
                .build();
    }

    public static List<ExamEntrantDto> from(List<ExamEntrant> models) {
        return models.stream().map(ExamEntrantDto::from).collect(Collectors.toList());
    }
}
