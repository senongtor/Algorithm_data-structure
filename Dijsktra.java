import java.util.*;
class Node{
  char name;
  int dist;
  public Node(){}
  public Node(char name,int dist){
    this.name=name;
    this.dist=dist;
  }
  public String toString(){
    return String.format("distance: %d",dist);
  }
  public boolean equals(Node n){
    return this.name==n.name;
  }
}
public class Dijsktra{
  public static void main(String[] args){
    Map<String,Integer> weights=new HashMap<>();
    weights.put("ab",7);
    weights.put("ba",7);
    weights.put("ae",14);
    weights.put("ea",14);
    weights.put("af",9);
    weights.put("fa",9);
    weights.put("bc",15);
    weights.put("cb",15);
    weights.put("bf",10);
    weights.put("fb",10);
    weights.put("ef",2);
    weights.put("fe",2);
    weights.put("cf",11);
    weights.put("fc",11);
    weights.put("cd",6);
    weights.put("dc",6);
    weights.put("de",9);
    weights.put("ed",9);
    
    //get the shortest dist a->d
    Map<Character,List<Character>> graph=new HashMap<>();
    for(Map.Entry<String,Integer> entry:weights.entrySet()){
      char x=entry.getKey().charAt(0);
      char y=entry.getKey().charAt(1);

      if(!graph.containsKey(x)){
        graph.put(x,new ArrayList<Character>());
      }
      if(!graph.containsKey(y)){
        graph.put(y,new ArrayList<Character>());
      }
      graph.get(x).add(y);
      graph.get(y).add(x);
    }

    PriorityQueue<Node> pq=new PriorityQueue<>(graph.size(),new Comparator<Node>(){
      public int compare(Node n1,Node n2){
        return n1.dist-n2.dist;
      }
    });

    Map<Character,Node> nodes=new HashMap<>();
    for(Character ch:graph.keySet()){
      Node node=null;
      if(ch=='a'){
        node=new Node(ch,0);
      }else{
        node=new Node(ch,Integer.MAX_VALUE);
      }
      nodes.put(ch,node);
      pq.offer(node);
    }

    Map<Character,Character> prev=new HashMap<>();
    while(!pq.isEmpty()){
      Node root=pq.poll();
      List<Character> neighbors=graph.get(root.name);
      for(char ch:neighbors){
        Node curr=nodes.get(ch);
        StringBuilder sb=new StringBuilder();
        String edge=sb.append(root.name).append(curr.name).toString();
        int dist=root.dist+weights.get(edge);
        if(dist<curr.dist){
          curr.dist=dist;
          nodes.put(ch,curr);
          prev.put(curr.name,root.name);
          pq.remove(curr);
          pq.offer(curr);
        }
      }
    }
    System.out.println(nodes);
  }
}
