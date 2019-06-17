package msau.training.assignment.filehandling;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class CopyFile {
	public static void copyFile(File file,File dest)
	{
		try {
			Files.copy(file.toPath(), dest.toPath());
			System.out.println("File copied successfully");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Scanner inp=new Scanner(System.in);
		System.out.println("Enter the file with absolute path");
		String srcFile=inp.nextLine();
		System.out.println("Enter the absolute location where to copy file");
		String destPath=inp.nextLine();
		File src=new File(srcFile);
		destPath+="\\"+src.getName();
		copyFile(src,new File(destPath));
		inp.close();

	}

}
