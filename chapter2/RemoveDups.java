package chapter2;
import java.util.*;

public class RemoveDups {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "FOLLOW UP";
		Node p1;
		Node p2;
		Node head = p2 = new Node('F');
		for (int i = 1; i < s.length(); i++) {
			p1 =  new Node(s.charAt(i));
			p2.next = p1;
			p2 = p1;
		}
		printList(head);
		removeDups3(head);
		printList(head);
	}
	public static void removeDups1(Node n) {
		HashSet set = new HashSet();
		Node previous = null;
		while(n != null) {
			if(set.contains(n.data)) {
				previous.next = n.next;
			}
			else {
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}
	public static void removeDups2(Node n) {
		boolean[] array = new boolean[256];
		Node p = n;
		if(p == null) {
			return;
		}
		array[p.data] = true;
		while(p.next != null) {
			if(array[p.next.data]) {
				p.next = p.next.next;
			}
			else {
				array[p.next.data] = true;
				p = p.next;
			}
		}
		
	}
	//R.T. = O(n2)
	public static void removeDups3(Node n) {
		Node p1 =  n;
		Node p2 = n;
		if(n == null) {
			return;
		}
		while(p1.next != null) { //check whether p1.next is a duplicate
			boolean dup = false;
			while(p2 != p1.next) {
				if(p2.data == p1.next.data) {
					dup =true;
					break;
				}
				p2 = p2.next;
			}
			if(dup) {
				p1.next = p1.next.next;
				p2 = n;
			}
			else {
				p1 = p1.next;
				p2 = n;
			}
		}
	}
	static Node makeLinkedList(String s) {
		Node p1;
		Node p2;
		Node head = p2 = new Node('F');
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
