package kg.kyljmeeski.dopie.service.impl;

import kg.kyljmeeski.dopie.entity.AdminPrediction;
import kg.kyljmeeski.dopie.entity.Match;
import kg.kyljmeeski.dopie.repository.AdminPredictionRepository;
import kg.kyljmeeski.dopie.repository.MatchRepository;
import kg.kyljmeeski.dopie.service.AdminPredictionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdminPredictionServiceImpl implements AdminPredictionService {

    final AdminPredictionRepository adminPredictionRepository;
    final MatchRepository matchRepository;

    @Override
    public AdminPrediction getAdminPredictionByMatchId(String id) {
        Optional<Match> optionalMatch = matchRepository.findById(id);
        if (optionalMatch.isPresent()) {
            Match match = optionalMatch.get();
            if (adminPredictionRepository.findByMatch(match).isPresent()) {
                return adminPredictionRepository.findByMatch(match).get();
            }
            return null;
        }
        return null;
    }
}
