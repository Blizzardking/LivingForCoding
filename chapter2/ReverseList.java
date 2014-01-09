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
	static Node reverseList2(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		Node next = head.next;
		head.next = null;
		return reverseList(head, next);
	}
	static Node reverseList(Node pre, Node curr) {
		if(null == curr) {
			return curr;
		}
		if( null == curr.next){
			curr.next = pre;
			return curr;
		}
		Node next = curr.next;
		curr.next = pre;
		return reverseList(curr, next);
	}
	public static void main(String[] args) {
		String s = "abcdefg";
		Node head = makeLinkedList(s);
		Node rhead = reverseList2(head);
		printList(rhead);
	}
	static Node makeLinkedList(String s) {
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
	static void printList(Node head) {
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
