package kg.kyljmeeski.dopie.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class AdminPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    User author;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "match_id")
    Match match;

    @Column(length = 1000)
    String intro;

    String homeFormation;

    String homeLineup;

    String homeWillMiss;

    String awayFormation;

    String awayLineup;

    String awayWillMiss;

    @Column(length = 5000)
    String forMainOutcomes;
}
