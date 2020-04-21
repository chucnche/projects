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
public class RequestStudent {
    private int requestID;
    private String stuID,dateRequest;
    private String request,maID;
    private String dateReply;
    private String reply;

    public RequestStudent() {
    }

    public RequestStudent(int requestID, String stuID, String dateRequest, String request, String maID, String dateReply, String reply) {
        this.requestID = requestID;
        this.stuID = stuID;
        this.dateRequest = dateRequest;
        this.request = request;
        this.maID = maID;
        this.dateReply = dateReply;
        this.reply = reply;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getDateRequest() {
        return dateRequest;
    }

    public void setDateRequest(String dateRequest) {
        this.dateRequest = dateRequest;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMaID() {
        return maID;
    }

    public void setMaID(String maID) {
        this.maID = maID;
    }

    public String getDateReply() {
        return dateReply;
    }

    public void setDateReply(String dateReply) {
        this.dateReply = dateReply;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    
}
