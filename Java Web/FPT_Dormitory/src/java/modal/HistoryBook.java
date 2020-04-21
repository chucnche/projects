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
public class HistoryBook {
    private int bookID;
    private String stuID;
    private Date dateBook;
    private String roomName;
    private int bedNo;
    private Date dateEx;
    public HistoryBook() {
    }

    public HistoryBook(int bookID, String stuID, Date dateBook, String roomName, int bedNo, Date dateEx) {
        this.bookID = bookID;
        this.stuID = stuID;
        this.dateBook = dateBook;
        this.roomName = roomName;
        this.bedNo = bedNo;
        this.dateEx = dateEx;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public Date getDateBook() {
        return dateBook;
    }

    public void setDateBook(Date dateBook) {
        this.dateBook = dateBook;
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

    public Date getDateEx() {
        return dateEx;
    }

    public void setDateEx(Date dateEx) {
        this.dateEx = dateEx;
    }



    
}
