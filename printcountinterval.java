   public class printcountinterval{		
		public static int outinter(int[] arr, int in){
			int count=0;
			for(int i=0;i<arr.length;i+=in){
				int end=0;
				System.out.print("{");
				if(i+in<arr.length){
					end=i+in;
				}
				else{
					end=arr.length;
				}
					for(int j=i;j<end;j++){
						System.out.print(arr[j]);
					}
					System.out.print("}\n");
				count++;
			}
			return count;
		}
		public static void main(String[] args){
			System.out.println(outinter(new int[]{1,2,3,4,5},2));
		}
	}