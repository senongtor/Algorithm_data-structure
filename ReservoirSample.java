import java.util.*;
public class ReservoirSample{
  public static List<Integer> generate(int k,int n){
    boolean[] used=new boolean[n];
    Random r=new Random();
    List<Integer> re=new LinkedList<Integer>();
    while(re.size()<k){
      int num=r.nextInt(n);
      if(used[num]){
        continue;
      }
      used[num]=true;
      re.add(num);
    }
    return re;
  }
  public static List<Integer> generateReservoir(int k,int n){
    Random r=new Random();
    List<Integer> re=new LinkedList<Integer>();
    int res=0;
    for(int i=0;i<=n;i++){
      if(re.size()<k){
        re.add(i);
      }else{
        int t=r.nextInt(i+1);
        if(t<k){
          re.set(t,i);
        }
      }
    }
    return re;
  }
  public static void main(String[] args){
    System.out.println(generateReservoir(3,10));
    int[][] m=new int[6][6];
    int num=36;
    List<Integer> ones=generateReservoir(6,36);
    for(int n:ones){
      m[n/6][n%6]=1;
    }
    System.out.println(Arrays.deepToString(m));
  }
}
