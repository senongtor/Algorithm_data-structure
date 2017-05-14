import java.util.*;
public class LongestRepeatingRe{
    public static int characterReplacement(String s, int k) {
        int res = 0, maxCnt = 0, start = 0;
        int[] counts=new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'A']++;
            maxCnt = Math.max(maxCnt, counts[s.charAt(i) - 'A']);
            while (i - start + 1 - maxCnt > k) {
                counts[s.charAt(i) - 'A']--;
                start++;
            }
            res = Math.max(res, i - start + 1);
        }
        System.out.println(start);
        System.out.println(Arrays.toString(counts));
        return res;
    }
    public static void main(String[] args){
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }
}
