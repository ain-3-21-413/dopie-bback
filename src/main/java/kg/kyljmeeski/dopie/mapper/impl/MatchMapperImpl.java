package kg.kyljmeeski.dopie.mapper.impl;

import kg.kyljmeeski.dopie.dto.MatchDto;
import kg.kyljmeeski.dopie.dto.OutcomeDto;
import kg.kyljmeeski.dopie.dto.response.MatchResponse;
import kg.kyljmeeski.dopie.entity.Match;
import kg.kyljmeeski.dopie.enums.Status;
import kg.kyljmeeski.dopie.enums.Winner;
import kg.kyljmeeski.dopie.mapper.MatchMapper;
import kg.kyljmeeski.dopie.mapper.TeamMapper;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class MatchMapperImpl implements MatchMapper {

    final TeamMapper teamMapper;

    @Override
    public Match toMatch(MatchDto matchDto) {
        if (matchDto == null) {
            return null;
        }

        return Match.builder()
                .id(matchDto.id())
                .utcDate(
                        OffsetDateTime.parse(matchDto.utcDate(), DateTimeFormatter.ISO_OFFSET_DATE_TIME)
                            .toLocalDateTime()
                )
                .status(Status.valueOf(matchDto.status()))
                .homeTeam(teamMapper.toTeam(matchDto.homeTeam()))
                .awayTeam(teamMapper.toTeam(matchDto.awayTeam()))
                .winner(matchDto.status().equals("FINISHED") ? Winner.valueOf(matchDto.score().winner()) : null)
                .home_goals(matchDto.score().fullTime().home())
                .away_goals(matchDto.score().fullTime().away())
                .country(matchDto.area().name())
                .league(matchDto.competition().name())
                .build();
    }

    @Override
    public MatchResponse toMatchResponse(Match match) {
        if (match == null) {
            return  null;
        }

        List<OutcomeDto> outcomes = new ArrayList<>();
        outcomes.add(OutcomeDto.builder()
                    .name("Home")
                    .coefficient(1.5)
                    .count(5)
                    .build());
        outcomes.add(OutcomeDto.builder()
                .name("Draw")
                .coefficient(1.5)
                .count(5)
                .build());
        outcomes.add(OutcomeDto.builder()
                .name("Away")
                .coefficient(1.5)
                .count(5)
                .build());

        return MatchResponse.builder()
                .fixture(
                        MatchResponse.Fixture.builder()
                                .id(match.getId())
                                .home(match.getHomeTeam().getShortName())
                                .away(match.getAwayTeam().getShortName())
                                .time(match.getUtcDate().format(DateTimeFormatter.ofPattern("HH:mm")))
                                .date(match.getUtcDate().format(DateTimeFormatter.ofPattern("dd MMM")))
                                .country(match.getCountry())
                                .league(match.getLeague())
                                .build()
                )
                .outcomes(
                        outcomes
                )
                .build();
    }

}
