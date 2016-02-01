public class trailingzeros{
 public static int countzeros(int n){
         if(n==0){
             return 0;
         }
         int count=0;
		 int m=n;
         while(n>=5){
             n=n/5;
             count++;
         }
         int sum=0;
         for(int i=1;i<=count;i++){
			 int div=(int)Math.pow(5,i);
             sum=sum+m/div;
         }
         return sum;
     }
	 public static void main(String[] args){
		 System.out.println(countzeros(70));
	 }
}