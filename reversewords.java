public class reversewords{
	
	public static void main(String[] args){
		String s = "the sky is blue";
		// s=s.replaceAll("(\\s+)"," ");
		        s=s.trim();
		        String re="";
        
		        String[] arr=s.split(" +");
		        for(int i=arr.length-1;i>=0;i--){
		            if(arr[i]!=" "){
		                re=re+arr[i]+" ";
		            }
		        }
		        System.out.println(re);
	}
}