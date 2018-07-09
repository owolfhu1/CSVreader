import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVFileWriter {

 
	
	private String DESTINATION = "csvFiles/result.csv";

	private FileWriter writer;


	/**
	 * Prepares the file for writing.
	 */
	public void openFile() {
		try {
			writer = new FileWriter(DESTINATION);
			writer.write("employeeID,department_id,firstName,lastName,address,city,state,emp_date\n");
		} catch (IOException e) {
			System.out.println("Error opening " + DESTINATION);
		}
	}

 

	/**
	 * Write the list of employees to the file. Each row should be a separate employee.
	 * @param employeeList : list of employees
	 */
	public void write(ArrayList<Employee> employeeList) {
		openFile();
        employeeList.forEach(employee -> {
			try {
				writer.write(employee.getCSV());
			} catch (IOException e) {
                System.out.println("Error writing to " + DESTINATION);
                closeFile();
			}
		});
		closeFile();
	} 

	/**
	 * close file
	 */
	public void closeFile() {
		try {
			writer.close();
		} catch (IOException e) {
            System.out.println("Error closing " + DESTINATION);
		}
	} 

}
