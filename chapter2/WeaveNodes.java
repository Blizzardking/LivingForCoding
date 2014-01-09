package chapter2;

public class WeaveNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "acegbdfhi";
		Node head = makeLinkedList(s);
		printList(head);
		weaveNodes(head);
		printList(head);
	}
	static void weaveNodes(Node head) {
		if(head ==null || head.next == null) {
			return;
		}
		Node p1 = head.next;
		Node p2 = head.next.next;
		while(p2 != null && p2.next != null){
			p1 = p1.next;
			p2 = p2.next.next;
		}
		boolean isOdd = false;
		if(p2 != null) {
			p1 = p1.next;
			isOdd = true;
		}
		p2 = head;
		Node temp1, temp2;
		while(p1.next != null) {
			temp1 = p1.next;
			temp2 = p2.next;
			p1.next = p2.next;
			p2.next = p1;
			p1 =  temp1;
			p2 = temp2;
		}
		if(isOdd) {
			temp1 = p2.next;
			p2.next = p1;
			p1.next = temp1;
			temp1.next = null;
		}
		else {
			p2.next = p1;
		}
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
