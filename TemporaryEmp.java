public class TemporaryEmp extends Employee {

	double basic, hra, pfa;

	// Construct will accept the Basic Salary and Leaves taken by the Temporary
	// Employee
	TemporaryEmp() {
		System.out.println("Enter Basic salary of " + empName + ":");
		basic = get.nextInt();

		System.out.println("Enter total leaves taken by " + empName + ":");
		total_leaves = get.nextInt();
	}

	void calculate_balance_leaves() {
	}

	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		return true;
	}

	void calculate_salary() {
		double total_sal;
		double basicperday = basic / workingdays;// Calculate the basic salary
													// of the employee per day
		double newbasic = basicperday * (workingdays - total_leaves);// recalculate
																		// the
																		// basic
																		// salary
																		// after
																		// leave
																		// deduction

		pfa = newbasic * 12 / 100;// Calculate PF
		hra = newbasic * 50 / 100;// Calculate HRA

		total_sal = basic + hra - pfa;// Calculate Salary
		System.out.println("\n--------------" + "Salary of " + empName + "-----------------------");
		System.out.println("Calculated Basic Salary : Rs." + newbasic);
		System.out.println("Calculated HRA Salary : Rs." + hra);
		System.out.println("Calculated PF Salary : Rs." + pfa);
		System.out.println("Total Salary : Rs." + total_sal);
	}
}
