package chapter2;

public class Add {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = makeLinkedList("1234");
		Node n2 = makeLinkedList("66566");
//		Node rn1 = reverseList(n1);
//		printList(rn1);
//		Node rn2 = reverseList(n2);
//		printList(rn2);
		Node n = add2(n1,n2);
		printList(n);
	}
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
	static Node add2(Node head1, Node head2) {
		Node r1 = reverseList(head1);
		Node r2 = reverseList(head2);
		Node n = add(r1, r2);
		Node rn = reverseList(n);
		return rn;		
	}
	static Node add(Node head1, Node head2) {
		int sum, carry = 0;
		Node head = new Node(); //dummy head;
		Node p1 = head1;
		Node p2 = head2;
		Node p3 = head;
		while(p1 != null && p2 != null) {
			sum = p1.digit + p2.digit + carry;
			Node p = new Node(sum%10);
			carry = sum / 10;
			p3.next = p;
			p3 = p3.next;
			p1 = p1.next;
			p2 = p2.next;
		}
		while(p1 != null) {
			sum = p1.digit + carry;
			Node p = new Node(sum%10);
			carry = sum / 10;
			p3.next = p;
			p3 = p3.next;
			p1 = p1.next;
		}
		while(p2 != null) {
			sum = p2.digit + carry;
			Node p = new Node(sum%10);
			carry = sum / 10;
			p3.next = p;
			p3 = p3.next;
			p2 = p2.next;
		}
		if(carry != 0) {
			Node p = new Node(carry);
			p3.next = p;
			p3 = p3.next;
		}
		return head.next;
	}
	static Node makeLinkedList(String s) {
		Node p1;
		Node p2;
		Node head = p2 = new Node((int)s.charAt(0) - '0');
		for (int i = 1; i < s.length(); i++) {
			p1 =  new Node((int)s.charAt(i) - '0');
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
			System.out.printf("%d -> ", p.digit);
			p = p.next;
		}
		System.out.println(p.digit);
	}
	
}
