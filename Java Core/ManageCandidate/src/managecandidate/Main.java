
package managecandidate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        List<Candidate> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        ManageCandidate mc = new ManageCandidate();
        int choice;
        while(true) {
            mc.menu();
            choice = mc.checkChoice(list);
            switch(choice) {
                case 1: {
                    mc.input(list, choice);
                    break;
                }
                case 2: {
                    mc.input(list, choice);
                    break;
                }
                case 3: {
                    mc.input(list, choice);
                    break;
                }
                case 4: {
                    mc.searchCandidate(list);
                    break;
                }
                case 5: {
                    return;
                            
                }
            }
        }
    }
    
}
