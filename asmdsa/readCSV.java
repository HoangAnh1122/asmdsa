package asmdsa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class readCSV {
	public static LinkedList csvToMyList(String csvFile) {
		LinkedList studentList = new LinkedList();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			String line;
			br.readLine(); // Skip the header line
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				Student student = new Student(data); // Create a Student object
				studentList.add(student); // Add to MyList
			}
		} catch (IOException e) {
			System.out.println("Error reading the file: " + e.getMessage());
		}
		return studentList;
	}
}
