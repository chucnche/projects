/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

/**
 *
 * @author Chucnc
 */
public class Room {
    private String roomName;
    private int gender;
    private int bed1,bed2,bed3,bed4,bed5,bed6,bed7,bed8;

    public Room() {
    }

    public Room(String roomName, int gender, int bed1, int bed2, int bed3, int bed4, int bed5, int bed6, int bed7, int bed8) {
        this.roomName = roomName;
        this.gender = gender;
        this.bed1 = bed1;
        this.bed2 = bed2;
        this.bed3 = bed3;
        this.bed4 = bed4;
        this.bed5 = bed5;
        this.bed6 = bed6;
        this.bed7 = bed7;
        this.bed8 = bed8;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getBed1() {
        return bed1;
    }

    public void setBed1(int bed1) {
        this.bed1 = bed1;
    }

    public int getBed2() {
        return bed2;
    }

    public void setBed2(int bed2) {
        this.bed2 = bed2;
    }

    public int getBed3() {
        return bed3;
    }

    public void setBed3(int bed3) {
        this.bed3 = bed3;
    }

    public int getBed4() {
        return bed4;
    }

    public void setBed4(int bed4) {
        this.bed4 = bed4;
    }

    public int getBed5() {
        return bed5;
    }

    public void setBed5(int bed5) {
        this.bed5 = bed5;
    }

    public int getBed6() {
        return bed6;
    }

    public void setBed6(int bed6) {
        this.bed6 = bed6;
    }

    public int getBed7() {
        return bed7;
    }

    public void setBed7(int bed7) {
        this.bed7 = bed7;
    }

    public int getBed8() {
        return bed8;
    }

    public void setBed8(int bed8) {
        this.bed8 = bed8;
    }


}
