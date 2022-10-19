package mypackage;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Aman {

	public static void main(String[] args) throws IOException {
	System.out.println("Welcome to LockedMe.com");
	Scanner scanner = new Scanner(System.in);
	int choice = 0;
	System.out.println("Application name:LockedMe.com");
	System.out.println("Developer name: Dhanala Tarakeswara Rao");
	System.out.println("Directory path : D:\\Phase 01 Project ");
	final String location = "D:\\Phase 01 Project";
	do {
		System.out.println("File Menu");
		System.out.println("-------------------------");
		System.out.println("1)List the filenames in ascending order");
		System.out.println("2)User interaction options");
		System.out.println("3)Exit");
		System.out.println("-------------------------");
		System.out.print("Enter your choice: ");
		try {
			choice = Integer.parseInt(scanner.nextLine());
		}
		catch(NumberFormatException e) {
			System.out.println("Please enter a numerical value");
			continue;
	}
		System.out.println("-------------------------");
		switch(choice) {
		case 1:
			System.out.println("File and directory are listed in ascending order");
			System.out.println();
			try {
			File file = new File(location);
            File filedirec [] = file.listFiles();
            Arrays.sort(filedirec);
            for(File e : filedirec) {
            	if (e.isFile()) {
            		System.out.println("File:" + e.getName());
            		System.out.println();
            	}
            	else if (e.isDirectory()) {
            		System.out.println("Directory:" + e.getName());
            		System.out.println();
            	}	
            	else {
            		System.out.println("Not Known:" + e.getName());
            		System.out.println();
            	}		
            }
			}
			catch(Exception e) {
				System.err.println("Directory Path must be present to do this operation :");
				System.err.println("Directory Path : D:\\Phase 01 Project ");
			}
			break;

		case 3:
			System.out.println("Thank you for choosing LockedMe.com");
			break;
		default:
			System.out.println("Invalid Option : Try Again");	
		}	
	}while(choice!=3);
	scanner.close();
	}



}
