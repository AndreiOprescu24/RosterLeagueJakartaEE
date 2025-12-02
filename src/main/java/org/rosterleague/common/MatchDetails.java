package org.rosterleague.common;

import java.io.Serial;
import java.io.Serializable;

public class MatchDetails implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Long id;
    private final String homeTeamName;
    private final String awayTeamName;
    private final Integer homeScore;
    private final Integer awayScore;

    public MatchDetails(Long id,
                        String homeTeamName,
                        String awayTeamName,
                        Integer homeScore,
                        Integer awayScore) {
        this.id = id;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public Long getId() {
        return id;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    @Override
    public String toString() {
        String score = (homeScore != null && awayScore != null)
                ? homeScore + " - " + awayScore
                : "- : -";
        return homeTeamName + " " + score + " " + awayTeamName;
    }
}
