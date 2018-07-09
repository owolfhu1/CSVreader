/**
 * This entity is used to identify a record (row) from the database table, Employee 
 */
public class Employee {
  	
  	private String employeeID,departmentID,firstName,
            lastName,address,city,state,empDate;
	
    public Employee(String... args) {
        employeeID = args.length  < 1 ? "0000" : args[0];
        departmentID = args.length  < 2 ? "0000" :  args[1];
        firstName = args.length < 3 ? "no first name" : args[2];
        lastName = args.length < 4 ? "no last name" : args[3];
        address = args.length < 5 ? "no address" : args[4];
        city = args.length < 6 ? "no city" : args[5];
        state = args.length < 7 ? "no state" : args[6];
        empDate = args.length < 8 ? "00/00/0000" : args[7];
    }

    /**
     * toString function displays all fields
     */
    @Override
    public String toString() {
        String toString = "####################################################\n";
        toString += "##:``````````````````````````````````````````````:##\n";
        toString += pad("Employee ID: " + employeeID);
        toString += pad("Department ID: " + departmentID);
        toString += pad("Name: " + firstName + " " + lastName);
        toString += pad("Address: " + address + " " + city + ", " + state);
        toString += pad("Employment Date: " + empDate);
        toString += "##:..............................................:##\n";
        toString += "####################################################\n";
        return toString;
    }
    private String pad(String string) {
        if (string.length()>45)
            return pad(string.substring(0,40) + "-") + pad(string.substring(40,string.length()));
        string = "##:  " + string;
        String padding ="                                                 :##\n";
        return string + padding.substring(string.length(), padding.length());
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmpDate() {
        return empDate;
    }

    public String getCSV() {
        String c = CSVFileReader.COMMA_DELIMITER;
        return employeeID + c + departmentID + c +
                firstName + c + lastName + c + address
                + c + city + c + state + c + empDate + "\n";
    }

}
