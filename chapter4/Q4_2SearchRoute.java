package chapter4;
import java.util.*;
enum State {
	visited, 
	visiting,
	unvisited;
}
public class Q4_2SearchRoute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edge = 
				{{0,1},{1,0},
				{0,2},{2,0},
				{0,4},{4,0},
				{1,3},{3,1},
				{2,3},{3,2},
				{4,3},{3,4},
				{1,2},{2,1},
				{2,4},{4,2},
				};
		Graph g = new Graph(5, edge);
		Node start = g.getNode(0);
		Node end = g.getNode(4);
		visitBFS(g, start);
		System.out.println();
		for(Node u: g.getNodes()) {
			u.isVisited = false;
		}
		//System.out.println(search(g, start, end));
		visitDFS2(g, start);
	}
	public static void visitDFS1(Graph g, Node start) {
		System.out.print(start.index + " ");
		start.isVisited = true;
		for(Node u: start.getAdjacent()) {
			if(!u.isVisited)
				visitDFS1(g, u);
		}
	}
	public static void visitDFS2(Graph g, Node start) {
		Stack<Node> stack = new Stack<Node> ();
		stack.push(start);
		while(!stack.empty()) {
			Node u = stack.pop();
			if(!u.isVisited) {
				System.out.print(u.index + " ");
				u.isVisited = true;
				for(Node v: u.getAdjacent()) {
					stack.push(v);
				}
			}
		}
	}
	public static void visitBFS(Graph g, Node start) {
		Queue<Node> queue = new LinkedList<Node>();
		for(Node u: g.getNodes()) {
			u.isVisited = false;
		}
		queue.add(start);
		start.isVisited = true;
		System.out.print(start.index + " ");
		while(!queue.isEmpty()) {
			Node v = queue.remove();
			for(Node u : v.getAdjacent()) {
				if(!u.isVisited) {
					
					queue.add(u);
					System.out.print(u.index + " ");
					u.isVisited = true;
				}
			}
		}
	}
	public static boolean search(Graph g, Node start, Node end) {
		Queue<Node> queue = new LinkedList<Node>();
		for(Node u: g.getNodes()) {
			u.isVisited = false;
		}
		queue.add(start);
		start.isVisited = true;
		System.out.print(start.index + " ");
		while(!queue.isEmpty()) {
			Node v = queue.remove();
			for(Node u : v.getAdjacent()) {
				if(!u.isVisited) {
					if(u == end) {
						System.out.print(u.index + " ");
						return true;
					}
					queue.add(u);
					System.out.print(u.index + " ");
					u.isVisited = true;
				}
			}
		}
		return false;
	}
 	static class Graph {
		Node[] nodes;
		public Graph(int n) {
			nodes = new Node[n];
			for(int i = 0; i < n; i++) {
				nodes[i] = new Node(i);
			}
		}
		public Graph(int n, int[][] e) {
			nodes = new Node[n];
			for(int i = 0; i < n; i++) {
				nodes[i] = new Node(i);
			}
			for(int i = 0; i < e.length; i++) {
				nodes[e[i][0]].addEdge(nodes[e[i][1]]);
			}
		}
		public Node getNode(int i) {
			return nodes[i];
		}
		public Node[] getNodes() {
			return nodes;
		}
		
	}
	
}
class Node {
	int index;
	boolean isVisited = false;
	ArrayList<Node> adj;
	public Node(int index) {
		this.index = index;
		adj = new ArrayList<>();
	}
	public void addEdge(Node n) {
		adj.add(n);
	}
	ArrayList<Node> getAdjacent() {
		return adj;
	}
}


