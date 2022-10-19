package mypackage;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MenuAndFeatures {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to LockedMe.com");
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		System.out.println("Application name: LockedMe.com");
		System.out.println("Developer name: Dhanala Tarakeswara Rao");
		System.out.println("Directory path : D:\\Phase 01 Project\\");
		final String location = "D:\\Phase 01 Project";
		do {
			System.out.println("File Menu");
			System.out.println("-------------------------");
			System.out.println("1)List the file names in ascending order");
			System.out.println("2)User interaction features");
			System.out.println("3)Exit");
			System.out.println("-------------------------");
			System.out.print("Enter your choice: ");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a numerical value.");
				continue;
			}
			System.out.println("-------------------------");
			switch (choice) {
			case 1:
				System.out.println("File and directory are listed in ascending order");
				System.out.println();
				try {
					File file = new File(location);
					File filedirec[] = file.listFiles();
					Arrays.sort(filedirec);
					for (File e : filedirec) {
						if (e.isFile()) {
							System.out.println("File:" + e.getName());
							System.out.println();
						} else if (e.isDirectory()) {
							System.out.println("Directory:" + e.getName());
							System.out.println();
						} else {
							System.out.println("Not known:" + e.getName());
							System.out.println();
						}
					}
				} catch (Exception e) {
					System.err.println("Directory Path must be present to do this operation :");
					System.err.println("Directory Path : D:\\Phase 01 Project\\");
				}
				break;
			case 2:
				int subchoice = 0;
				do {
					System.out.println();
					System.out.println("User interaction features:");
					System.out.println("-------------------------");
					System.out.println("1)Add a File");
					System.out.println("2)Delete a File");
					System.out.println("3)Search a FIle");
					System.out.println("4)Main Menu");
					System.out.println("-------------------------");
					System.out.print("Enter your choice: ");

					try {
						subchoice = Integer.parseInt(scanner.nextLine());
					} catch (NumberFormatException e) {
						System.out.println("Please enter a numerical value.");
						continue;
					}

					System.out.println("-------------------------");
					System.out.println();

					switch (subchoice) {

					case 1:
						System.out.print("Enter the file name to be added : ");
						String fileName = scanner.nextLine().toLowerCase();
						try {
							Path path = Paths.get("D:\\Phase 01 Project\\" + fileName + ".txt");
							if (Files.exists(path)) {
								System.out.println("A file exists on this name, please give a different name");
							} else {
								Path pathdone = Files.createFile(path);
								System.out.println("File is created :" + pathdone.toString());
							}

						} catch (Exception e) {
							e.printStackTrace();
							continue;
						}
						break;
					case 2:
						System.out.print("Enter the file name to be deleted : ");
						String fileName2 = scanner.nextLine();
						try {
							Path path = Paths.get("D:\\Phase 01 Project\\" + fileName2 + ".txt");
							if (Files.exists(path)) {
								Files.delete(path);
								System.out.println("File deleted successfully");
							} else {
								System.out.println("File does not exist");
							}

						} catch (Exception e) {
							e.printStackTrace();
							continue;
						}
						break;
					case 3:
						boolean flag = false;
						System.out.print("Enter the filename to be search:  ");
						String fileName3 = scanner.nextLine().toLowerCase();
						File file = new File(location);
						File filedirec[] = file.listFiles();
						for (int i = 0; i < filedirec.length; i++) {
							if (filedirec[i].getName().startsWith(fileName3)) {
								System.out.println(filedirec[i].toString());
								flag = true;
							}
						}
						if (flag == false) {
							System.out.println("File not found");
						}
						break;
					case 4:
						System.out.println("Returning to the Main menu");
						break;

					default:
						System.out.println("Invaid option : Try again");
					}
				} while (subchoice != 4);
			case 3:
				System.out.println("Thank you for choosing LockedMe.com");
				break;
			default:
				System.out.println("Invalid option : Try again");
			}
		} while (choice != 3);
		scanner.close();
	}
}
