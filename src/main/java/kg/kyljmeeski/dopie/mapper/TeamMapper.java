package kg.kyljmeeski.dopie.mapper;

import kg.kyljmeeski.dopie.dto.TeamDto;
import kg.kyljmeeski.dopie.entity.Team;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
public interface TeamMapper {

    Team toTeam(TeamDto teamDto);

    TeamDto toTeamDto(Team team);
}
