import java.util.*;
public class HitCounter{
  private static int FIVEMINS=300;
  private static Queue<Integer> queue=new LinkedList<Integer>();
  private static int[] times=new int[300];
  private static int[] hits=new int[300];
  public static void hit(int timestamp){
    // queue.offer(timestamp);
    int t=timestamp%300;
    if(times[t]<timestamp){
      times[t]=timestamp;
      hits[t]=1;
    }else{
      hits[t]++;
    }
  }
  public static void getHits(int timestamp){
    // while(!queue.isEmpty() && timestamp-queue.peek() >=300){
    //   queue.poll();
    // }
    // System.out.println(queue.size());
    int re=0;
    for(int i=0;i<300;i++){
      if(timestamp-times[i]>=300){
        continue;
      }
      re+=hits[i];
    }
    System.out.println(re);
  }
  public static void main(String[] args){
    // hit at timestamp 1.
    for(int i=0;i<times.length;i++){
      times[i]=-1;
    }
    hit(1);
    // hit at timestamp 2.
    hit(2);
    // hit at timestamp 3.
    hit(3);
    // get hits at timestamp 4, should return 3.
    getHits(4);
    // hit at timestamp 300.
    hit(300);
    // get hits at timestamp 300, should return 4.
    getHits(300);
    // get hits at timestamp 301, should return 3.
    getHits(301);
  }
}
