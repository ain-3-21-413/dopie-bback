package kg.kyljmeeski.dopie.repository;

import kg.kyljmeeski.dopie.entity.Match;
import kg.kyljmeeski.dopie.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, String> {
    List<Match> findAllByStatus(Status status);
}
