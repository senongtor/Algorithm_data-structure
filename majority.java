import java.util.*;


public class majority{
	
	public static void main(String[] args){
		int[] arr={2,1,3,3,3,1,3};

		int number = arr[0];
		int count = 1;

		for (int i = 0; i<7; i++)
		{
			while(count!=0){
				if (arr[i] == number)
				{
					count++;
				}
				else
					{count--;}
			}
			number=arr[i];
			count=1;
		}
		System.out.println(Integer.toString(number));

}