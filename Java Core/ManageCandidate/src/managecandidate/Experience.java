package managecandidate;

import java.util.List;

public class Experience extends Candidate {

    int explnYear;
    String proSkill;

    public Experience() {
    }

    public Experience(int explnYear, String proSkill, String id, String fName, String lName, String address, String phone, String email, int type, int birthYear) {
        super(id, fName, lName, address, phone, email, type, birthYear);
        this.explnYear = explnYear;
        this.proSkill = proSkill;
    }

    
    
    public int getExplnYear() {
        return explnYear;
    }

    public void setExplnYear(int explnYear) {
        this.explnYear = explnYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

}
