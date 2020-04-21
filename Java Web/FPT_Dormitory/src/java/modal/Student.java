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
public class Student {
    private String stuID;
    private String username,name;
    private Date dob;
    private int gender;
    private String roomName;
    private int bedNo;
    private Date bookingDate;
    private int moneyAccount;
    private int debt;

    public Student() {
    }

    public Student(String stuID, String username, String name, Date dob, int gender, String roomName, int bedNo, Date bookingDate, int moneyAccount, int debt) {
        this.stuID = stuID;
        this.username = username;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.roomName = roomName;
        this.bedNo = bedNo;
        this.bookingDate = bookingDate;
        this.moneyAccount = moneyAccount;
        this.debt = debt;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getBedNo() {
        return bedNo;
    }

    public void setBedNo(int bedNo) {
        this.bedNo = bedNo;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getMoneyAccount() {
        return moneyAccount;
    }

    public void setMoneyAccount(int moneyAccount) {
        this.moneyAccount = moneyAccount;
    }

    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }
    
}
