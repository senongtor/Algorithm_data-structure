
import java.util.*;
// class Point{
//   int x;
//   int y;
//   public Point(){}
//   public Point(int x,int y){
//       this.x=x;
//       this.y=y;
//   }
//   public String toString(){
//       return String.format("%d,%d",x,y);
//   }
// }
// class Rec{
//   Point leftTop;
//   Point rightBot;
//   public Rec(){}
//   public Rec(Point p1,Point p2){
//     leftTop=p1;
//     rightBot=p2;
//   }
//   public String toString(){
//     return String.format("Left:%s,Right:%s",leftTop.toString(),rightBot.toString());
//   }
// }
public class Rectangles{
  public static int[][] BFS(int[][] matrix,int i,int j,boolean[][] visited){
      int[][] result=new int[2][2];
      Queue<int[]> q=new LinkedList<int[]>();
      int[] start=new int[]{i,j};
      q.offer(start);
      visited[i][j]=true;
      // Rec r=new Rec();
      result[0]=start;
      // r.leftTop=new Point(i,j);
      int[][] directions=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
      int[] tmp=new int[2];
      while(!q.isEmpty()){
         int[] p=q.poll();
         tmp=p;
         for(int k=0;k<directions.length;k++){
            int x=p[0]+directions[k][0];
            int y=p[1]+directions[k][1];
            if(x<0 || y<0 || x>=matrix.length || y>= matrix[0].length){
              continue;
            }
            if(matrix[x][y]==1){
              continue;
            }
            if(visited[x][y]){
              continue;
            }
            visited[x][y]=true;
            q.offer(new int[]{x,y});
         }
      }
      // r.rightBot=tmp;
      result[1]=tmp;
      return result;
  }
  public static void main(String[] args){
    int[][] m=new int[][]{
      {1,1,1,1,1,1},
      {1,0,0,0,1,1},
      {1,0,0,0,1,1},
      {1,1,1,1,1,0},
      {1,1,1,1,1,0}};
      boolean[][] visited=new boolean[m.length][m[0].length];
      for(int i=0;i<m.length;i++){
        for(int j=0;j<m[0].length;j++){
          if(m[i][j]==0 && !visited[i][j]){
            System.out.println(Arrays.deepToString(BFS(m,i,j,visited)));
          }
        }
      }
  }
}
