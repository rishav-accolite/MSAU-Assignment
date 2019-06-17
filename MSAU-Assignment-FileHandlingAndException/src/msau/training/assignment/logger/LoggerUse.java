package msau.training.assignment.logger;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerUse {
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("Demo Logs");  
		Scanner inp=new Scanner(System.in);

		try {  

			System.out.println("Enter the absolute directory path of output file");
			String destPath=inp.nextLine();
			destPath+="\\logs.txt";
			FileHandler fileHandler =  new FileHandler(destPath, true);
			logger.addHandler(fileHandler);
			fileHandler.setFormatter(new SimpleFormatter());   
			logger.info("Here we start logging");  

		}
		catch (IOException e)
		{  
			e.printStackTrace();  
		}  

		logger.info("The program is running");
		logger.warning("Warning");
		logger.fine("Fine");
		logger.finer("Finer");
		logger.finest("Finest");
		logger.severe("Severe");
		logger.config("config message");
	}
}
