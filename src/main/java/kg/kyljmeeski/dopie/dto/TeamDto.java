package kg.kyljmeeski.dopie.dto;

import lombok.Builder;

@Builder
public record TeamDto(
        String id,
        String shortName,
        Area area
) {
    public record Area(
            String name
    ) {

    }
}
