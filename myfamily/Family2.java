package myfamily;
import myproject.*;
import myproblem.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author saeed
 */
public class Family2 extends Family implements Solutions {
	double reduction;// variable double for reduction 
	
	/**
	 * create a constructor that takes from family called family2
	 * create a method called reduction 
	 * let the reduction value of the problems be random from 0.2 to 0.3
	 * then subtract that from 1 to get the value of the total
	 * and multiply that with the cost
	 * @param id
	 * @param cost
	 * @return remaining_percentage
     * @author saeed
	 */
	public Family2(int id) {
		super(id);
	}

	public double reduction(double cost) { // creates the method called reduction with param double cost
        this.reduction = this.randomizer.nextDouble(0.2,0.3); // creating a random value for reduction from 0.2 to 0.3
		double remaining_percentage = 1 - this.reduction; // getting the remaining value of the cost by subtracting reduction from 1
		return remaining_percentage * cost; // return the multiply the cost and the percentage 
	}
    /**
     * Create an array list from class Days to check each the problems and apply the reduction 
     * @param Days
     * @return Days
     */
	
    @Override
	public ArrayList<Day> implement_solution(ArrayList<Day> Days) { // creates the array list days 
        for (Day day : Days) { // starts the loop for the 60 days
            if (day.get_day_number() == 4) { // if the day is 4
                Passive_Problem Pproblem = day.get_Passive_Day_Problem(); // we get the passive problem for that day
                double Pcost = reduction(Pproblem.get_problem_cost());// apply the reduction to the problem and save it in Pcost ( problem cost )
                Pproblem.set_problem_cost(Pcost); // sets the new value for problem cost
            }
            else if (day.get_day_number() == 13) { // if its day 13 
                Passive_Problem Pproblem = day.get_Passive_Day_Problem();
                double Pcost = reduction(Pproblem.get_problem_cost());
                Pproblem.set_problem_cost(Pcost);
            }
            else if (day.get_day_number() == 21) { // if its day 21
                Passive_Problem Pproblem = day.get_Passive_Day_Problem();
                double Pcost = reduction(Pproblem.get_problem_cost());
                Pproblem.set_problem_cost(Pcost);
            }
            else if (day.get_day_number() == 34) { // if its day 34
                Passive_Problem Pproblem = day.get_Passive_Day_Problem();
                double Pcost = reduction(Pproblem.get_problem_cost());
                Pproblem.set_problem_cost(Pcost);
            }
            else if (day.get_day_number() == 43) { // if its day 43 
                Passive_Problem Pproblem = day.get_Passive_Day_Problem();
                double Pcost = reduction(Pproblem.get_problem_cost());
                Pproblem.set_problem_cost(Pcost);
            }
            else if (day.get_day_number() == 29) { // if its day 29 
                Main_Problem Mproblem = day.get_Main_Day_Problem(); // takes the value of the main problem 
                double Mcost = reduction(Mproblem.get_problem_cost()); // applies the reduction to the main problem
                Mproblem.set_problem_cost(Mcost); // sets the new problem cost to problem cost
            }
            else if (day.get_day_number() == 56) { // if its day 56
                Main_Problem Mproblem = day.get_Main_Day_Problem();
                double Mcost = reduction(Mproblem.get_problem_cost());
                Mproblem.set_problem_cost(Mcost);
            }
            else {
                double[] Scost = day.get_Daily_spending_cost(); // creates a double array called Scost to get the daily spending 
                Scost[1] = reduction(Scost[1]); // place the cost in index 1
                day.set_Daily_spending_cost(Scost); // sets the value 
            }
	    }
        return Days; // returns the day 
    } 
}