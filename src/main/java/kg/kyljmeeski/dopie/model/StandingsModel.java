package kg.kyljmeeski.dopie.model;

import java.util.List;

public record StandingsModel(
        List<Standing> standings
) {

    public record Standing(
        String type,
        List<Position> table
    ) {
    }

    public record Position(
        int position,
        Team team,
        int playedGames,
        String form,
        int won,
        int draw,
        int lost,
        int points,
        int goalsFor,
        int goalsAgainst,
        int goalDifference
    ) {

    }

    public record Team(
        String id
    ) {
    }

}

