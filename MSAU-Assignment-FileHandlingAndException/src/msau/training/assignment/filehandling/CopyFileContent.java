package msau.training.assignment.filehandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

//copy the content of one text file to another
public class CopyFileContent {
	public static void copyContent(File src,File dest)
	{
		try
		{
			FileInputStream input=new FileInputStream(src);
			FileOutputStream output=new FileOutputStream(dest, true);
			byte buffer[]=new byte[1024];
			int length=0;
			while((length=input.read(buffer))>0)
			{
				output.write(buffer, 0, length);
			}
			System.out.println("Contents of source file copied and appended to destination file successfully");
			input.close();
			output.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter the source file with absolue path");
		String src=inp.nextLine();
		System.out.println("Enter the destination file with absolue path");
		String dest=inp.nextLine();
		copyContent(new File(src), new File(dest));
		inp.close();
		
		

	}

}
