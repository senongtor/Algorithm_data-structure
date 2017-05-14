import java.util.*;
class Point{
  int x;
  int y;
  public Point(){}
  public Point(int x,int y){
    this.x=x;
    this.y=y;
  }
  public String toString(){
    return String.format("x:%d,y:%d",x,y);
  }
}
public class PathFinder{
  public static void dfs(int x,int y,String[][] m,boolean[][] visited,List<Point> curr,List<List<Point>> re){
    if(x<0 || y<0 || x>=m.length || y>=m[0].length){
      return;
    }
    if(visited[x][y]){
      return;
    }
    if(m[x][y].equals("X")){
      return;
    }
    visited[x][y]=true;
    curr.add(new Point(x,y));

    if(x==m.length-1 && y==m[0].length-1){
      re.add(new ArrayList<Point>(curr));
    }
                 dfs(x+1,y,m,visited,curr,re);
                 dfs(x,y+1,m,visited,curr,re);
                 dfs(x-1,y,m,visited,curr,re);
                 dfs(x,y-1,m,visited,curr,re);
    // if(flag){
    //
    // }
    curr.remove(curr.size()-1);
    visited[x][y]=false;
    // if(x==0 && y==0){
    //   re.add(new ArrayList<Point>(curr));
    // }
    return;
  }
  public static List<List<Point>> findAll(String[][] m){
    List<List<Point>> re=new ArrayList<List<Point>>();
    if(m.length==0 || m[0].length==0){
      return re;
    }
    boolean[][] visited=new boolean[m.length][m[0].length];
    dfs(0,0,m,visited,new ArrayList<Point>(),re);
    return re;
  }
  public static int countPaths(String[][] m){
    int[] dp=new int[m.length];
    for(int i=0;i<m.length;i++){
      dp[i]=1;
    }
    for(int row=1;row<m.length;row++){
      for(int col=1;col<m.length;col++){
        dp[col]=dp[col]+dp[col-1];
      }
    }
    return dp[m.length-1];
  }
  public static void main(String[] args){
    String[][] m=new String[][]{{"","","","X"},
                                {"","X","","X"},
                                {"","","","X"},
                                {"X","","",""}};
    System.out.println(countPaths(m));
  }
}
