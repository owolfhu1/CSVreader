import java.util.ArrayList;
import java.util.Scanner;

/**
 * MenuServices is console application that provides user input and feedback
 * 
 * @author
 *
 */
public class EmployeeController {
	
	private static CSVFileWriter fileWriter;
	private static EmployeeService employeeService;
	
	private static ArrayList<Employee> empRecords = null;

	/**
	 * processUserRequest based on user's selection calls the method to execute
	 * that choice Options are: R read in input from CSV file D display Employee
	 * info sorted by Department id
	 * 
	 */
	public static void main(String[] args) {
		
		fileWriter = new CSVFileWriter();
		employeeService = new EmployeeService();
		empRecords = new ArrayList<Employee>();
		start();

	}

 
	private static void start(){

		Scanner in = new Scanner(System.in);
        String input;
        char inputChar;

		while(true) {

            displayMenu();
            input = in.nextLine();
            inputChar = input.isEmpty() ? ' ' : input.charAt(0);

            switch (inputChar) {
                case 'B':
                    printDB_Records(empRecords);
                    break;

                case 'R':
                    // reads existing file from console, stores in employee object
                    CSVFileReader fileReader = new CSVFileReader();
                    empRecords = fileReader.parseCsvFile();
                    printDB_Records(empRecords);
                    break;

                case 'D':
                    // Sort Employees by Department
                    employeeService.sortByDept(empRecords);
                    printDB_Records(empRecords);
                    fileWriter.write(empRecords);
                    break;

                case 'S':
                    // Sort employee's names alphabetically
                    employeeService.sortByName(empRecords);
                    printDB_Records(empRecords);
                    fileWriter.write(empRecords);
                    break;

                case 'C':
                    //Sort by Employement Date
                    employeeService.sortByEmploymentDate(empRecords);
                    printDB_Records(empRecords);
                    fileWriter.write(empRecords);
                    break;

                case 'E':
                    System.out.println("EXIT program");
                    in.close();
                    return;

                default:
                    System.out.println("Invalid Input");

            }

        }
		
	}

	/**
	 * Display menu of options
	 */
	public static void displayMenu() {
		String menu = "Please choose an option. \n "
				+ " B: Display records. \n "
				+ " R: Read records from file. \n "
				+ " D: Sort Employees by Department \n "
				+ " S: Sort Employees by Name (last, first) \n "
				+ " C: Sort Employees by Employee Tenure \n "
				+ " E: Exit program \n" +
                "Enter your selection: ";
		System.out.print(menu);
    }

	/**
	 * Prints out each object in array list to the screen
	 * 
	 * @param list
	 */
	public static void printDB_Records(ArrayList<Employee> list) {
		list.forEach(System.out::println);
	}

}
