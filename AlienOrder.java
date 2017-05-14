import java.util.*;
public class AlienOrder{
  // public static String alienOrder(String[] words) {
  //   Map<Character, Set<Character>> map=new HashMap<Character, Set<Character>>();
  //   Map<Character, Integer> degree=new HashMap<Character, Integer>();
  //   String result="";
  //   if(words==null || words.length==0) return result;
  //   for(String s: words){
  //       for(char c: s.toCharArray()){
  //           degree.put(c,0);
  //       }
  //   }
  //   for(int i=0; i<words.length; i++){
  //       String cur=words[i];
  //       for(int j=0; j<cur.length()-1; j++){
  //           char c1=cur.charAt(j);
  //           char c2=cur.charAt(j+1);
  //           if(c1!=c2){
  //               Set<Character> set=new HashSet<Character>();
  //               if(map.containsKey(c1)) set=map.get(c1);
  //               if(!set.contains(c2)){
  //                   set.add(c2);
  //                   map.put(c1, set);
  //                   degree.put(c2, degree.get(c2)+1);
  //               }
  //           }
  //       }
  //   }
  //
  //   Queue<Character> q=new LinkedList<Character>();
  //   for(char k:degree.keySet()){
  //     if(degree.get(k)==0){
  //       q.offer(k);
  //     }
  //   }
  //   StringBuilder sb=new StringBuilder();
  //   while(!q.isEmpty()){
  //     char c=q.poll();
  //     sb.append(c);
  //     if(map.get(c)!=null){
  //       Set<Character> neighbors=map.get(c);
  //       for(char ch:neighbors){
  //         degree.put(ch,degree.get(ch)-1);
  //         if(degree.get(ch)==0){
  //           q.offer(ch);
  //         }
  //       }
  //     }
  //   }
  //   return sb.toString();
  // }
  public static String alienOrder(String[] words) {
        if(words.length==0){
            return "";
        }

        StringBuilder sb=new StringBuilder();
        Map<Character,Set<Character>> neighbors=new HashMap<>();
        Map<Character,Integer> inDegrees=new HashMap<>();
        for(String s: words){
            for(char c: s.toCharArray()){
                inDegrees.put(c,0);
            }
        }
        for(int i=0;i<words.length-1;i++){
            String cur=words[i];
            String next=words[i+1];
            int len=Math.min(cur.length(),next.length());
            for(int j=0;j<len;j++){
                char c1=cur.charAt(j);
                char c2=next.charAt(j);
                if(c1!=c2){
                    Set<Character> set=new HashSet<Character>();
                    if(neighbors.containsKey(c1)) set=neighbors.get(c1);
                    if(!set.contains(c2)){
                        set.add(c2);
                        neighbors.put(c1, set);
                        inDegrees.put(c2, inDegrees.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<Character>();
        for(char c: inDegrees.keySet()){
            if(inDegrees.get(c)==0) {
                q.offer(c);
            }
        }
        while(!q.isEmpty()){
            char n=q.poll();
            sb.append(n);
            if(neighbors.containsKey(n)){
                for(char c:neighbors.get(n)){
                    inDegrees.put(c,inDegrees.get(c)-1);
                    if(inDegrees.get(c)==0){
                        q.offer(c);
                    }
                }
            }
        }

        String result=sb.toString();
        if(result.length()!=inDegrees.size()) return "";
        return result;
    }
  public static void main(String[] args){
    //"cbaed"
    String[] words=new String[]{"z","x","z"};
    // String[] words=new String[]{ "cba", "bd", "ce", "ed" };
    String s=alienOrder(words);
    System.out.println(s);
  }
}
