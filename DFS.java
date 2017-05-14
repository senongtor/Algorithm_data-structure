import java.util.*;
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
public class DFS{
	
	public void dfs(List<Node> graph, boolean[] visited, int i){
		visited[i]=true;
		System.out.println(graph.get(i).val);
		for(int j=0;j<graph.get(i).neighbors.size();j++){
			if(!visited[j]){
				dfs(graph,visited,j);
			}
		}
	}
	public static void main(String[] args){
		DFS dfs=new DFS();
		Node A=new Node(1);
		Node B=new Node(2);
		Node C=new Node(3);
		A.neighbors.add(C);
		A.neighbors.add(B);	
		B.neighbors.add(C);
		boolean[] visited=new boolean[3];
		List<Node> graph=new ArrayList<Node>();
		graph.add(A);
		graph.add(B);
		graph.add(C);
		for(int i=0;i<graph.size();i++){
			dfs.dfs(graph,visited,i);
		}
		
	}
}