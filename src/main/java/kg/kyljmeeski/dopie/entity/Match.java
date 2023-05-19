package kg.kyljmeeski.dopie.entity;

import jakarta.persistence.*;
import kg.kyljmeeski.dopie.enums.Status;
import kg.kyljmeeski.dopie.enums.Winner;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "`match`")
@Entity
public class Match {

    @Id
    String id;

    @ManyToOne
    @JoinColumn(name = "home_team_id")
    Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id")
    Team awayTeam;

    @Enumerated(EnumType.STRING)
    Status status;

    @Enumerated(EnumType.STRING)
    Winner winner;

    int home_goals;

    int away_goals;

    @Column(name = "match_date_time")
    LocalDateTime utcDate;

    String country;

    String league;

    @OneToOne(mappedBy = "match")
    AdminPrediction adminPrediction;
}
