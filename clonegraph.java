import java.util.*;
class UndirectedGraphNode{
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	public UndirectedGraphNode(int label){
		this.label=label;
		neighbors=new ArrayList<UndirectedGraphNode>();
	}
	@Override
	public String toString(){
		return Integer.toString(label);
	}
}
public class clonegraph{
	
	public static UndirectedGraphNode copy(UndirectedGraphNode node) {
        if(node==null){
        	return null;
        }
		UndirectedGraphNode copyhead=new UndirectedGraphNode(node.label);
		Map<UndirectedGraphNode,UndirectedGraphNode> map=new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
		Queue<UndirectedGraphNode> q=new LinkedList<UndirectedGraphNode>();
		map.put(node,copyhead);
		q.add(node);
		while(!q.isEmpty()){
			UndirectedGraphNode curr=q.poll();
			for(UndirectedGraphNode sub:curr.neighbors){
				if(!map.containsKey(sub)){
					UndirectedGraphNode newsub=new UnmdirectedGraphNode(sub.label);
					map.put(sub,newsub);
					map.get(curr).neighbors.add(newsub);
					q.add(sub);
				}
				else{
					map.get(curr).neighbors.add(map.get(sub));
				}
			}
		}
		return copyhead;
	    }
	
	public static void main(String[] args){
		UndirectedGraphNode a0=new UndirectedGraphNode(0);
		UndirectedGraphNode a1=new UndirectedGraphNode(1);
		UndirectedGraphNode a2=new UndirectedGraphNode(2);
		
		a0.neighbors.add(a1);
		a0.neighbors.add(a2);
		a1.neighbors.add(a2);
		a2.neighbors.add(a2);
		System.out.println(copy(a0).neighbors);
	}
}