package kg.kyljmeeski.dopie;

import kg.kyljmeeski.dopie.api.FromApiUpdater;
import kg.kyljmeeski.dopie.entity.AdminPrediction;
import kg.kyljmeeski.dopie.entity.Match;
import kg.kyljmeeski.dopie.entity.User;
import kg.kyljmeeski.dopie.enums.Status;
import kg.kyljmeeski.dopie.repository.AdminPredictionRepository;
import kg.kyljmeeski.dopie.repository.MatchRepository;
import kg.kyljmeeski.dopie.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class DatabaseInitializer implements CommandLineRunner {

    final FromApiUpdater fromApiUpdater;
    final MatchRepository matchRepository;
    final AdminPredictionRepository adminPredictionRepository;
    final UserRepository userRepository;
    final static Logger LOGGER = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Override
    public void run(String... args) throws Exception {
//        fromApiUpdater.updateTeams();
//        fromApiUpdater.updateStandings();
//        fromApiUpdater.updateMatches();
    }
}
