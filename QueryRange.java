import java.util.*;
public class QueryRange {
    int[] tree;

    public QueryRange(int[] nums) {
        tree = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length + 1) {
                tree[j] += nums[i];
                j += lowBit(j);
            }
        }
    }

    public int sumRange(int i, int j) {
        return getSum(j + 1) - getSum(i);
    }

    private int getSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowBit(i);
        }
        return sum;
    }

    private int lowBit(int x) {
        return x&(-x);
    }
    public static void main(String[] args){
        int[] nums=new int[]{-2, 0, 3, -5, 2, -1};
        QueryRange qr=new QueryRange(nums);
        // System.out.println(Arrays.toString(qr.tree));
        // int a=10;
        // int b=12;
        // a=a^b;
        // b=a^b;
        // a=a^b;
        // a=a+b;
        // b=a-b;
        // a=a-b;
        // for(int i=1;i<26;i++){
        //   System.out.println('0'+i);
        // }
        int a = 1;
        char b = (char)(a + '0');
        System.out.println(b);
    }
}
