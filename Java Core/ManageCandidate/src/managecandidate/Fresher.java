package managecandidate;

public class Fresher extends Candidate {

    String rank = "", education = "";
    String graDate = "";

    public Fresher() {
    }

    public Fresher(String id, String fName, String lName, String address, String phone, String email, int type, int birthYear) {
        super(id, fName, lName, address, phone, email, type, birthYear);
        this.rank = rank;
        this.education = education;
        this.graDate = graDate;
    }

    

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getGraDate() {
        return graDate;
    }

    public void setGraDate(String graDate) {
        this.graDate = graDate;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
