package kg.kyljmeeski.dopie.repository;

import kg.kyljmeeski.dopie.entity.AdminPrediction;
import kg.kyljmeeski.dopie.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminPredictionRepository extends JpaRepository<AdminPrediction, String> {
    Optional<AdminPrediction> findByMatch(Match match);
}
