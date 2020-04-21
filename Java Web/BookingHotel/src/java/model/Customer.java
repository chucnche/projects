/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author dell
 */
public class Customer {
    private Account acc;
    private Room room;
    private Date checkin,checkout;
    private FormOfRent formor;

    public Customer() {
    }

    public Customer(Account acc, Room room, Date checkin, Date checkout, FormOfRent formor) {
        this.acc = acc;
        this.room = room;
        this.checkin = checkin;
        this.checkout = checkout;
        this.formor = formor;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public FormOfRent getFormor() {
        return formor;
    }

    public void setFormor(FormOfRent formor) {
        this.formor = formor;
    }
    
}
