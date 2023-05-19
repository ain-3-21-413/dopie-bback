package kg.kyljmeeski.dopie.api;

import kg.kyljmeeski.dopie.dto.MatchDto;
import kg.kyljmeeski.dopie.dto.TeamDto;
import kg.kyljmeeski.dopie.entity.Match;
import kg.kyljmeeski.dopie.entity.Team;
import kg.kyljmeeski.dopie.mapper.MatchMapper;
import kg.kyljmeeski.dopie.mapper.TeamMapper;
import kg.kyljmeeski.dopie.model.MatchesModel;
import kg.kyljmeeski.dopie.model.StandingsModel;
import kg.kyljmeeski.dopie.model.TeamsModel;
import kg.kyljmeeski.dopie.repository.MatchRepository;
import kg.kyljmeeski.dopie.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class FromApiUpdater {

    final TeamRepository teamRepository;
    final TeamMapper teamMapper;
    final MatchRepository matchRepository;
    final MatchMapper matchMapper;
    final RestTemplate restTemplate = new RestTemplate();
    String url = "https://api.football-data.org/v4";

    private <T> ResponseEntity<T> getResponse(String path, Class<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Auth-Token", "f4afb5cbba6e4ffeb2c3d8541f14c482");

        HttpEntity<?> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(url + path, HttpMethod.GET, requestEntity, responseType);
    }

    public void updateTeams() {
        TeamsModel body = getResponse("/competitions/PL/teams", TeamsModel.class).getBody();
        assert body != null;
        String league = body.competition().name();
        List<TeamDto> teamDtos = body.teams();
        List<Team> teams = teamDtos.stream().map(teamMapper::toTeam).toList();
        for (Team team : teams) {
            team.setLeague(league);
        }
        teams.forEach(teamRepository::save);
    }

    public void updateStandings() {
        StandingsModel body = getResponse("/competitions/PL/standings", StandingsModel.class).getBody();
        assert body != null;
        List<StandingsModel.Standing> standings = body.standings();
        StandingsModel.Standing totalStanding = standings.get(0);
        StandingsModel.Standing homeStanding = standings.get(1);
        StandingsModel.Standing awayStanding = standings.get(2);
        for (StandingsModel.Position position : totalStanding.table()) {
            Optional<Team> optionalTeam = teamRepository.findById(position.team().id());
            if (optionalTeam.isPresent()) {
                Team team = optionalTeam.get();
                team.setTotalPosition(position.position());
                team.setTotalPoints(position.points());
                team.setTotalW(position.won());
                team.setTotalD(position.draw());
                team.setTotalL(position.lost());
                team.setTotalGF(position.goalsFor());
                team.setTotalGA(position.goalsAgainst());
                team.setTotalGD(position.goalDifference());
                teamRepository.save(team);
            }
        }
        for (StandingsModel.Position position : homeStanding.table()) {
            Optional<Team> optionalTeam = teamRepository.findById(position.team().id());
            if (optionalTeam.isPresent()) {
                Team team = optionalTeam.get();
                team.setHomePosition(position.position());
                team.setHomePoints(position.points());
                team.setHomeW(position.won());
                team.setHomeD(position.draw());
                team.setHomeL(position.lost());
                team.setHomeGF(position.goalsFor());
                team.setHomeGA(position.goalsAgainst());
                team.setHomeGD(position.goalDifference());
                teamRepository.save(team);
            }
        }
        for (StandingsModel.Position position : awayStanding.table()) {
            Optional<Team> optionalTeam = teamRepository.findById(position.team().id());
            if (optionalTeam.isPresent()) {
                Team team = optionalTeam.get();
                team.setAwayPosition(position.position());
                team.setAwayPoints(position.points());
                team.setAwayW(position.won());
                team.setAwayD(position.draw());
                team.setAwayL(position.lost());
                team.setAwayGF(position.goalsFor());
                team.setAwayGA(position.goalsAgainst());
                team.setAwayGD(position.goalDifference());
                teamRepository.save(team);
            }
        }
    }

    public void updateMatches() {
        MatchesModel body = getResponse("/competitions/PL/matches", MatchesModel.class).getBody();
        assert body != null;
        List<MatchDto>  matchDtos = body.matches();
        List<Match> matches = matchDtos.stream().map(matchMapper::toMatch).toList();
        matches.forEach(matchRepository::save);
    }
}
