import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVFileReader {
	private String inFileName = "csvFiles/employee.csv";
	public static final String COMMA_DELIMITER = ",";

	/**
	 * Reads from CSV file (text file values separated by comma or white space)
	 * store each row in an Employee object.
	 * 
	 *   The first row of the CSV is the header information.
	 * 
	 */
	public ArrayList<Employee> parseCsvFile(){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            FileReader file = new FileReader(inFileName);
            Scanner reader = new Scanner(file);
            reader.nextLine();
            while (reader.hasNextLine()){
            	employees.add(new Employee(reader.nextLine().split(COMMA_DELIMITER)));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from " + inFileName);
            return employees;
        }
        return employees;
	}

}
