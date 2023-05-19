package kg.kyljmeeski.dopie.service.impl;

import kg.kyljmeeski.dopie.entity.Match;
import kg.kyljmeeski.dopie.enums.Status;
import kg.kyljmeeski.dopie.repository.MatchRepository;
import kg.kyljmeeski.dopie.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MatchServiceImpl implements MatchService {

    final MatchRepository matchRepository;

    @Override
    public List<Match> getMatches() {
        return matchRepository.findAllByStatus(Status.TIMED);
    }

    @Override
    public List<Match> getTopMatches() {
        List<Match> matches = getMatches();
        matches.sort(Comparator.comparingInt(match -> {
            return match.getHomeTeam().getTotalPosition() + match.getAwayTeam().getTotalPosition();
        }));
        return matches.stream().limit(6).toList();
    }
}
