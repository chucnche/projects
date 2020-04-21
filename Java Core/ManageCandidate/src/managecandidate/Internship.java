/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managecandidate;

public class Internship extends Candidate {
    
    String major, semecter, uniName;

    public Internship() {
    }

    public Internship(String major, String semecter, String uniName, String id, String fName, String lName, String address, String phone, String email, int type, int birthYear) {
        super(id, fName, lName, address, phone, email, type, birthYear);
        this.major = major;
        this.semecter = semecter;
        this.uniName = uniName;
    }

    
    
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSemecter() {
        return semecter;
    }

    public void setSemecter(String semecter) {
        this.semecter = semecter;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }
    
    
}
