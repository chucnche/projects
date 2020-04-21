/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 */
public class Result {
    private String user;
    private float score;
    private int numberQ;
    private String dateTake;

    public Result(String user, float score, int numberQ, String dateTake) {
        this.user = user;
        this.score = score;
        this.numberQ = numberQ;
        this.dateTake = dateTake;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public int getNumberQ() {
        return numberQ;
    }

    public void setNumberQ(int numberQ) {
        this.numberQ = numberQ;
    }

    public String getDateTake() {
        return dateTake;
    }

    public void setDateTake(String dateTake) {
        this.dateTake = dateTake;
    }


    
}
