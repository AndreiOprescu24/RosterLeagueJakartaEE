package org.rosterleague.entities;

import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "PERSISTENCE_ROSTER_MATCH")
public class Match implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Team homeTeam;
    private Team awayTeam;
    private Integer homeScore;
    private Integer awayScore;
    private League league;

    public Match() {
    }

    public Match(Team homeTeam, Team awayTeam, League league) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.league = league;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "HOME_TEAM_ID", referencedColumnName = "ID", nullable = false)
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    @ManyToOne
    @JoinColumn(name = "AWAY_TEAM_ID", referencedColumnName = "ID", nullable = false)
    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    @Column(name = "HOME_SCORE")
    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    @Column(name = "AWAY_SCORE")
    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    @ManyToOne
    @JoinColumn(name = "LEAGUE_ID", referencedColumnName = "ID", nullable = false)
    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }
}
