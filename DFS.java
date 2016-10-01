import java.util.*;
public class DFS{
	class Node{
		int val;
		List<Node> neighbors;
		public Node(){
			neighbors=new ArrayList<Node>();
		}
		public Node(int val){
			this.val=val;
			neighbors=new ArrayList<Node>();
		}	
	}
	public void dfs(List<Node> graph){
		for(int i=0;i<graph;i++){
			
		}
	}
	public static void main(String[] args){
		Node A=new Node(1);
		Node B=new Node(2);
		Node C=new Node(3);
		A.neighbors.add(C);
		A.neighbors.add(B);	
		B.neighbors.add(C);
		List<Node> graph=new ArrayList<Node>();
		graph.add(A);
		graph.add(B);
		graph.add(C);
		dfs(graph);
	}
}