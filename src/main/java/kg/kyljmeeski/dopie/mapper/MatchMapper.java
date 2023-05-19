package kg.kyljmeeski.dopie.mapper;

import kg.kyljmeeski.dopie.dto.MatchDto;
import kg.kyljmeeski.dopie.dto.response.MatchResponse;
import kg.kyljmeeski.dopie.entity.Match;

public interface MatchMapper {

    Match toMatch(MatchDto matchDto);

    MatchResponse toMatchResponse(Match match);
}
