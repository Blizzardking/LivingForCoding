package chapter2;

public class Node {
	public char data;
	public Node next;
	public int digit;
	public Node (char d) {
		data = d;
	}
	public Node() {
		
	}
	public Node (int d) {
		digit = d;
	}
	public static Node makeLinkedList(String s) {
		Node p1;
		Node p2;
		Node head = p2 = new Node(s.charAt(0));
		for (int i = 1; i < s.length(); i++) {
			p1 =  new Node(s.charAt(i));
			p2.next = p1;
			p2 = p1;
		}
		return head;
	}
	public static void printList(Node head) {
		Node p =head;
		if(p == null) {
			return;
		}
		while(p.next != null) {
			System.out.printf("%c -> ", p.data);
			p = p.next;
		}
		System.out.println(p.data);
	}
}
