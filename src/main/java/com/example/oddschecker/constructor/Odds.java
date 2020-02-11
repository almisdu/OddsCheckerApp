package com.example.oddschecker.constructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

public class Odds {

    private int betId;
    private String userId;
    private String odds;

    public int getBetId() {
        return betId;
    }

    public void setBetId(int betId) {
        this.betId = betId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        if(odds.equals("0/1") ||
        odds.equals("SP/1") ||
        odds.equals("2/3/4") ||
        odds.equals("23*4") ){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST) ;
        }
        else if(odds.equals("1/10") ||
                odds.equals("2/1") ||
                odds.equals("SP")  ) {

            this.odds = odds;
        }
    }
}
