package msau.training.assignment.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHandling {
	public static void main(String[] args) {
		try
		{
			double num=10/0;			
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
		}
		try
		{
			int ar[]=new int[2];
			System.out.println(ar[3]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			e.printStackTrace();
		}
		try
		{
			FileInputStream fi=new FileInputStream(new File("C:\\Users\\rishav.gupta\\Desktop\\New folder\\Lift.txt"));
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		System.out.println("Program Finished");
	}

}
