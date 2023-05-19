package kg.kyljmeeski.dopie.dto.response;

import kg.kyljmeeski.dopie.dto.OutcomeDto;
import lombok.Builder;

import java.util.List;

@Builder
public record MatchResponse(
        Fixture fixture,
        List<OutcomeDto> outcomes
) {
    @Builder
    public record Fixture(
        String id,
        String home,
        String away,
        String time,
        String date,
        String country,
        String league
    ) {

    }
}

