package kg.kyljmeeski.dopie.model;

import kg.kyljmeeski.dopie.dto.MatchDto;

import java.util.List;

public record MatchesModel(
        List<MatchDto> matches
) {
}
