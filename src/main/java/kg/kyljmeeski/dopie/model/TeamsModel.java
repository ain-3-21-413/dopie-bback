package kg.kyljmeeski.dopie.model;

import kg.kyljmeeski.dopie.dto.TeamDto;

import java.util.List;

public record TeamsModel(
        Competition competition,
        List<TeamDto> teams
) {
    public record Competition(
            String id,
            String name
    ) {
    }
}
