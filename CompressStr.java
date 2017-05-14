import java.util.*;
public class CompressStr{
  public static String compress(String s){
    if(s.length()<=1){
      return s;
    }
    StringBuilder sb=new StringBuilder();
    sb.append(s.charAt(0));
    char ch=s.charAt(0);
    for(int i=1;i<s.length();i++){
      if(s.charAt(i)==ch){
        continue;
      }else{
        sb.append(s.charAt(i));
        ch=s.charAt(i);
      }
    }
    return sb.toString();
  }
  public static void main(String[] args){
    String s="abbbbbc";
    System.out.println(compress(s));

  }
}
