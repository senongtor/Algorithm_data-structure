import java.util.*;
import java.util.LinkedList;
public class MinTree {
    public static List<Integer> bfs(int n, List<List<Integer>> adj, boolean getMid, int start){
        int[] parent=new int[n];
        int end=0;
        Queue<Integer> q=new LinkedList<Integer>();
        q.offer(start);
        boolean[] visited=new boolean[n];
        while(!q.isEmpty()){
            for(int i=0;i<q.size();i++){
                int node=q.poll();
                end=node;
                visited[node]=true;
                for(int j=0;j<adj.get(node).size();j++){
                    if(visited[adj.get(node).get(j)]){
                        continue;
                    }
                    q.offer(adj.get(node).get(j));
                    parent[adj.get(node).get(j)]=node;
                }
            }
        }
        //System.out.println(Arrays.toString(parent));
        List<Integer> result=new ArrayList<Integer>();
        if(getMid){
          List<Integer> l=new ArrayList<Integer>();
          l.add(end);
          while(parent[end]!=end){
            if(end==start){
              break;
            }
            end=parent[end];
            l.add(end);
          }
          int len=l.size();
          result.add(l.get(len/2));
          if((len&1)==0){
            result.add(l.get((len-1)/2));
          }
        }else{
          result.add(end);
          return result;
        }
        return result;
    }


    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<List<Integer>>(n);
        for(int i=0;i<n;i++){
          adj.add(new ArrayList<Integer>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int point=bfs(n,adj,false,0).get(0);
        return bfs(n,adj,true,point);
    }
    public static void main(String[] args){
      int n = 6;
      int[][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
      System.out.println(findMinHeightTrees(n,edges));
    }
}
