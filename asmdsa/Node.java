package asmdsa;

public class Node {

	Student student;
	Node next;

	public Node(Student student, Node next) {
		this.student = student;
		this.next = next;
	}

	public Node(Student student) {
		this.student = student;
		this.next = null;
	}

}