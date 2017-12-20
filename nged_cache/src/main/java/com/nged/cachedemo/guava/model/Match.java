package com.nged.cachedemo.guava.model;

import java.io.Serializable;

public class Match implements Serializable{
    private String matchTime;
    private Integer homeTeamId;
    private Integer guestTeamId;

    public Match(){}

    public Match(String matchTime,Integer homeTeamId,Integer guestTeamId){
        this.guestTeamId = guestTeamId;
        this.homeTeamId = homeTeamId;
        this.matchTime = matchTime;
    }

    public String getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(String matchTime) {
        this.matchTime = matchTime;
    }

    public Integer getHomeTeamId() {
        return homeTeamId;
    }

    public void setHomeTeamId(Integer homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public Integer getGuestTeamId() {
        return guestTeamId;
    }

    public void setGuestTeamId(Integer guestTeamId) {
        this.guestTeamId = guestTeamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (!matchTime.equals(match.matchTime)) return false;
        if (!homeTeamId.equals(match.homeTeamId)) return false;
        return guestTeamId.equals(match.guestTeamId);
    }

    @Override
    public int hashCode() {
        int result = matchTime.hashCode();
        result = 31 * result + homeTeamId.hashCode();
        result = 31 * result + guestTeamId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "matchTime='" + matchTime + '\'' +
                ", homeTeamId=" + homeTeamId +
                ", guestTeamId=" + guestTeamId +
                '}';
    }
}
