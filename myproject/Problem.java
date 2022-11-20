package myproject;
import java.util.ArrayList;
import java.util.Random;
import myfamily.Family1;

/**
 * @author saleh
 */
public abstract class Problem {
    private String problem_cause;
    private double problem_cost;
    private Random Randomizer = new Random();
    private static Random static_Randomizer = new Random();

    public Problem() {

    }
    public Problem(String problem_cause, double problem_cost) {
        set_problem_cause(problem_cause);
        set_problem_cost(problem_cost);
    }
    public String get_problem_cause() {
        return problem_cause;
    }
    public double get_problem_cost() {
        return problem_cost;
    }
    public void set_problem_cause(String problem_cause) {
        this.problem_cause = problem_cause;
    }
    public void set_problem_cost(double problem_cost) {
        this.problem_cost = problem_cost;
    }
    /**
     * deducts from the income the cost of the problem.
     * @param family : the income from the famly
     * @author saleh
     */
    public abstract  void execute_problem(Family family);
    
    public String toString() {
        return String.format("The problem's cost is %.2f, the problem's cause is %s"
                            , this.problem_cost
                            , this.problem_cause);
    }

    /**
     * spends money when no problem is found, works randomly based on the remaining balance.
     * @param families : the income from the families.
     * @return : rreturns the income in double array form.
     * @author saleh
     */
    public static double[] BasicSpending(ArrayList<Family> families) {
        Family family_1 = families.get(0);
        Family family_2 = families.get(1);
        int family_1_members = family_1.get_No_of_members();
        int family_2_members = family_2.get_No_of_members();
        double family_1_spending;
        double family_2_spending;

        if (family_1.get_Income() > 20000) {
            family_1_spending = family_1_members * static_Randomizer.nextDouble(122.25473, 140.46387);
            
        }
        else if (family_1.get_Income() < 20000 || family_1.get_Income() > 15000) {
            family_1_spending = family_1_members * static_Randomizer.nextDouble(110.58395, 121.53952);
        }
        else if (family_1.get_Income() < 15000 || family_1.get_Income() > 10000) {
            family_1_spending = family_1_members * static_Randomizer.nextDouble(80.58395, 118.49583);
        }
        else if (family_1.get_Income() < 10000 || family_1.get_Income() > 5000) {
            family_1_spending = family_1_members * static_Randomizer.nextDouble(50.25473, 78.46387);
        } 
        else if (family_1.get_Income() < 5000 || family_1.get_Income() > 0) {
            family_1_spending = family_1_members * static_Randomizer.nextDouble(22.25473, 45.46387);
        }
        else {
            family_1_spending = family_1_members * static_Randomizer.nextDouble(3.25473, 12.46387);
        }

        if (family_2.get_Income() > 20000) {
            family_2_spending = family_2_members * static_Randomizer.nextDouble(122.28492, 140.58395);
        }
        else if (family_2.get_Income() < 20000 || family_2.get_Income() > 15000) {
            family_2_spending = family_2_members * static_Randomizer.nextDouble(110.58349, 121.48394);
        }
        else if (family_2.get_Income() < 15000 || family_2.get_Income() > 10000) {
            family_2_spending = family_2_members * static_Randomizer.nextDouble(80.58244, 118.75846);
        }
        else if (family_2.get_Income() < 10000 || family_2.get_Income() > 5000) {
            family_2_spending = family_2_members * static_Randomizer.nextDouble(50.45434, 78.74876);
        } 
        else if (family_2.get_Income() < 5000 || family_2.get_Income() > 0) {
            family_2_spending = family_2_members * static_Randomizer.nextDouble(22.49584, 45.75846);
        }
        else {
            family_2_spending = family_2_members * static_Randomizer.nextDouble(3.44, 12.58476);
        }

        double[] total_spending = {family_1_spending, family_2_spending}; 
        
        return total_spending;
    }

}