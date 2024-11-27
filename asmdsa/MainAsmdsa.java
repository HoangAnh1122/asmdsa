package asmdsa;

import java.util.Scanner;

public class MainAsmdsa {
	public static void main(String[] args) {
		// Load students from CSV file into MyList
		String csvFile = "asmdsa/student.csv";
		LinkedList studentList = (LinkedList) readCSV.csvToMyList(csvFile);

		Scanner scanner = new Scanner(System.in);
		int choice = 0;

		do {
			try {
				System.out.println("\n========= MENU =========");
				System.out.println("1. Display all students");
				System.out.println("2. Add a student");
				System.out.println("3. Edit a student");
				System.out.println("4. Delete a student");
				System.out.println("5. Sort students by marks");
				System.out.println("6. Search for a student by ID");
				System.out.println("0. Exit");
				System.out.print("Enter your choice: ");

				// Read user choice and validate input
				choice = Integer.parseInt(scanner.nextLine());

				switch (choice) {
				case 1:
					System.out.println("Student list:");
					studentList.display();
					break;
				case 2:
					System.out.print("Enter ID: ");
					String id = scanner.nextLine();
					System.out.print("Enter name: ");
					String name = scanner.nextLine();

					// Loop until a valid mark is entered
					double mark = -1;
					while (true) {
						try {
							System.out.print("Enter marks (0 to 10): ");
							mark = Double.parseDouble(scanner.nextLine());
							if (mark < 0 || mark > 10) {
								throw new IllegalArgumentException("Marks must be between 0 and 10.");
							}
							break; // Exit loop if input is valid
						} catch (IllegalArgumentException e) {
							// Continue prompting after an IllegalArgumentException
							System.out.println("Invalid input: " + e.getMessage());
						}
					}

					// Check if student ID already exists in the list
					boolean isDuplicate = studentList.linearSearch(id) != null;

					if (isDuplicate) {
						System.out.println("Error: A student with ID " + id + " already exists.");
					} else {
						// Add the student if no duplicate ID
						studentList.add(new Student(id, name, mark));
						System.out.println("Student added.");
					}
					break;

				case 3:
					System.out.print("Enter the ID of the student to edit: ");
					String editId = scanner.nextLine();
					System.out.print("Enter new name: ");
					String newName = scanner.nextLine();

					// Loop until valid marks are entered
					double newMark = -1;
					while (true) {
						try {
							System.out.print("Enter new marks (0 to 10): ");
							newMark = Double.parseDouble(scanner.nextLine());
							if (newMark < 0 || newMark > 10) {
								throw new IllegalArgumentException("Marks must be between 0 and 10.");
							}
							break; // Exit loop if input is valid
						} catch (NumberFormatException e) {
							System.out.println("Invalid input! Please enter a valid number.");
						}
					}

					if (studentList.edit(editId, newName, newMark)) {
						System.out.println("Student updated.");
					} else {
						System.out.println("Student not found.");
					}
					break;

				case 4:
					System.out.print("Enter the ID of the student to delete: ");
					String deleteId = scanner.nextLine();
					if (studentList.delete(deleteId)) {
						System.out.println("Student deleted.");
					} else {
						System.out.println("Student not found.");
					}
					break;

				case 5:
					studentList.bubbleSort();
					System.out.println("Student list sorted by marks.");
					break;

				case 6:
					System.out.print("Enter the ID of the student to search: ");
					String searchId = scanner.nextLine();
					Student foundStudent = studentList.linearSearch(searchId);
					if (foundStudent != null) {
						System.out.println("Student found:");
						foundStudent.print();
					} else {
						System.out.println("Student not found.");
					}
					break;

				case 0:
					System.out.println("Exiting program...");
					break;

				default:
					System.out.println("Invalid choice! Please try again.");
					break;
				}
			} catch (NumberFormatException e) {
				// Handle invalid number inputs
				System.out.println("Invalid input! Please enter a valid number.");
				choice = -1; // Keep the menu running
			} catch (Exception e) {
				// Handle unexpected errors
				System.out.println("An unexpected error occurred: " + e.getMessage());
			}
		} while (choice != 0);

		scanner.close();
	}
}
