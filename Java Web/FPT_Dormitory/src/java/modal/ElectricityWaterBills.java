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
public class ElectricityWaterBills {
    private String roomName;
    private Date monthYear;
    private int soDien;
    private int soNuoc;
    private int paid;
    public ElectricityWaterBills() {
    }

    public ElectricityWaterBills(String roomName, Date monthYear, int soDien, int soNuoc, int paid) {
        this.roomName = roomName;
        this.monthYear = monthYear;
        this.soDien = soDien;
        this.soNuoc = soNuoc;
        this.paid = paid;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Date getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(Date monthYear) {
        this.monthYear = monthYear;
    }

    public int getSoDien() {
        return soDien;
    }

    public void setSoDien(int soDien) {
        this.soDien = soDien;
    }

    public int getSoNuoc() {
        return soNuoc;
    }

    public void setSoNuoc(int soNuoc) {
        this.soNuoc = soNuoc;
    }

    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }
    
}
