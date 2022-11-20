import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import myproblem.*;
import java.util.Arrays;
import myproject.*;
import myfamily.*;
/**
 * @author adel
 */

public class Simulation {
    private ArrayList<Family> Families = new ArrayList<Family>(Arrays.asList(new Family(1), new Family(2)));
    private ArrayList<Day> Days = new ArrayList<Day>();
    private int No_of_Days;
    Random Randomizer = new Random();

    /**
     * A constructor for the simulation, calls the generate_Days method.
     * @param no_of_days : simulation period.
     * @author adel
     */
    public Simulation(int no_of_days) {
        set_No_of_Days(no_of_days);
        generate_Days(no_of_days);
    }

    /**
     * returns the simulation period in arraylist form.
     * @return : the Days ArrayList.
     * @author adel
     */
    public ArrayList<Day> get_Days() {
        return this.Days;
    }

    /**
     * Sets the Simulation period in arraylist form.
     * @param days : the Days ArrayList.
     * @author adel
     */
    public void set_Days(ArrayList<Day> days) {
        this.Days = days;
    }
    
    /**
     * returns the families in the simulation.
     * @return the families in ArrayList form.
     * @author adel
     */
    public ArrayList<Family> getFamilies() {
        return this.Families;
    }

    /**
     * sets the families in the simulation.
     * @param families : the families in ArrayList form.
     * @author adel
     */
    public void setFamilies(ArrayList<Family> families) {
        this.Families = families;
    }

    /**
     * returns the Simulation period in integer form.
     * @return : the Simulation period in integer form.
     * @author adel
     */
    public int get_No_of_Days() {
        return this.No_of_Days;
    }

    /**
     * sets the Simulation period in integer form.
     * @param no_of_Days : the Simulation period in integer form.
     * @author adel
     */
    public void set_No_of_Days(int no_of_Days) {
        this.No_of_Days = no_of_Days;
    }

    /**
     * Generayes the simulation period base on the integer in the constructor.
     * @param no_of_days : represents the number of days.
     * @author adel
     */
    public void generate_Days(int no_of_days) {
        Day temp_Day;
        Passive_Problem P_problem = new Passive_Problem();;
        Main_Problem M_problem = new Main_Problem();

        for (int i = 1; i < no_of_days + 1; i++) {
            if (i == 4) { // generating passive problems.
                temp_Day = new Day(i, P_problem, this.Families);
            }
            else if (i == 13) { // generating passive problems.
                temp_Day = new Day(i, P_problem, this.Families);
            }
            else if (i == 21) { // generating passive problems.
                temp_Day = new Day(i, P_problem, this.Families);
            }
            else if (i ==34) { // generating passive problems.
                temp_Day = new Day(i, P_problem, this.Families);
            }
            else if (i == 43) { // generating passive problems.
                temp_Day = new Day(i, P_problem, this.Families);
            }
            else if (i == 29) { // generating main problems.
                temp_Day = new Day(i, M_problem, this.Families);
            }
            else if (i == 56) { // generating main problems.
                temp_Day = new Day(i, M_problem, this.Families);
            }
            else {
                temp_Day = new Day(i, this.Families);
            }
            this.Days.add(temp_Day);
        }
    }

    /**
     * finds a specific day object in the simulation period in ArrayList form.
     * @param Day_number : the day number to be found.
     * @return : the specific day object.
     * @author adel
     */
    public Day find_Day(int Day_number) {

        int temp_Day_Number;

        for (Day day : this.Days) {
            temp_Day_Number = day.get_day_number();
            if (temp_Day_Number == Day_number) {
                return day;
            }
        }
        return null;
    }

    /**
     * Runs the simulation.
     * @author adel
     */
    public void Run_simulation() {
        Scanner input = new Scanner(System.in);
        int choice;
        int checkpoint_flag = 0;
    

        while (true) {
            if (checkpoint_flag == 0) {
                System.out.println("\nWelcome to Team 1's project! the subject is Financial instability!");
                System.out.println("\npress 1 to begin the simulation, 0 to abort.\n");
                choice = input.nextInt();
                if (choice == 0) {
                    System.out.println("\nThank you for your time! Aborting Simulation...");
                    break;
                }
                else if (choice == 1) {
                    System.out.println("\nbeginning simulation...");
                    checkpoint_flag = 1;
                }
                else {
                    System.out.println("\nChoice invalid! Try Again.");
                    continue;
                }
            }
            else if (checkpoint_flag == 1) {
                System.out.println("\nThis simulation has many Options, these options are:"
                + "\n\t1 - run phase.1:  showcasing the problems' effect on 2 families."
                + "\n\t2 - run phase.2 :  administering Solutions (Unavailable!)"
                + "\n\t3 - roll the credits!");
                choice = input.nextInt();
                if (choice == 1) {
                    Show_summary();
                }
                else if (choice == 2) {
                    System.out.println("\nSorry! phase 2 is unavailable. :(\n");
                    continue;
                }
                else if (choice == 3) {
                    System.out.println("\nproject is still in phase 1 sadly.\n");
                    continue;
                }
                else {
                    System.out.println("\nWrong choice! redirecting...");
                    continue;
                }
                checkpoint_flag = 2;
            }
            else if (checkpoint_flag == 2) {
                System.out.println("\n\n this table shows the financial instability."
                + " However, it is concise, to access detailed records of the simulation, refer to the" 
                + " history section,"
                + "\n\tTo abort the simulation, Enter 0."
                + "\n\tTo access the history section, Enter 1."
                + "\n\tTo access the second phase, Enter 2.");

                choice = input.nextInt();

                if (choice == 0) {
                    System.out.println("\nThank you for your time! Aborting Simulation...\n");
                    break;
                }
                else if (choice == 1) {
                    System.out.println("\nEnter the day Number you want to find"
                    + ", caution: your input cant go above " + get_No_of_Days() + " and below 0.\n");
                    
                    choice = input.nextInt();

                    if (choice > get_No_of_Days() || choice < 0) {
                        System.out.println("\nError: Your input cant go beyond or below the limit! redirecting...");
                        continue;
                    }
                    else {
                        Day Chosen_Day = find_Day(choice);
                        System.out.println("\nPick which family to show history, 1 or 2...\n");
                        
                        choice = input.nextInt();
                        
                        if (choice == 1 || choice == 2) {
                            show_history(Chosen_Day, choice -1);
                            checkpoint_flag = 0;
                        }
                        else {
                            System.out.println("\nWrong input! redirecting...");
                            continue;
                        }
                    }
                }
                else if (choice == 2) {
                    implement_phase_2();
                    Show_summary();
                }
                else {
                    System.out.println("\nWrong input! redirecting...");
                    continue;
                }
            }
        }        
    }

    /**
     * Shows the table row by row, calls the summary method in the day class.
     * @author adel
     */
    public void Show_summary() throws NullPointerException {
        System.out.println(Day.get_header());
        for (Day day : this.Days) {
            System.out.println(day.get_day_summary());
            if (day.get_day_number() == 30) {
                for (Family family : this.Families) {
                    family.add_salary();
                }
            }
            if (day.get_day_number() == 31 || day.get_day_number() == 2) {
                for (Family family : this.Families) {
                    family.pay_bills();
                }
            }
        }
        System.out.println(get_table_index());
    }
    
    /**
     * shows a specific day in the table.
     * @param Chosen_Day : the specific day number.
     * @param family_index : the chosen family.
     * @author adel
     */
    public void show_history(Day Chosen_Day, int family_index) {
        System.out.println(Day.get_history_header());
        System.out.println(Chosen_Day.get_day_history(family_index));
    }

    /**
     * implements the solution phase.
     * @author adel
     */
    public void implement_phase_2() {

        for (Family family : this.Families) {
            family.set_Income(family.get_cheque());
        }

        Solutions[] solutions = {new Family1(1), new Family2(2)};
        for (int i = 0; i < solutions.length; i++) {
            solutions[i].implement_solution(this.Days);
        }
    }

    /**
     * the table index.
     * @return the index in string form.
     * @author adel
     */
    public String get_table_index() {
        return "\nTable Keywords:\n"
              + "\n\t1.Over-Shop : occurs when the family wastes income on unnecessary items. occured 5 times in the Simulation."
              + "\n\t2.Over-Spend : occurs when the family excessively wastes income on a singular item. occured 5 times in the Simulation."
              + "\n\t3.Medical : occurs when the family faces a sudden medical emergency. occured 2 times in the Simulation."
              + "\n\t4.Accident : occurs when the family faces a car accident. occured 2 times in the Simulation."
              + "\n\t5.Daily-Spend : occurs when the family faces no problems. occured 53 times in the Simulation.";
    }
       
    @Override
    public String toString() {
        return "This simulation aims to shed light on the different factors affecting "
        + "\nfamilies and how to counter those alleged factors using a selection of different "
        + "\nsolutions, this simulation is split into 2 phases, these phases are:"
             + "\n\tPhase.1 : Highlighting the problems affecting the families on a maximum period of 60 days"
             + "\n\tPhase.2 : Introducing solutions to counter said problems."
             + "\nPhase 1 consists of two sections:"
             + "\n\tpresenting the simulation along the desired period."
             + "\n\tpresenting the history on a specific day in the simulation period."
             + "\nPhase 2 is unavailable at the moment";
            }
}

class Test {
    public static void main(String[] args) {
        Simulation simulation = new Simulation(60);
        simulation.Run_simulation();
    }
}