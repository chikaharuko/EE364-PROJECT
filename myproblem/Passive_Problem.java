package myproblem;
import java.util.Random;
import myproject.*;

/**
 * @author saleh
 */
public class Passive_Problem extends Problem {

    String[] possible_causes = {"Over-Shop","Over-Spend"};

    /**
     *  constructor, works using random to set cost.
     * @author saleh
     */
    public Passive_Problem() {
        int cause_index = this.Randomizer.nextInt(0, 2);
        set_problem_cause(possible_causes[cause_index]);
        set_problem_cost(this.Randomizer.nextDouble(1000.0, 2000.0));
    }

    /**
     * the execute problem abstract method, cuts from the income based on the cost.
     * @author saleh
     */
    public void execute_problem(Family family) {
        double temp_income = family.get_Income();
        temp_income -= this.get_problem_cost(); 
        family.set_Income(temp_income);
    }
}

// TODO: periodical issues. e.g. loans.