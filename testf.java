import java.util.*;
import java.io.*;

public class testf{
	public static void main(String[] args) throws IOException{
		// The name of the file to open.
		
		        Scanner reader = new Scanner(new FileInputStream(args[0]));
			while (reader.hasNext()) {      // while there is another token to read
			
		            String s = reader.next();  
					int token=Integer.parseInt(s);
					
					
					int[] address=new int[token];
					System.out.println(s);
				}
	}
}