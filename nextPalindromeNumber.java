public class nextPalindromeNumber{
	public static int modifiedNum(String s){
		char[] arr=s.toCharArray();
		int len=arr.length;
		for(int i=0;i<s.length()/2;i++){
			arr[len-i-1]=arr[i];
		}
		return Integer.parseInt(new String(arr));
	}
	public static int get(int x){
		int re=0;
		String s=Integer.toString(x);
		int modified=modifiedNum(s);
		char[] arr=Integer.toString(modified).toCharArray();
		if(modified>x){
			return modified;
		}
		int len=s.length();
		int mid=(len-1)/2;
		if(s.length()%2==0){
			arr[mid]+=1;
			arr[mid+1]+=1;
			return Integer.parseInt(new String(arr));
		}
		else{
			arr[mid]=(char)(s.charAt(mid)+1);
			return Integer.parseInt(new String(arr));
		}
		
	}
	public static void main(String[] args){
		int x=1233;
		System.out.println(get(x));
	}
}