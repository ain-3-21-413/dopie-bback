package kg.kyljmeeski.dopie.dto;

import lombok.Builder;
@Builder
public record OutcomeDto(
        String name,
        double coefficient,
        int count
) {

}
