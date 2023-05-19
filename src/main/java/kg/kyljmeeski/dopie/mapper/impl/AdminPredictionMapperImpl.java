package kg.kyljmeeski.dopie.mapper.impl;

import kg.kyljmeeski.dopie.dto.OutcomeDto;
import kg.kyljmeeski.dopie.dto.response.AdminPredictionResponse;
import kg.kyljmeeski.dopie.entity.AdminPrediction;
import kg.kyljmeeski.dopie.mapper.AdminPredictionMapper;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminPredictionMapperImpl implements AdminPredictionMapper {
    @Override
    public AdminPredictionResponse toAdminPredictionResponse(AdminPrediction adminPrediction) {

        List<OutcomeDto> outcomes = new ArrayList<>();

        outcomes.add(
                OutcomeDto.builder()
                        .name("Home")
                        .coefficient(1.5)
                        .count(5)
                        .build()
        );

        outcomes.add(
                OutcomeDto.builder()
                        .name("Draw")
                        .coefficient(1.5)
                        .count(5)
                        .build()
        );

        outcomes.add(
                OutcomeDto.builder()
                        .name("Away")
                        .coefficient(1.5)
                        .count(5)
                        .build()
        );

        return AdminPredictionResponse.builder()
                .article(
                        AdminPredictionResponse.Article.builder()
                                .fixture(
                                        AdminPredictionResponse.Fixture.builder()
                                                .country(
                                                        adminPrediction
                                                                .getMatch()
                                                                .getCountry()
                                                )
                                                .league(
                                                        adminPrediction
                                                                .getMatch()
                                                                .getLeague()
                                                )
                                                .time(
                                                        adminPrediction
                                                                .getMatch()
                                                                .getUtcDate()
                                                                .format(
                                                                        DateTimeFormatter.ofPattern("HH:mm")
                                                                )
                                                )
                                                .date(
                                                        adminPrediction
                                                                .getMatch()
                                                                .getUtcDate()
                                                                .format(
                                                                        DateTimeFormatter.ofPattern("dd MMM")
                                                                )
                                                )
                                                .home(adminPrediction.getMatch().getHomeTeam().getShortName())
                                                .away(adminPrediction.getMatch().getAwayTeam().getShortName())
                                                .build()
                                )
                                .preview(
                                        AdminPredictionResponse.Preview.builder()
                                                .intro(adminPrediction.getIntro())
                                                .lineups(
                                                        AdminPredictionResponse.Lineups.builder()
                                                                .home(
                                                                        AdminPredictionResponse.Side.builder()
                                                                                .formation(adminPrediction.getHomeFormation())
                                                                                .lineup(adminPrediction.getHomeLineup())
                                                                                .willMiss(adminPrediction.getHomeWillMiss())
                                                                                .build()
                                                                )
                                                                .away(
                                                                        AdminPredictionResponse.Side.builder()
                                                                                .formation(adminPrediction.getAwayFormation())
                                                                                .lineup(adminPrediction.getAwayLineup())
                                                                                .willMiss(adminPrediction.getHomeWillMiss())
                                                                                .build()
                                                                )
                                                                .build()
                                                )
                                                .author(
                                                        AdminPredictionResponse.Author.builder()
                                                                .id(adminPrediction.getAuthor().getId())
                                                                .name(adminPrediction.getAuthor().getUsername())
                                                                .build()
                                                )
                                                .build()
                                )
                                .build()
                )
                .outcomes(
                        outcomes
                )
                .build();
    }
}
