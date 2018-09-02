package test;

import java.util.Arrays;
import java.util.Scanner;

public class AAAA {
	public static void main(String[] args) {
		/*int row, column;
		  Double [][]a;
		  System. out. println("Enter the number of rows and columns in the array:");
		  Scanner input = new Scanner(System. in) ;
		  row = input.nextInt();
		  column = input. nextInt();
		  a = new Double [row] [column];
		  System. out. println("Enter the array:");
		  for (Double []i:a) {
			  for (Double j : i) {
				  j = input.nextDouble();
			  }
			  System.out.println(Arrays.toString(i));
		  }*/
		System.out.println(sum(6));
		  
	}
	//递归求和
	static int sum(int count) {
		/*if (count==0) {
			return 0;
		}else {
			return count+sum(--count);
		}*/
		return count!=0?count+sum(--count):0;
	}
}
