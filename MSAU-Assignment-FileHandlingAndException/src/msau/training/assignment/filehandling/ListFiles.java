package msau.training.assignment.filehandling;

import java.io.File;
import java.util.Scanner;

public class ListFiles {
	//Below method list all files recursively in directory
	public static void listAllFiles(File dir)
	{
		File[] subdir=dir.listFiles();
		for(File f:subdir)
		{
			if(f.isDirectory())
			{
				listAllFiles(f);
			}
			else
			{
				System.out.println(f.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter absolute path of directory");
		String path=inp.nextLine();
		System.out.println("All files in directory and sub directory are as follows: ");
		listAllFiles(new File(path));
		inp.close();
		

	}

}
