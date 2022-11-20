package myproblem;
import java.util.Random;

/**
 * @author saleh
 */
public class Main_Problem extends Problem {

    String[] possible_causes = {"Medical", "Accident"};

    /**
     * Constructor, works using random to make cost.
     * @author saleh
     */
    public Main_Problem() {
        int cause_index = this.Randomizer.nextInt(0, 2);
        set_problem_cause(possible_causes[cause_index]);
        set_problem_cost(this.Randomizer.nextDouble(3000.0, 5000.0));
    }

    /**
     * cust the cost from the income given by the family.
     * @param family : the family uses the income
     * @author saleh
     */
    public void execute_problem(Family family) {
        double temp_income = family.get_Income();
        temp_income -= this.get_problem_cost();
        family.set_Income(temp_income);
    }
}
