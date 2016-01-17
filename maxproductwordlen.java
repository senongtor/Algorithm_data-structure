public class maxproductwordlen{
	public static int maxProduct(String[] words) {
	        if(words.length==0||words==null){
	            return 0;
	        }
	        PriorityQueue<String> pq=new PriorityQueue<String>(words.length,new Comparator<String>(){
	           public int compare(String a, String b){
	               return b.length()-a.length();
	           } 
	        });
	        for(int i=0;i<words.length;i++){
	            pq.add(words[i]);
	        }
			
	        while(pq.size()>1){
	            String a=pq.poll();
			
				Iterator<String> it=pq.iterator();
				while(it.hasNext()){
					String b=it.next();
		            if((a.replaceAll("[^" + b + "]", "")).isEmpty()){
						
						return a.length()*b.length();
		            }
				}
	        }
	        return 0;
	    }
		public static int maxProduct2(String[] words) {
		        if(words.length==0||words==null){
			            return 0;
			        }
			     int[] len=new int[words.length];
			     int[] val=new int[words.length];
			     for(int i=0;i<words.length;i++){
					 String tmp=words[i];
			         len[i]=tmp.length();
			         
			         int va=0;
			         for(int j=0;j<tmp.length();j++){
			             va|=1<<(tmp.charAt(j)-'a');
			         }
			         val[i]=va;
			     }
			     int max=0;
			     for(int k=0;k<words.length-1;k++){
			         for(int m=k+1;m<words.length;m++){
			             if((val[k]&val[m])==0){
			                 max=Math.max(len[k]*len[m],max);
			             }
			         }
			     }
			     return max;
		    }
			public static void main(String[] args){
				String[] words=new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa"};
				System.out.println(maxProduct2(words)); 
			}
}