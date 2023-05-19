package kg.kyljmeeski.dopie.mapper.impl;

import kg.kyljmeeski.dopie.dto.TeamDto;
import kg.kyljmeeski.dopie.entity.Team;
import kg.kyljmeeski.dopie.mapper.TeamMapper;

public class TeamMapperImpl implements TeamMapper {
    @Override
    public Team toTeam(TeamDto teamDto) {
        if (teamDto == null) {
            return null;
        }

        return Team.builder()
                .id(teamDto.id())
                .shortName(teamDto.shortName())
                .build();
    }

    @Override
    public TeamDto toTeamDto(Team team) {
        if (team == null) {
            return null;
        }

        return TeamDto.builder()
                .id(team.getId())
                .shortName(team.getShortName())
                .build();
    }
}
