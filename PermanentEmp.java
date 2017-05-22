import java.util.Scanner;

public class PermanentEmp extends Employee {
	int paid_leave, sick_leave, casual_leave;
	int take_paid_leave, take_sick_leave, take_casual_leave;
	double basic, hra, pfa;

	Scanner get = new Scanner(System.in);

	// Construct will accept the Basic Salary and Leaves available of the
	// Permanent Employee
	PermanentEmp() {
		System.out.println("Enter Basic salary of " + empName + ":");
		basic = get.nextInt();

		System.out.println("Enter total PAID LEAVES :");
		paid_leave = get.nextInt();

		System.out.println("Enter total SICK LEAVES:");
		sick_leave = get.nextInt();

		System.out.println("Enter total CASUAL LEAVES:");
		casual_leave = get.nextInt();
	}

	// Prints the pending leaves of the employee
	void print_leave_details() {
		System.out.println("Pending Paid Leaves:" + paid_leave);
		System.out.println("Pending Sick Leaves:" + sick_leave);
		System.out.println("Pending Casual Leaves:" + casual_leave);
	}

	// Calculates the leaves taken and based on the available leaves will
	// determine the salary deduction
	void calculate_balance_leaves() {
		System.out.println("How many PAID LEAVES you wish to take?");
		take_paid_leave = get.nextInt();

		if (avail_leave(take_paid_leave, 'P')) // Check if the employee can
												// avail PAID LEAVE
		{
			paid_leave = paid_leave - take_paid_leave; // Update the pending
														// PAID LEAVE
			take_paid_leave = 0;
		} // Reset the taken PAID LEAVE thus NO DEDUCTION in salary
		else
			paid_leave = 0;

		System.out.println("How many SICK LEAVES you wish to take?");
		take_sick_leave = get.nextInt();

		if (avail_leave(take_sick_leave, 'S'))// Check if the employee can avail
												// SICK LEAVES
		{
			sick_leave = sick_leave - take_sick_leave;// Update the pending SICK
														// LEAVES
			take_sick_leave = 0;// Reset the taken SICK LEAVES thus NO DEDUCTION
								// in salary
		} else
			sick_leave = 0;

		System.out.println("How many CASUAL LEAVES you wish to take?");
		take_casual_leave = get.nextInt();

		if (avail_leave(take_casual_leave, 'C'))// Check if the employee can
												// avail CASUAL LEAVES
		{
			casual_leave = casual_leave - take_casual_leave;// Update the
															// pending CASUAL
															// LEAVES
			take_casual_leave = 0;// Reset the taken CASUAL LEAVES thus NO
									// DEDUCTION in salary
		} else
			casual_leave = 0;
	}

	boolean avail_leave(int no_of_leaves, char type_of_leave) {
		if (type_of_leave == 'P') {
			if (paid_leave - take_paid_leave >= 0) // Check if leave can be
													// availed
				return true;
			else {
				// As the leave cannot be availed calculate the no of days to be
				// deducted from the salary.
				take_paid_leave = Math.abs(paid_leave - take_paid_leave);
				return false;
			}

		} else if (type_of_leave == 'S') {
			if (sick_leave - take_sick_leave >= 0)// Check if leave can be
													// availed
				return true;
			else {
				// As the leave cannot be availed calculate the no of days to be
				// deducted from the salary.
				take_sick_leave = Math.abs(sick_leave - take_sick_leave);
				return false;
			}
		} else if (type_of_leave == 'C') {
			if (casual_leave - take_casual_leave >= 0)// Check if leave can be
														// availed
				return true;
			else {
				// As the leave cannot be availed calculate the no of days to be
				// deducted from the salary.
				take_casual_leave = Math.abs(casual_leave - take_casual_leave);
				return false;
			}
		} else
			return false;
	}

	void calculate_salary() {
		double total_sal;

		// Calculate the basic salary of the employee per day
		double basicperday = basic / workingdays;

		// total leaved to be deducted from the salary
		total_leaves = take_paid_leave + take_sick_leave + take_casual_leave;

		// recalculate the basic salary after leave deduction
		double newbasic = basicperday * (workingdays - total_leaves);

		pfa = newbasic * 12 / 100;// Calculate PF
		hra = newbasic * 50 / 100;// Calculate HRA

		total_sal = basic + hra - pfa;// Calculate Salary
		System.out.println("-------------------------------------");
		print_leave_details();
		System.out.println("--------------" + "Salary of " + empName + "-----------------------");

		System.out.println("Calculated Basic Salary : Rs." + newbasic);
		System.out.println("Calculated HRA Salary : Rs." + hra);
		System.out.println("Calculated PF Salary : Rs." + pfa);
		System.out.println("Total Salary : Rs." + total_sal);
	}
}
