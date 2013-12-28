package chapter2;

public class ReverseList {
	static Node reverseList(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node p1 = head;
		Node p2 = head.next;
		p1.next = null;
		Node p3 = p2.next;
		p2.next = p1;
		while(p3 != null) {
			p1 = p2;
			p2 = p3;
			p3 = p2.next;
			p2.next = p1;
		}
		head = p2;
		return head;
	}
}
