public class BigIntOp{
  public static String bigAdd(String s1,String s2){
    int i=s1.length()-1;
    int j=s2.length()-1;
    StringBuilder sb=new StringBuilder();
    int carry=0;
    while(i>=0 || j>=0){
      int curr=carry;
      if(i>=0){
        curr+=s1.charAt(i)-'0';
        i--;
      }
      if(j>=0){
        curr+=s2.charAt(j)-'0';
        j--;
      }
      carry=curr/10;
      curr=curr%10;
      sb.insert(0,String.valueOf(curr));
    }
    return sb.toString();
  }
  public static void main(String[] args){
    String s1="2231232123123";
    String s2="1111111111111";
    System.out.println(bigAdd(s1,s2));
  }
}
