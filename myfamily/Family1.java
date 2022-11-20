package myfamily;
import myproject.*;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author saeed
 */
public class Family1 extends Family implements Solutions{
	double total_savings = 0.0; // sets the initial value of total savings to 0
    double savings_percentage = 0.1; // sets the initial =value for percentage to 0.1
/**
 * create a constructor that takes from family 
 * create a method called add saving 
 * make the method increment the multiplication of balance and saving percentage
 * then let it decrement the multiplication of balance and savings percentage from balance
 * let it return the value of the remaining balance 
 * @param id
 * @return balance
 * @author saeed
 */
	public Family1(int id) {
		super(id);
	}

	public double add_savings(double balance) { // creates the method
        this.total_savings += balance * this.savings_percentage; // takes the value of balance and multiplies it with balance and increments it to total savings
        balance -= balance * this.savings_percentage; // multiplies balance and saving percentage and decrements that value from the value of balance
        return balance; // returns balance
	}
	/**
	 * setters and getters 
	 * @param total_savings
	 * @return
	 * @param saving_percentage
	 * @return
	 */
    public void setTotal_savings(double total_savings) { 
        this.total_savings = total_savings;
    }
    public double getTotal_savings() {
        return this.total_savings;
    }
    public void setSavings_percentage(double savings_percentage) {
        this.savings_percentage = savings_percentage;
    }
    public double getSavings_percentage() {
        return this.savings_percentage;
    }
/**
 * create an array list that takes from days and set family 1 to index 0
 * give it the a balance from income , and adding to savings 
 * @param Days
 * @return Days
 */
    @Override
	public ArrayList<Day> implement_solution(ArrayList<Day> Days) { // creates an array list for class Days 
        ArrayList<Family> families = Days.get(0).get_Families(); // the array list of index 0 contains get_families
        Family family1 = families.get(0); // object family1 takes from families 
        double family1_balance = family1.get_Income(); // sets a double balance for family1 that is equal to its income
        for (Day day : Days) { // for loop for 60 days
            family1_balance = add_savings(family1_balance); // add_savings has family1 balance and saves it in family 1 balance
            day.add_savings(this.total_savings);
        }
        return Days;
	}
}