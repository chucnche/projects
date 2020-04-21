
package p0021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx.util.Pair;

/**
 *
 * @author tuans
 */
public class P0021 {
    static Map<String,Boolean> checkExist;
    private static void createFunction(ArrayList listStudent) {

        for (int i = 0; i < 10; i++) {
            addStudent(listStudent);
        }
        System.out.println(listStudent.size());
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("Do you want to continue:(Y/N) ");
            String wantContinue = input.nextLine();
            if (wantContinue.compareToIgnoreCase("n") == 0) {
                return;
            }
            if (wantContinue.compareToIgnoreCase("y") == 0) {
                addStudent(listStudent);
            } else {
                System.out.println("Please enter Y or N!!!");
            }
        }
    }

    private static void addStudent(ArrayList listStudent) {
        Scanner input = new Scanner(System.in);
        String name, course, id, semester;
        System.out.println("\nEnter student infomation:");
        System.out.print("Enter student id: ");
        id = input.nextLine();
        System.out.print("Enter student name: ");
        name = input.nextLine();
        System.out.print("Enter course's student: ");
        course = input.nextLine();
        System.out.print("Enter semester: ");
        semester = input.nextLine();
        listStudent.add(new Student(id, semester, name, course));
    }

    private static void findAndSortFunction(ArrayList<Student> listStudent) {
        Collections.sort(listStudent);
        Scanner input=new Scanner(System.in);
        System.out.print("Enter name or part of name you want to search:");
        String name=input.nextLine();
        int count=0;
        System.out.println(listStudent.size());
        for (Student temp:listStudent){
            if (temp.getName().toLowerCase().contains(name.toLowerCase())){
                System.out.println(temp);
                count++;
            }
        }
        if (count==0)
            System.out.println("No student with name you want!!!");
    }

    private static void modifyFunction(ArrayList<Student> listStudent) {
        Scanner input=new Scanner(System.in);
        String id;
        System.out.print("Enter ID you want to modify: ");
        id=input.nextLine();
        for (int i=0;i<listStudent.size();i++){
            if (listStudent.get(i).getId().compareToIgnoreCase(id)==0){
                System.out.println("Do you want to update (U) or delete (D) student: ");
                while (true){
                   String choose=input.nextLine();
                if (choose.compareToIgnoreCase("u")==0){
                    update(i,listStudent);
                    break;
                }
                if (choose.compareToIgnoreCase("d")==0){
                    listStudent.remove(i);
                    break;
                }
                System.out.print("Please enter valid request(U/D)");
                }
            }
        }
    }
     
    
    private static void update(int i, ArrayList<Student> listStudent) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter name of student: ");
        listStudent.get(i).setName(input.nextLine());
        System.out.print("Enter course's student: ");
        listStudent.get(i).setCourse(input.nextLine());
        System.out.print("Enter semester: ");
        listStudent.get(i).setSemester(input.nextLine());
    }

    private static void writeReportFunction(ArrayList<Student> listStudent) {
        Map<Pair<String,String>,Integer> count=new HashMap<>();
        for (Student temp:listStudent){
            Pair tg=new Pair(temp.getName(), temp.getCourse());
            if (count.containsKey(tg)){
                int value=count.get(tg);
                count.put(tg, ++value);
            }
            else{
                count.put(tg, 1);
            }
        }
        for (Map.Entry temp:count.entrySet()){
            Pair tg=(Pair) temp.getKey();
            System.out.println(tg.getKey()+" | "+tg.getValue()+" | "+(int)temp.getValue());
        }
    }
    public static class Student implements Comparable{

        private String id;
        private String semester;
        private String name;
        private String course;

        @Override
        public String toString() {
            return "Student{" + "id=" + id + ", semester=" + semester + ", name=" + name + ", course=" + course + '}';
        }

        public Student() {
        }

        public Student(String id, String semester, String name, String course) {
            this.id = id;
            this.semester = semester;
            this.name = name;
            this.course = course;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name the name to set
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return the course
         */
        public String getCourse() {
            return course;
        }

        /**
         * @param course the course to set
         */
        public void setCourse(String course) {
            this.course = course;
        }

        /**
         * @return the id
         */
        public String getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         * @return the semester
         */
        public String getSemester() {
            return semester;
        }

        /**
         * @param semester the semester to set
         */
        public void setSemester(String semester) {
            this.semester = semester;
        }

        @Override
        public int compareTo(Object t) {
            Student temp=(Student)t;
            return this.name.compareTo(temp.getName());
        }

    }

    //introduction of program
    static void printMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1.	Create");
        System.out.println("\t2.	Find and Sort");
        System.out.println("\t3.	Update/Delete");
        System.out.println("\t4.	Report");
        System.out.println("\t5.	Exit");
    }

    //return valid integer from min to max
    public static int getValidInt(int min, int max) {
        Scanner input = new Scanner(System.in);
        int number = -1;
        while (true) {
            try {
                number = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter valid number!!!");
            }
            if (min <= number && number <= max) {
                return number;
            }
            System.out.println("Please enter number from " + min + " to " + max);
        }

    }

    public static void main(String[] args) {
        // TODO code application logic here
        int choose = -1;
        ArrayList<Student> listStudent = new ArrayList<>();
        while (choose != 5) {
            printMenu();
            System.out.print("Enter your choice: ");
            choose = getValidInt(1, 5);
            switch (choose) {
                case 1:
                    createFunction(listStudent);
                    break;
                case 2:
                    findAndSortFunction(listStudent);
                    break;
                case 3:
                    modifyFunction(listStudent);
                    break;
                case 4:
                    writeReportFunction(listStudent);
                    break;
                default:
                    break;
            }
        }
    }

}
