package kg.kyljmeeski.dopie.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Team {

    @Id
    String id;

    String shortName;

    String country;

    String league;

    @OneToMany(mappedBy = "homeTeam")
    List<Match> homeMatches = new ArrayList<>();

    @OneToMany(mappedBy = "awayTeam")
    List<Match> awayMatches = new ArrayList<>();

    int totalPosition;

    int totalPoints;

    int totalW;

    int totalD;

    int totalL;

    int totalGF;

    int totalGA;

    int totalGD;

    int homePosition;

    int homePoints;

    int homeW;

    int homeD;

    int homeL;

    int homeGF;

    int homeGA;

    int homeGD;

    int awayPosition;

    int awayPoints;

    int awayW;

    int awayD;

    int awayL;

    int awayGF;

    int awayGA;

    int awayGD;
}
