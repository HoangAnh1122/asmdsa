package asmdsa;

public class LinkedList {
	private Node head; //

	public LinkedList() {
		this.head = null;
	}

	// 1. Add Student
	public void add(Student student) {
		Node newNode = new Node(student);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	// 2. Edit Student by ID
	public boolean edit(String id, String newName, double newMark) {
		Node temp = head;
		while (temp != null) {
			if (temp.student.getId().equals(id)) {
				temp.student.setName(newName);
				temp.student.setMark(newMark);
				temp.student.setRank();
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	// 3. Delete Student by ID
	public boolean delete(String id) {
		if (head == null)
			return false;

		if (head.student.getId().equals(id)) {
			head = head.next;
			return true;
		}

		Node current = head;
		Node previous = null;
		while (current != null && !current.student.getId().equals(id)) {
			previous = current;
			current = current.next;
		}

		if (current == null)
			return false;

		previous.next = current.next;
		return true;
	}

	// 4. Display Students
	public void display() {
		Node temp = head;
		while (temp != null) {
			temp.student.print();
			System.out.println("--------------------");
			temp = temp.next;
		}
	}

	public void bubbleSort() {
		if (head == null || head.next == null)
			return; // List is empty or has only one node, already sorted.

		// Outer loop for the number of passes
		for (Node outer = head; outer.next != null; outer = outer.next) {
			// Inner loop for pairwise comparisons
			for (Node current = head; current.next != null; current = current.next) {
				if (current.student.getMark() > current.next.student.getMark()) {
					// Swap the Student objects
					Student temp = current.student;
					current.student = current.next.student;
					current.next.student = temp;
				}
			}
		}
	}

	// 6. Search by ID (Linear Search)
	public Student linearSearch(String id) {
		Node current = head;

		while (current != null) {
			if (current.student.getId().equals(id)) {
				return current.student;
			}
			current = current.next;
		}

		return null;
	}

	public int getSize() {
		int count = 0;
		Node temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
}
