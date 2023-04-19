package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    
    public List<Employee> readCSV(String fileName) throws IOException {

        BufferedReader br = null;

        String line = "";
        List<Employee> employees = new ArrayList<Employee>();

        br = new BufferedReader(new FileReader(fileName));

        // skip the FILE_HEADER
        line = br.readLine();

        // read each line of CSV records
        // format them into an Employee object
        // add each object into list of employees

        while ((line = br.readLine()) != null) {
            String[] lineData = line.split(CSVWriter.COMMA_DELIMITER);

            if (lineData.length > 0) {
                Employee emp = new Employee(lineData[0], lineData[1], lineData[2], lineData[3], lineData[4], Integer.parseInt(lineData[5]));
                employees.add(emp);                
            }
            
        }

        // close BufferedReader
        br.close();

        // return list of records
        return employees;
    }
}
