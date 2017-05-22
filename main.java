import java.util.Scanner;
package Employee;
// This program will calculate the salary based on the leaves for Permanent and Temporary Employees
public class main {
	public static void main(String[] args) {
		int emptype;
		
		//Check if the employee is Permanent or Temporary
		System.out.println("Enter 1 for Permanent Employee.\nEnter 2 for Temporary Employee.");
		Scanner emp = new Scanner(System.in);
		emptype = emp.nextInt();
		System.out.println("--------------------------------------------");

		// TODO Auto-generated method stub
		if (emptype == 1) {// For Permanant Employee create an object of the PermanentEmp class
			PermanentEmp emp1 = new PermanentEmp();
			emp1.calculate_balance_leaves();
			emp1.calculate_salary();
		} else if (emptype == 2){// For Temporary Employee create an object of the TemperoryEmp class
			TemporaryEmp emp1 = new TemporaryEmp();
			emp1.calculate_balance_leaves();
			emp1.calculate_salary();

		}
		else
			System.out.println("Invalid input");
	}

}
