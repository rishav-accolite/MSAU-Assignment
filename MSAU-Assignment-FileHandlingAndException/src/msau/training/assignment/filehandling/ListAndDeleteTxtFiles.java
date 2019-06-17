package msau.training.assignment.filehandling;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class ListAndDeleteTxtFiles {
	//below method list and deletes all .txt files in a folder
	public static void listAndDeleteAllTxtfiles(File dir)
	{
		
		File[] txtFiles=dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		for(File f:txtFiles)
		{
			System.out.println(f.getAbsolutePath());
			f.delete();
		}
		System.out.println("All above listed files are deleted");
	}

	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter the absolute path of the directory");
		String path=inp.nextLine();
		listAndDeleteAllTxtfiles(new File(path));
		inp.close();
		
		

	}

}
