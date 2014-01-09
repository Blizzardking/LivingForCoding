package puzzle;
import java.util.LinkedList;

import chapter2.Node;
public class MergeTwoSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node n1 = Node.makeLinkedList("13579");
		Node n2 = Node.makeLinkedList("246");
		Node n = merge1(n1, n2);
		Node.printList(n);
	}
	static Node merge1(Node head1, Node head2) {
		if(null == head1) 
			return head2;
		if(null == head2)
			return head1;
		if(head1.data < head2.data) {
			Node next = merge1(head1.next, head2);
			head1.next = next;
			return head1;
		}
		else {
			LinkedList lis = null;
			Node next = merge1(head1, head2.next);
			head2.next = next;
			return head2;
		}
	}
	static Node merge2(Node head1, Node head2) {
		Node n1 = head1;
		Node n2 = head2;
		Node head = new Node(); //dummy head;
		Node n = head;
		while(n1 != null && n2 != null) {
			if(n1.data < n2.data) {
				n.next = n1;
				n1 = n1.next;	
			}
			else {
				n.next = n2;
				n2 = n2.next;
			}
			n = n.next;
		}
		if(n1 != null) {
			n.next = n1;
		}
		else
			n.next = n2;
		return head.next;
	}
}

