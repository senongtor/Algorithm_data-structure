import java.util.*;
public class AmicablePairs{
  public static int sumUp(int n){
    int sum = 1, i;
        for (i = 2; i * i < n; ++i) {
            if (n % i == 0) {
                sum += i + n / i;
            }
        }
        if (i * i == n) {
            sum += i;
        }
        return sum;
  }
  public static void main(String[] args){
    // System.out.printf("%d,%d",sumUp(220),sumUp(284));
    List<List<Integer>> pairs=new ArrayList<List<Integer>>();
    int k=300;
    for(int i=1;i<=k;i++){
      int first=sumUp(i);
      if(first>k){
        continue;
      }
      int second=sumUp(first);
      if(second==i && second<first){
        pairs.add(new ArrayList<Integer>(Arrays.asList(first,second)));
      }
    }
    System.out.println(pairs);
  }
}
