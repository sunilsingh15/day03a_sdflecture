package sg.edu.nus.iss;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVWriter {

    public static final String COMMA_DELIMITER = ",";
    public static final String NEWLINE_SEPARATOR = "\n";
    public static final String FILE_HEADER = "staffNo,fullName,department,role,emailAddress,salary";

    public List<Employee> employees = null;

    public List<Employee> generateEmployees() {
        employees = new ArrayList<>();

        Employee emp1 = new Employee("12344", "Bryan", "Customer Relations", "Relationship Manager", "bryan@visa.com", 10000);
        Employee emp2 = new Employee("12345", "Arun", "Infastructure", "Infra Engineer", "arun@visa.com", 12000);
        Employee emp3 = new Employee("12346", "Sunil", "Technology", "Tech Architech", "sunil@visa.com", 8000);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        return employees;
    }

    public void writeToCSV(List<Employee> employees, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);

        // write the FILE_HEADER
        fileWriter.append(FILE_HEADER.toString());
        fileWriter.append(NEWLINE_SEPARATOR);

        // iterate through employees to write each employee record to file
        for (Employee emp : employees) {
            fileWriter.append(emp.getStaffNo());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getFullName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getDepartment());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getRole());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(emp.getEmailAddress());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(String.valueOf(emp.getSalary()));
            fileWriter.append(NEWLINE_SEPARATOR);
        }


        // flush and close the FileWriter
        fileWriter.flush();
        fileWriter.close();
    }
    
}
