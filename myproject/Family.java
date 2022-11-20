package myproject;
import java.util.ArrayList;
import java.util.Random;
/**
 * @author saeed
 */
public class Family {	
	    private int id; // families have id's to distinguish between them.
	    private double[] income_range = {0,1}; 
	    protected double income; //families have income.
	    private int No_of_members;
	    public double negative_income = 0; // total of all spenditure.
	    protected Random randomizer = new Random();
		private double cheque;
		private ArrayList<Double> bills = new ArrayList<Double>();
	   
	    /**
	     * create a constructor with integer ID and use it to call a 2 incomes ranges
	     * 1 income range for the origin
	     * the other income range for the bound
	     * and save the value in income 
	     * and do a setter for it 
	     * @param id
		 * @author saeed
		 *
	     */
	    public Family(int id) {
	    	
			setId(id);
			
			this.income_range[0]=this.randomizer.nextDouble(10000,15000); // this will be the origin 
			this.income_range[1]=this.randomizer.nextDouble(22000,25000);// this will be the bound 
			
			set_Income(this.income_range);// places the values of income_range in income

			set_No_of_members(this.randomizer.nextInt(2,5));
	    }

		public void setId(int id) {
			this.id = id;
		}

		/**Create another constructor 
		 * this constructor will be used to implement solution later on
		 * will also include calling how many members of the family
		 * @param income_range
		 * @param No_of_members
		 * @author saeed
		 */
		
		 public Family(double[] income_range, int No_of_members) {	   // this constructor will be used in phase 2
			 
				set_Income(income_range);
				
				this.No_of_members = this.randomizer.nextInt(2,7); // random number of families from 2 to 7.
				
		    }
		 
		public void set_Income(double[] income) {

			 
			this.income = this.randomizer.nextDouble(income[0], income[1]); // income[0] -> income[1]
			this.cheque = this.income;
		}
		public void set_Income(double income) {
			this.income = income;
		}

		public void set_Negative_income(double negative_income) {
			this.negative_income += negative_income;  // increase the value to show in history
		}
		
		/**
		 * setters and gettters for the remaining ones
		 * @return
		 */
		
	    public double get_Negative_income() {
			return this.negative_income ;
		}

		public void set_No_of_members(int no_of_members) {
			this.No_of_members = no_of_members;
		}
		
		public int get_No_of_members() {
			return this.No_of_members ;
		}

		public int get_Id() {	
			return this.id ;
		}

		public double get_Income() {			
			return this.income ;	
		}
		
		public double[] get_Income_range() {
			return this.income_range ;
		}

		public void set_Income_range(double[] income_range) {
			this.income_range = income_range ;
		}

		public double get_cheque() {
			return this.cheque;
		}

		public void add_salary() {
			this.income += this.cheque;
		}

		public double pay_bills() {
			generate_Bills();
			double total_bills = 0.0;
			for (Double bill : this.bills) {
				this.income -= bill;
				total_bills += bill;
			}
			return total_bills;
		}

		public void generate_Bills() {
			for (int i = 0; i < 3; i++) {
				double temp_bill = (this.income / 2) * this.randomizer.nextDouble(0.05, 0.1);
				this.bills.add(temp_bill);
			}
		}
}
