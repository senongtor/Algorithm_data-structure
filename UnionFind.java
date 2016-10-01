import java.util.*;

public class UnionFind{
	// public static int find(int node, int[] map){
	// 	while(map[node]!=node){
	// 		node=map[node];
	// 	}
	// 	return node;
	// }
	// public static void union(int x,int y,int[] map){
	// 	int headX=find(x, map);
	// 	int headY=find(y, map);
	// 	if(headX!=headY){
	// 		map[headY]=headX;
	// 	}
	private static double a;
	private static UnionFind u=new UnionFind();
	private UnionFind(){}
		public static UnionFind getInstance(){
			return u;
	
		}
		
			
	public static void main(String[] args){
		UnionFind u=UnionFind.getInstance();
		System.out.println(UnionFind.a);
		// int[] parentMap=new int[]{1,1,1,4,1,4};
// 		int node=0;
// 		if(node>parentMap.length-1){
// 			System.exit(0);
// 		}
//
// 		System.out.println(find(node,parentMap));
	}
}