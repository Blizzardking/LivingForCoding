package chapter2;

public class Partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="azgghdchjj";
		Node head = makeLinkedList(s);
		printList(head);
		partition(head, 'g');
		printList(head);
	}
	/*
	 * @param head pointer to linked list, c is the value to partition around;
	 */
	static void partition(Node head, char c) {
		Node pi =  head;
		Node pj =  head;
		Node temp1, temp2;

		if(pj.next == null) 
			return;
		while(pj.next != null) {
			if(pi == pj && pj.next.data < c) {
				pi = pi.next;
				pj = pj.next;
			}
			else if(pi == pj && pj.next.data >= c) {
				pj = pj.next;
			}
			else if(pj.next.data < c) {
				temp1 = pi.next;
				temp2 = pj.next;
				pj.next = temp2.next;
				pi.next = temp2;
				temp2.next = temp1;
				pi = temp2;
			}
			else
				pj = pj.next;
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
