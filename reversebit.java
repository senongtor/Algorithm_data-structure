public class reversebit{
	public static int reverseBits(int n) {
		for (int i = 0; i < 16; i++) {
			n = swapBits(n, i, 32- i - 1);
		}

		return n;
	}

	public static int swapBits(int n, int i, int j) {
		int a = (n >> i) & 1;
		int b = (n >> j) & 1;
 
		if ((a ^ b) != 0) {
			return n ^= (1 << i) | (1 << j);
		}
 
		return n;
	}
	public static boolean ispalin(int i){
		for(int j=0;j<16;j++){
			int a=(i>>j)&1;
			int b=(i>>31-j)&1;
			if((a^b)==1){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		System.out.println(reverseBits(8));
		System.out.println(ispalin(10));
	}
}