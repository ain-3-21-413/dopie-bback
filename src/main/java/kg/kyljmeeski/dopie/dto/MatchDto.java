package kg.kyljmeeski.dopie.dto;

public record MatchDto(
    String id,
    Area area,
    Competition competition,
    String utcDate,
    TeamDto homeTeam,
    TeamDto awayTeam,
    Score score,
    String status

) {
    public record Area(
            String name
    ) {
    }

    public record Competition(
            String name
    ) {
    }

    public record Score(
            String winner,
            Time fullTime
    ) {
    }

    public record Time(
            int home,
            int away
    ) {
    }
}
