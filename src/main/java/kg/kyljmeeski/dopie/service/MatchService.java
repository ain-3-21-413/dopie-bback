package kg.kyljmeeski.dopie.service;

import kg.kyljmeeski.dopie.entity.Match;

import java.util.Collection;
import java.util.List;

public interface MatchService {

    List<Match> getMatches();

    List<Match> getTopMatches();
}
