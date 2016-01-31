public class largestRectangleArea {
    public int LRA(int[] heights) {
        if(heights==null||heights.length==0){
            return 0;
        }
       
        Arrays.sort(heights);
        int minsum=0;
        for(int i=0;i<heights.length;i++){
            minsum+=heights[0];
        }
         int max=minsum;
        for(int i=0;i<heights.length-1;i++){
            
            minsum=(minsum-heights[i])+(heights[i+1]-heights[i])*(heights.length-1-i);
            max=Math.max(minsum,max);
        }
        return max;
    }
}