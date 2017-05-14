import java.util.*;
class TopologicalSort{
  public static boolean dfs(int n,Set<Integer> visited,List<List<Integer>> graph,LinkedHashSet<Integer> stack){
    if(visited.contains(n)){
      return false;
    }
    visited.add(n);
    List<Integer> neighbors=graph.get(n);
    for(int neighbor:neighbors){
      if(!dfs(neighbor,visited,graph,stack)){
        return false;
      }
    }
    visited.remove(n);
    stack.add(n);
    return true;
  }
  public static void main(String[] args){
    List<List<Integer>> graph=new ArrayList<List<Integer>>();
    for(int i=0;i<6;i++){
      graph.add(new ArrayList<Integer>());
    }
    graph.get(2).add(3);
    graph.get(3).add(1);
    graph.get(4).add(1);
    graph.get(4).add(0);
    graph.get(5).add(2);
    graph.get(5).add(0);
    LinkedHashSet<Integer> stack=new LinkedHashSet<Integer>();
    Set<Integer> visited=new HashSet<Integer>();
    for(int i=0;i<6;i++){
      if(!dfs(i,visited,graph,stack)){
        System.out.println("Cycle!");
        return;
      }
    }
    List<Integer> re=new ArrayList<Integer>();
    for(Integer i:stack){
      System.out.println(i);
    }
  }

}
