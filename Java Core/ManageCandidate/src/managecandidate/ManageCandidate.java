package managecandidate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManageCandidate {

    Scanner in = new Scanner(System.in);

    public void menu() {
        System.out.println("========== CANDIDATE MANAGEMENT SYSTEM ===========");
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
    }

    public void input(List<Candidate> list, int choice) {
        String id, fName, lName, address, phone, email;
        int birthYear, type;
        System.out.println("========== CREATE CANDIDATE ==========");
        id = inputID(list);
        fName = inputString("first name");
        lName = inputString("last name");
        birthYear = inputDOB();
        address = inputString("address");
        phone = inputPhone();
        email = inputMail();
        type = choice - 1;
        switch (choice) {
            case 1: {
                int explnYear;
                String proSkill;
                explnYear = inputExYear();
                proSkill = inputString("proSkill");
                Experience ex = new Experience(explnYear, proSkill, id, fName, lName, address, phone, email, type, birthYear);
                list.add(ex);
                System.out.println("Create experience successfully!");
                break;
            }
            case 2: {
                String rank = "", education = "";
                String graDate = "";
                education = inputString("education");
                rank = inputRank();
                graDate = inputDate();
                Fresher fr = new Fresher(id, fName, lName, address, phone, email, type, birthYear);
                list.add(fr);
                System.out.println("Create experience successfully!");
                break;
            }
            case 3: {
                String major, semester, uniName;
                major = inputString("major");
                semester = inputString("semester");
                uniName = inputString("university name");
                Internship its = new Internship(major, semester, uniName, id, fName, lName, address, phone, email, type, birthYear);
                list.add(its);
                System.out.println("Create experience successfully!");
                break;
            }
        }
        System.out.println("________________________________________________");
        System.out.println("");

    }

    public void searchCandidate(List<Candidate> list) {
        displayAll(list);
        String findName;
        int findType;
        findName = inputString("Candidate name (First name or Last name)");
        while (true) {
            try {
                System.out.print("Input candidate type: ");
                findType = Integer.parseInt(in.nextLine());
                if (findType < 0 || findType > 2) {
                    System.out.println("Type must be in range 0-2");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Type must be number");
            }
        }
        int check = 0;
        System.out.println("\nThe candidates found:");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == findType) {
                if (list.get(i).getfName().contains(findName) || list.get(i).getlName().contains(findName)) {
                    System.out.println(list.get(i));
                    check++;
                }
            }
        }
        if (check == 0) {
            System.out.println("No data!");
        }
        System.out.println("________________________________________________");
        System.out.println("");
    }

    public boolean isEmpty(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i)) || Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void displayAll(List<Candidate> list) {
        System.out.println("========== EXPERIENCE CANDIDATE ==========");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == 0) {
                System.out.println(list.get(i));
            }
        }
        System.out.println("");

        System.out.println("========== FRESHER CANDIDATE ==========");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == 1) {
                System.out.println(list.get(i));
            }
        }
        System.out.println("");

        System.out.println("========== INTERNSHIP CANDIDATE ==========");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == 2) {
                System.out.println(list.get(i));
            }
        }
        System.out.println("");
    }

    public int inputDOB() {
        int birthYear;
        while (true) {
            try {
                System.out.print("Enter Year of Birth: ");
                birthYear = Integer.parseInt(in.nextLine());
                if (birthYear < 1900 || birthYear > 2018) {
                    System.out.println("Year of Birth must be in range 1900-2018");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter number");
            }
        }
        return birthYear;
    }

    public int inputExYear() {
        int year;
        while (true) {
            try {
                System.out.print("Enter Year of Experience: ");
                year = Integer.parseInt(in.nextLine());
                if (year < 0 || year > 100) {
                    System.out.println("Year of Experience must be in range 0-100");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter number");
            }
        }
        return year;
    }

    public String inputRank() {
        String type;
        while (true) {
            System.out.print("Enter rank: ");
            type = in.nextLine();
            if (isEmpty(type)) {
                System.out.println("Rank can not empty");
            } else if (!type.equalsIgnoreCase("Good") && !type.equalsIgnoreCase("Excellence")
                    && !type.equalsIgnoreCase("Fair") && !type.equalsIgnoreCase("Poor")) {
                System.out.println("Rank of Graduation must be one of 4 values: Excellence, Good, Fair or Poor.\nEnter again!");
            } else {
                break;
            }
        }
        return type;
    }

    public int checkChoice(List<Candidate> list) {
        int choice;
        while (true) {
            try {
                System.out.print("Choose one option: ");
                choice = Integer.parseInt(in.nextLine());
                if (choice < 1 || choice > 5) {
                    System.out.println("Please enter a number 1-5");
                } else if (choice == 4 && list.isEmpty()) {
                    System.out.println("No data! \nInput candidate to perform this option. Choose 1 please!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }
        }
        return choice;
    }

//    public String inputDate() throws ParseException {
//        String date;
//        while (true) {
//            System.out.print("Enter Gradution Date: ");
//            date = in.nextLine();
//            if (isEmpty(date)) {
//                System.out.println("Date can not empty");
//            } else if (!checkDate(date)) {
//                System.out.println("Date is incorrect");
//            } else {
//                break;
//            }
//        }
//        return date;
//    }
    public String inputDate() {
        String date;
        while (true) {
            try {
                System.out.print("Enter date: ");
                date = in.nextLine();
                DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
                df.setLenient(false);
                df.parse(date);
                return date;
            } catch (ParseException e) {
                System.out.println("Invalid format, Try again");
            }
        }
    }

    public String inputPhone() {
        String phone;
        while (true) {
            System.out.print("Enter phone: ");
            phone = in.nextLine();
            if (!checkPhone(phone)) {
                System.out.println("Phone must be number");
            } else if (phone.length() < 10) {
                System.out.println("Phone is number with minimum 10 characters");
            } else {
                break;
            }
        }
        return phone;
    }

    public String inputMail() {
        String mail;
        while (true) {
            System.out.print("Enter email: ");
            mail = in.nextLine();
            if (isEmpty(mail)) {
                System.out.println("Email can not empty");
            } else if (!checkMail(mail)) {
                System.out.println("Email is incorrect");
            } else {
                break;
            }
        }
        return mail;
    }

    public boolean checkPhone(String phone) {
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    //check mail format
    public boolean checkMail(String email) {
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";;
        Boolean b = email.matches(EMAIL_REGEX);
        return b;

    }

    public String inputString(String variableName) {
        String var;
        while (true) {
            System.out.print("Enter " + variableName + " : ");
            var = in.nextLine();
            if (isEmpty(var)) {
                System.out.println(variableName + " can not empty");
            } else {
                break;
            }
        }
        return var;
    }

    public String inputID(List<Candidate> list) {
        String id;
        while (true) {
            System.out.print("Enter ID: ");
            id = in.nextLine();
            if (isEmpty(id)) {
                System.out.println("ID can not empty");
            } else if (isExistedCode(list, id)) {
                System.out.println("ID existed");
            } else {
                break;
            }
        }
        return id;
    }

    public boolean isExistedCode(List<Candidate> list, String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

}
