package com.example.excercise_12;

import java.util.ArrayList;

public class Vote {
    private String voterName;
    private String voterId;
    private String candidate;

    public Vote(String voterName, String voterId, String candidate) {
        this.voterName = voterName;
        this.voterId = voterId;
        this.candidate = candidate;
    }

    public String getVoterName() {
        return voterName;
    }

    public void setVoterName(String voterName) {
        this.voterName = voterName;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public static ArrayList<Vote> voteList = new ArrayList<>();

}
