import java.util.ArrayList;
import java.util.Comparator;

public class EmployeeService {

	/**
	 * Rearrange the elements in the list based on their departments.
	 * Order should be alphabetical. ??? they are all numbers :P
	 * @param employeeRecords
	 */
	public void sortByDept(ArrayList<Employee> employeeRecords) {
		System.out.println("Sorting by department.");
		employeeRecords.sort(Comparator.comparing(Employee::getDepartmentID));
	}

	
	/**
	 * Rearrange the elements in the list based on their Firstname
	 * @param employeeRecords
	 */
	public void sortByName(ArrayList<Employee> employeeRecords) {
		employeeRecords.sort(Comparator.comparing(Employee::getFirstName));
	}

	/**
	 * Rearrange the elements in the list based on their Employment date. Newest employees at the bottom.
	 * @param employeeRecords
	 */
	public void sortByEmploymentDate(ArrayList<Employee> employeeRecords) {
		employeeRecords.sort(Comparator.comparing(employee -> {
			int number = 0;
			String[] strings = employee.getEmpDate().split("/");
			number += 365 * Integer.parseInt(strings[2]);
			number += Integer.parseInt(strings[1]);
			number += 30 * Integer.parseInt(strings[0]);
			return number;
		}));
	}
}
