/*
 * Copyright (c), Eclipse Foundation, Inc. and its licensors.
 *
 * All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Distribution License v1.0, which is available at
 * https://www.eclipse.org/org/documents/edl-v10.php
 *
 * SPDX-License-Identifier: BSD-3-Clause
 */
package org.rosterleague.common;

import java.io.Serial;
import java.io.Serializable;

import org.rosterleague.entities.Match;
import org. rosterleague. entities.Team;

public class TeamDetails implements Serializable, Comparable<TeamDetails> {
    @Serial
    private static final long serialVersionUID = -1618941013515364318L;
    private final String id;
    private final String name;
    private final String city;
    private final int matchesPlayed;
    private final int points;

    public TeamDetails(String id, String name, String city) {

        this.id = id;
        this.name = name;
        this.city = city;
        this.matchesPlayed = 0;
        this.points = 0;
    }

    public TeamDetails(String id, String name, String city, int matchesPlayed, int points) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.matchesPlayed = matchesPlayed;
        this.points = points;
    }

    /**
     * Creates TeamDetails from a Team entity, calculating matches played and points
     */
    public TeamDetails(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.city = team.getCity();

        int played = 0;
        int totalPoints = 0;

        // Calculate from home matches
        if (team.getHomeMatches() != null) {
            for (Match match : team.getHomeMatches()) {
                if (match.getHomeScore() != null && match.getAwayScore() != null) {
                    played++;
                    if (match.getHomeScore() > match.getAwayScore()) {
                        totalPoints += 3; // Win
                    } else if (match.getHomeScore().equals(match.getAwayScore())) {
                        totalPoints += 1; // Draw
                    }
                }
            }
        }

        // Calculate from away matches
        if (team.getAwayMatches() != null) {
            for (Match match : team.getAwayMatches()) {
                if (match.getHomeScore() != null && match.getAwayScore() != null) {
                    played++;
                    if (match.getAwayScore() > match.getHomeScore()) {
                        totalPoints += 3; // Win
                    } else if (match.getAwayScore().equals(match.getHomeScore())) {
                        totalPoints += 1; // Draw
                    }
                }
            }
        }

        this.matchesPlayed = played;
        this.points = totalPoints;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getPoints() {
        return points;
    }

    @Override
    public int compareTo(TeamDetails other) {
        // Sort by points descending
        return Integer.compare(other.points, this.points);
    }

    @Override
    public String toString() {
        return id + " " + name + " " + city;
    }

}
