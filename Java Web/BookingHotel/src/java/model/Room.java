/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dell
 */
public class Room {
    private String rid,roomnum;
    private KindOfRoom kindor;
    private boolean status;

    public Room() {
    }

    public Room(String rid, String roomnum, KindOfRoom kor, boolean status) {
        this.rid = rid;
        this.roomnum = roomnum;
        this.kindor = kor;
        this.status = status;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(String roomnum) {
        this.roomnum = roomnum;
    }

    public KindOfRoom getKindor() {
        return kindor;
    }

    public void setKindor(KindOfRoom kindor) {
        this.kindor = kindor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
    
}
