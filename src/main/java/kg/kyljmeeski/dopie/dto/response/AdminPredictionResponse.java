package kg.kyljmeeski.dopie.dto.response;

import kg.kyljmeeski.dopie.dto.OutcomeDto;
import kg.kyljmeeski.dopie.entity.AdminPrediction;
import kg.kyljmeeski.dopie.entity.User;
import lombok.Builder;

import java.util.List;

@Builder
public record AdminPredictionResponse(
        Article article,
        List<OutcomeDto> outcomes
) {

    @Builder
    public record Article(

            Fixture fixture,
            Preview preview
    ) {
    }

    @Builder
    public record Fixture(
            String country,
            String league,
            String time,
            String date,
            String home,
            String away
    ) {
    }

    @Builder
    public record Preview(
            String intro,
            Lineups lineups,
            Predictions predictions,
            Author author
    ){
    }

    @Builder
    public record Lineups(
            Side home,
            Side away
    ) {
    }

    @Builder
    public record Side(
            String formation,
            String lineup,
            String willMiss
    ){
    }

    @Builder
    public record Predictions(
            String forMainOutcomes
    ){
    }

    @Builder
    public record Author(
            String id,
            String name
    ){
    }
}

