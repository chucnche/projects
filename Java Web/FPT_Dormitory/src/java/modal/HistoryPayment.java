/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import java.sql.Date;

/**
 *
 * @author Chucnc
 */
public class HistoryPayment {
    private String stuID;
    private Date datePay;
    private String type;
    private int moneyPay;
    private String room;
    public HistoryPayment() {
    }

    public HistoryPayment(String stuID, Date datePay, String type, int moneyPay, String room) {
        this.stuID = stuID;
        this.datePay = datePay;
        this.type = type;
        this.moneyPay = moneyPay;
        this.room = room;
    }


    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMoneyPay() {
        return moneyPay;
    }

    public void setMoneyPay(int moneyPay) {
        this.moneyPay = moneyPay;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
}
