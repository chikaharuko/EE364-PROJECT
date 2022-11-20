package myproject;
import myproblem.Passive_Problem;
import myproject.Family;
import myproject.Problem;
import myproblem.Main_Problem;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author adel
 */
public class Day {
    private int day_number;
    private Passive_Problem Passive_day_Problem;
    private Main_Problem Main_day_Problem;
    private int is_Passive_or_Main_problem = 0; // checks for main or passive problems, 0 is none, 1 is passive, 2 is main.
    private ArrayList<Family> families = new ArrayList<Family>();
    private Random Randomizer = new Random();
    private double[] daily_spending_cost;
    private double total_savings = 0.0;

    /**
     * the constructor.
     * @author adel
     */
    public Day() {
        this(0, new ArrayList<Family>());
        System.out.println("Day number is set to 0");
    }

    /**
     * the construcotr.
     * @param day_number : the day number.
     * @param families : the families.
     * @author adel
     */
    public Day(int day_number, ArrayList<Family> families) {
        set_day_number(day_number);
        set_Families(families);
    }

    public Day(int day_number, Passive_Problem problem, ArrayList<Family> families) {
        this.is_Passive_or_Main_problem = 1;
        set_day_number(day_number);
        set_Passive_Day_Problem(problem);
        set_Families(families);
    }
    public Day(int day_number, Main_Problem problem, ArrayList<Family> families) {
        this.is_Passive_or_Main_problem = 2;
        set_day_number(day_number);
        set_Main_Day_Problem(problem);
        set_Families(families);
    }

    /**
     * teh getter for the day number.
     * @return : the day number.
     */
    public int get_day_number() {
        return day_number;
    }
    /**
     * the setter for the day number.
     * @param day_number
     */
    public void set_day_number(int day_number) {
        this.day_number = day_number;
    } 

    public double get_Total_savings() {
        return this.total_savings;
    }
    public void add_savings(double total_savings) {
        this.total_savings += total_savings;
    }

    public Passive_Problem get_Passive_Day_Problem() {
        return this.Passive_day_Problem;
    }
    public Main_Problem get_Main_Day_Problem() {
        return this.Main_day_Problem;
    }


    public void set_Main_Day_Problem(Main_Problem day_Problem) {
        this.Main_day_Problem = day_Problem;
    }
    public void set_Passive_Day_Problem(Passive_Problem day_Problem) {
        this.Passive_day_Problem = day_Problem;
    }

    public ArrayList<Family> get_Families() {
        return families;
    }
    public void set_Families(ArrayList<Family> families) {
        this.families = families;
    }
    
    public double[] get_Daily_spending_cost() {
        return this.daily_spending_cost;
    }
    public void set_Daily_spending_cost(double[] daily_spending_cost) {
        this.daily_spending_cost = daily_spending_cost;
    }
    /**
     * checkes for problems.
     * @return returns a string describing the problem.
     */
    public String is_Day_Problem() {
        if (this.is_Passive_or_Main_problem == 2) {return this.Main_day_Problem.get_problem_cause();}
        else if (this.is_Passive_or_Main_problem == 1) {return this.Passive_day_Problem.get_problem_cause();}
        else {
            if (this.day_number == 31 || this.day_number == 1) {
                return "Pay-Day";
            }
            else if (this.day_number == 32 || this.day_number == 2) {
                return "Bills";
            }
            return "Daily-Spend";
        }
    }

    /**
     * prints the table.
     * @return the table in string form.
     */
    public String get_day_summary() {
        double[] problem_cost = execute_problem();
        
        Family family_1 = this.families.get(0);
        Family family_2 = this.families.get(1);
        // System.out.println(family_2.get_Income());
        int family_1_id = family_1.get_Id();
        int family_2_id = family_2.get_Id();

        double family_1_income = family_1.get_Income();
        double family_2_income = family_2.get_Income();

        String[] output = {Integer.toString(this.day_number)
                        , Integer.toString(family_1_id)
                        , String.format("%.2f",family_1_income)
                        , is_Day_Problem()
                        , String.format("-%.2f", problem_cost[0])
                        , String.format("%.2f", this.total_savings)
                        , Integer.toString(family_2_id)
                        , String.format("%.2f",family_2_income)
                        , is_Day_Problem()
                        , String.format("-%.2f", problem_cost[1])};

        output = transform_summary_output(output);
        
        return String.format("|  %s    |  %s         |  %s      |  %s       |  %s      |  %s       |  %s         |  %s     |  %s       |  %s    |"
                            , output[0]
                            , output[1]
                            , output[2]
                            , output[3]
                            , output[4]
                            , output[5]
                            , output[6]
                            , output[7]
                            , output[8]
                            , output[9])
                + "\n"
                + get_seperator(); 
    }

    private String[] transform_summary_output(String[] output) {
        for (int i = 0; i < 12; i++) {
            if (output[0].length() < 5) {
            output[0] += " ";
            // System.out.println("0 length is" + output[0].length());   
            }
            if (output[1].length() < 2) {
            output[1] += " ";
            output[6] += " ";
            // System.out.println("1 is " + output[1].length());
            }
            if (output[2].length() < 10) {
                output[2] += " ";
            }
            if (output[4].length() < 8) {
                output[4] += " ";
            }
            if (output[5].length() < 11) {
                output[5] += " ";
            }
            if (output[3].length() < 11) {
                output[3] += " ";
            }
            if (output[7].length() < 11) {
                output[7] += " ";
            }
            if (output[8].length() < 11) {
                output[8] += " ";
            }
            if (output[9].length() < 9) {
                output[9] += " ";
            }
            

        }
        return output;
    }
    
    public String get_day_history(int family_index) {
        Family family = this.families.get(family_index);

        int family_id = family.get_Id();

        double family_income = family.get_Income();
        double negative_income = family.get_Negative_income();
        double problem_cost;

        if (this.is_Passive_or_Main_problem == 2) {problem_cost = this.Main_day_Problem.get_problem_cost();} 
        else if (this.is_Passive_or_Main_problem == 1) {problem_cost = this.Passive_day_Problem.get_problem_cost();} 
        else {problem_cost = 0.0;}
        
        String[] output = {Integer.toString(this.day_number)
                         , Integer.toString(family_id)
                         , String.format("%.2f", family_income)
                         , is_Day_Problem()
                         , String.format("%.2f", negative_income)
                         , String.format("%.2f", problem_cost)};

        output = transform_history_output(output);
        
        return String.format("|  %s    |  %s         |  %s          |  %s       |  %s        |  %s          |"
                            , output[0]
                            , output[1]
                            , output[2]
                            , output[3]
                            , output[4]
                            , output[5])
                + "\n" 
                +  get_history_seperator();
    } 

    private String[] transform_history_output(String[] output) {

        for (int i = 0; i < 14; i++) {
            if (output[0].length() < 5) {
                output[0] += " ";
            // System.out.println("0 length is" + output[0].length());   
            }
            if (output[1].length() < 2) {
                output[1] += " ";
            }
            if (output[2].length() < 10) {
                output[2] += " ";
            }
            if (output[3].length() < 13) {
                output[3] += " ";
            }
            if (output[4].length() < 9) {
                output[4] += " ";
            }
            if (output[5].length() < 12) {
                output[5] += " ";
            }
        }
        return output;
    }

    public static String get_header() {
        return "\n" + get_seperator()
                    + "\n|  Day No.  |  family ID  |  balance         |  description       |  Cost          |  Savings           |  family ID  |  balance         |  description       |  Cost         |\n"
                    + get_seperator();
    }
    public static String get_seperator() {
        return "+-----------+-------------+------------------+--------------------+----------------+--------------------+-------------+------------------+--------------------+---------------+";
    }

    public static String get_history_header() {
        return "\n" + get_history_seperator()
                    + "\n|  Day No.  |  family ID  |  balance             |  description         |  Total Expenses   |  problem cost          |\n"
                    + get_history_seperator();
    }
    public static String get_history_seperator() {
        return "+-----------+-------------+----------------------+----------------------+-------------------+------------------------+";
    }

    
    /**
     * DEDUCTS THE PROBLEM.
     * @return
     */
    public double[] execute_problem() {
        double temp_income_1 = this.families.get(0).get_Income();
        double temp_income_2 = this.families.get(1).get_Income();

        double[] problem_cost = {0.0, 0.0};

        if (this.is_Passive_or_Main_problem == 2) {
            problem_cost[0] = this.Main_day_Problem.get_problem_cost();
            problem_cost[1] = this.Main_day_Problem.get_problem_cost();
            temp_income_1 -= problem_cost[0]; 
            temp_income_2 -= problem_cost[0];
        } 
        else if (this.is_Passive_or_Main_problem == 1) {
            problem_cost[0] = this.Passive_day_Problem.get_problem_cost();
            problem_cost[1] = this.Passive_day_Problem.get_problem_cost();
            temp_income_1 -= problem_cost[0]; 
            temp_income_2 -= problem_cost[0];
        }
        else {
            if (this.daily_spending_cost == null) {
                problem_cost = Problem.BasicSpending(this.families);
                // System.out.println("check!" + total_spending[0]);
                temp_income_1 -= problem_cost[0]; 
                temp_income_2 -= problem_cost[1];
                this.daily_spending_cost = problem_cost;
            }
            else {
                problem_cost = this.daily_spending_cost;
                temp_income_1 -= problem_cost[0]; 
                temp_income_2 -= problem_cost[1];
            }
        }

        this.families.get(0).set_Income(temp_income_1);
        this.families.get(1).set_Income(temp_income_2);

        this.families.get(0).set_Negative_income(problem_cost[0]);
        this.families.get(1).set_Negative_income(problem_cost[1]);

        return problem_cost;
    }
}


