package chapter2;
import java.util.*;
public class Q2_7Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdefggfedcba";
		Node head = makeLinkedList(s);
		System.out.println(isPalindrome2(head));
		printList(head);
	}
	static boolean isPalindrome(Node head) {
		Node fast = head;
		Node slow = head;
		Stack<Character> stack = new Stack<Character>();
		while(fast != null && fast.next != null) {
			stack.push(slow.data);
			fast = fast.next.next;
			slow = slow.next;
		}
		if(fast != null) {
			slow = slow.next;
		}
		while(slow != null) {
			int top = stack.pop();
			if(top != slow.data) {
				return false;
				
			}
			slow = slow.next;
		}
		return true;
	}
	// reverse the second half; level B;
	static boolean isPalindrome2( Node head) {
		Node p1 = head;
		Node p2 = head;
		int size = 0;
		while(p1 != null) {
			p1 = p1.next;
			size++;
		}
		p1 = head;
		for(int i = 0; i < size/2; i++) {
			p1 = p1.next;
		}
		if(size % 2 == 1) p1 = p1.next;
		Node rp1 = ReverseList.reverseList2(p1);
		printList(rp1);
		printList(head);
		while(rp1 != null) {
			if(rp1.data != p2.data) {
				p1 = ReverseList.reverseList2(rp1);
				return false;
			}
			rp1 = rp1.next;
			p2 = p2.next;
		}
		p1 = ReverseList.reverseList(rp1);
		return true;
	}
	static boolean isPalindrome3( Node head) {
		Node p1 = head;
		int size = 0;
		while(p1 != null) {
			p1 = p1.next;
			size++;
		}
		Wrapper temp = isPalindromeHelper(head, size);
		return temp.b;
	}
	static class Wrapper {
		public Node n;
		public boolean b;
		public Wrapper(){}
		public Wrapper(Node n, boolean b) {
			this.n = n;
			this.b = b;
		}
	}
	static Wrapper isPalindromeHelper( Node head, int length) {
		if(length == 0) {
			return new Wrapper(head, true);
		}
		else if(length == 1) {
			return new Wrapper(head.next, true);
		}
		Wrapper rn = isPalindromeHelper(head.next, length -2);
		if(!rn.b)
			return rn;
		if(rn.n.data != head.data) {
			rn.b = false;
			return rn;
		}
		else {
			rn.n = rn.n.next;
			return rn;
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
