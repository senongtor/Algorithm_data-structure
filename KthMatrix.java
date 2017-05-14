import java.util.*;
class Point{
    int x;
    int y;
    int val;
    public Point(){}
    public Point(int x,int y,int val){
        this.x=x;
        this.y=y;
        this.val=val;
    }
}
public class KthMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        if(matrix.length==0 || matrix[0].length==0){
            return Integer.MAX_VALUE;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int len=row*col;
        PriorityQueue<Point> pq=new PriorityQueue<>(k, new Comparator<Point>(){
            public int compare(Point a, Point b){
                return a.val-b.val;
            }
        });
        pq.offer(new Point(0,0,matrix[0][0]));
        int count=0;
        while(!pq.isEmpty()){
            Point curr=pq.poll();
            count++;
            if(count==k){
                return matrix[curr.x][curr.y];
            }
            if(curr.x==0 && curr.y<matrix[0].length-1){
                pq.offer(new Point(curr.x,curr.y+1,matrix[curr.x][curr.y+1]));
            }
            if(curr.x<matrix.length-1){
                pq.offer(new Point(curr.x+1,curr.y,matrix[curr.x+1][curr.y]));
            }
        }
        return -1;
    }
    public static void main(String[] args){
      int[][] arr=new int[][]{{1,5,9},{10,11,13},{12,13,15}};
      int k=8;
      System.out.println(kthSmallest(arr,k));

    }
}
