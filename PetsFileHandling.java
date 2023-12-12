import java.io.*;
import java.util.LinkedList;
import java.util.Scanner; 

/**
 * Class Name: PetsFileHandling 
 * @author: Allie Marcum 
 * @version: 2.0
 * Course: CSE 274
 * Date: September 22, 2023
 * 
 * Function: to handle the main, and file reading/writing 
 * Class to read information about the pets from a file 
 * and save the information in the file 
 */
public class PetsFileHandling {
	
	/**
	 * Function: prints the information to file
	 * Activated when the user chooses to save to file
	 * 
	 * @param petInfo, the LinkedList holding pet objects 
	 * @param outoutFileName the name of the file to write to
	 */
	public static void writeFile (LinkedList<Pets> petInfo, String outputFileName) {
		
		// open the printwriter to write to file
		PrintWriter outToFile = null; 
		
		// assign the printwriter if the file is found 
		try { 
			outToFile = new PrintWriter(outputFileName); 
		} 
		catch (IOException ex) { 
			ex.printStackTrace(); 
			System.out.println("The file was not found, try again."); 
			System.exit(1);
		}
		
		// after the file is opened, write to it 
		// catch if there's an issue printing 
		try { 
			 
			// look through all objects to print their variables 
			for (int i = 0; i < petInfo.size(); i++) {
				
				// toPrint is the string to print out to file 
				String toPrint = null;
				
				// identify if the object is a cat 
				if (petInfo.get(i).type.equalsIgnoreCase("Cat")) { 
					Cats c = new Cats();
					c = (Cats) petInfo.get(i); 
					toPrint = (c.uniqueID
							+ "\n" + c.petName + "\n" 
							+ c.ownerName + "\n"
							+ c.type + "\n"
							+ c.age + "\n" 
							+ c.longFur + "\n"); 
				}
				
				// if the object isn't a cat, it's a dog 
				else { 
					Dogs d = new Dogs();
					d = (Dogs) petInfo.get(i); 
					toPrint = (d.uniqueID
							+ "\n" + d.petName + "\n" 
							+ d.ownerName + "\n"
							+ d.type + "\n"
							+ d.age + "\n" 
							+ d.breed + "\n"); 
				}
				
				// print toPrint to the file 
				outToFile.print(toPrint); 
			} 
			
			// close the printer 
			outToFile.close(); 
				

		}
		catch (Exception ex) { 
			ex.printStackTrace(); 
			System.out.println("There was an issue printing to file. "
					+ "Try again.");
		}
		
		return; 
		
	} // end writeFile method 
	
	/**
	 * Function: to read the text file and make an array list of pets 
	 * 
	 * @param inputFileName, the name of the input file 
	 * @return an array list holding pet objects
	 */
	public static LinkedList<Pets> readFile (String inputFileName) { 
		// create a new array list of Pets 
		// this is were the pets will be added to  
		LinkedList<Pets> petInfo = new LinkedList<Pets> (); 
	
		// create the scanner to read from the file 
		// initialize the file 
		Scanner inFile = null; 
		File inputFile = new File (inputFileName);
		
		// assign the scanner 
		// catch if the file isn't found 
		try { 
			inFile = new Scanner (inputFile);
		}
		catch (IOException ex) { 
			ex.printStackTrace(); 
			System.out.println("The file was not found, please try again."); 
			System.exit(1);
		}
		
		// read off each variable and assign it to a dog or cat object 
		// then each objects gets assigned to petInfo array list 
		try { 
			// end once there's no lines to read 
			while (inFile.hasNextLine()) {
				// uniqueID 
				int uniqueID = Integer.parseInt(inFile.nextLine()); 
				// petName 
				String petName = inFile.nextLine(); 
				// ownerName 
				String ownerName = inFile.nextLine(); 
				// dog or cat 
				String type = inFile.nextLine(); 
				// age 
				int age = Integer.parseInt(inFile.nextLine());
				// longFur for cat or breed for dog 
				String specificValue = inFile.nextLine(); 
				
				// create a cat object if the pet is a cat 
				// add to pet array list 
				if (type.equalsIgnoreCase("cat")) { 
					boolean longFur = 
							Boolean.parseBoolean(specificValue); 
					Cats c = new Cats (uniqueID, petName, ownerName, 
							type, age, longFur); 
					petInfo.add(c); 
				}
				
				// if it's not a cat, it's a dog 
				// create a dog object 
				// add to pet array list 
				else{ 
					String breed = specificValue; 
					Dogs d = new Dogs (uniqueID, petName, ownerName, 
							type, age, breed); 
					petInfo.add(d); 
				}
			}// end while loop 
			
		} catch (Exception ex) { 
			ex.printStackTrace(); 
			System.out.println("There was an issue reading the file."); 
		} 
		
		// close the scanner 
		inFile.close(); 
		
		// return the array list
		return petInfo; 
		
	} // end readFile method 
	
	/**
	 * Function: print information about a cat to the user 
	 * 
	 * @param c, an object Cats
	 */
	public static void formatForView (Cats c) { 
		System.out.print("ID: " + c.uniqueID + "  Pet Name: " + c.petName 
				+ "   Owner Name: " + c.ownerName +  "   Age: " +  c.age 
				+ "   Long Fur? : " + c.longFur + "\n"); 
		return; 
		
	} // end formatForView (CATS) method 
	
	/**
	 * Function: print information about a dog to the user 
	 * 
	 * @param d, an object Dogs 
	 */
	public static void formatForView (Dogs d) { 
		System.out.print("ID: " + d.uniqueID + "  Pet Name: " + d.petName 
				+ "   Owner Name: " + d.ownerName + "   Age: " + d.age
				+ "   Breed: " + d.breed + "\n");
		return; 
		
	} // end formatForView (DOGS) method 
	
	/**
	 * Function: present the user with information about the pets in terminal 
	 * 
	 * @param petInfo, LinkedList holding pet objects 
	 */
	public static void view (LinkedList<Pets> petInfo) { 
		System.out.println("\nThe pets within the file are as follows:"); 
		
		// identifies the type of each object in the LinkedList 
		for (int i = 0; i < petInfo.size(); i++) { 
			
			// type = dog 
			if (petInfo.get(i).type.equalsIgnoreCase("dog")) { 
				formatForView((Dogs) petInfo.get(i)); 
			}
		
			// type = cat
			if (petInfo.get(i).type.equalsIgnoreCase("Cat")) { 
				formatForView((Cats) petInfo.get(i)); 
			}
		
		} // end for loop 
	
		return; 
		
	} // end view method 
	
	/**
	 * Function: to delete a pet from the system 
	 * 
	 * @param petInfo, the LinkedList holding the information about the pets
	 */
	public static void delete (LinkedList<Pets> petInfo) { 
		// open the scanner 
		Scanner in = new Scanner (System.in); 
		
		// ask the user which pet to delete by uniqueID 
		// print the pets and their names for easy identification 
		
		// print the uniqueID and name of each pet in the LinkedList
		for (int i = 0; i < petInfo.size(); i++) { 
			System.out.println("ID: " + petInfo.get(i).uniqueID
					+ "  Name: " + petInfo.get(i).petName);
		} // end for loop 
		
		boolean found = false; 
		int deleting = 0; 
		while (found == false) {
			// ask user which pet to delete 
			System.out.print("\nEnter the uniqueID of the pet "
					+ "you'd like to delete: ");
		
			// identify the pet to delete and parse it to int form 
			deleting = Integer.parseInt(in.nextLine()) -1; 
			
			for (int i = 0; i < petInfo.size(); i++) { 
				if (deleting > 0 && deleting < petInfo.size()) { 
					if (petInfo.get(i).uniqueID == deleting) { 
						found = true; 
					}
				} 
			} // end for loop 
	
		} // end while loop 
		
		// subtract one to match LinkedList and user view 
		petInfo.remove(deleting); 
		
		// confirm to the user that the pet was deleted 
		System.out.println("The pet was deleted from the system.\n"); 
		
		return; 
		
	} // end delete method 

	
	/**
	 * Function: To create a cat object to add to petInfo 
	 * 
	 * @param petInfo, the LinkedList of pet objects 
	 * @param petName, the name of the pet 
	 * @param ownerName, the name of the owner 
	 * @param type, dog or cat 
	 * @param age, how old the pet is 
	 * 
	 * @return the unique ID of the pet 
	 */
	public static int makeCat (LinkedList <Pets> petInfo, 
			String petName, String ownerName, String type, int age) {
		
		// initialize the scanner 
		Scanner in = new Scanner (System.in);
		
		// create a cat object 
		Cats c = new Cats(); 
		
		// ask if the cat has long fur 
		System.out.print("(Yes/No) Does the cat have long fur? : ");
		boolean longFur = Boolean.parseBoolean(in.next()); 
		
		// print the attributes for confirmation 
		System.out.println("\nThe pet's attributes are as below:"); 
		c.uniqueID = petInfo.size () + 1; 
		c.petName = petName; 
		c.ownerName = ownerName; 
		c.type = "cat"; 
		c.age = age; 
		c.longFur = longFur; 
		petInfo.add(c);   

		System.out.println("uniqueID: " + c.uniqueID + "  Name: " + c.petName 
				+ "  Owner Name: " + c.ownerName 
				+ "  Age: " + c.age + "  Long Fur? : " + c.longFur);  
		
		// return the uniqueID of the cat 
		return c.uniqueID; 
		
	} // end the makeCat method 
	
	/**
	 * Function: to create a dog object to add into petInfo 
	 * 
	 * @param petInfo, the LinkedList of pets 
	 * @param petName, the name of the pet 
	 * @param ownerName, the name of the owner 
	 * @param type, dog or cat 
	 * @param age, how old is the dog 
	 * 
	 * @return the unique id the pet 
	 */
	public static int makeDog (LinkedList <Pets> petInfo,  
			String petName, String ownerName, String type, int age) {
		// initialize the scanner 
		Scanner in = new Scanner (System.in); 
		
		// create a new dog object 
		Dogs d = new Dogs (); 
		
		// ask what the breed of the dog is 
		System.out.print("What is the breed of the dog? : "); 
		String breed = in.next(); 
		
		// print the attributes to the user for confirmation 
		System.out.println("\nThe pet's attributes are as below:"); 
		d.uniqueID = petInfo.size() + 1; 
		d.petName = petName; 
		d.ownerName = ownerName; 
		d.type = "dog"; 
		d.age = age; 
		d.breed = breed; 
		petInfo.add(d);
		System.out.println("uniqueID: " + d.uniqueID + "  Name: " + d.petName 
				+ "  Owner Name: " + d.ownerName 
				+ "  Age: " + d.age + "  Breed: " + d.breed); 
		
		// return the uniqueID of the dog 
		return d.uniqueID; 
		
	}// end makeDog method 

	
	/**
	 * Function: to add a pet into the system 
	 * 
	 * @param petInfo, the array of pet objects 
	 */
	public static void add (LinkedList<Pets> petInfo) { 
		// create the scanner 
		Scanner in = new Scanner (System.in); 
		
		// ask questions about the pet to identify traits 
		System.out.println("\nPlease answer the following "
				+ "questions about the pet: ");
		// pet name 
		System.out.print("Name of the pet: ");
		String name = in.next(); 
		// owner name 
		System.out.print("Name of the owner: ");
		String owner = in.next(); 
		// type 
		System.out.print("Is the pet a dog or a cat? : ");
		String type = in.next(); 
		// age 
		System.out.print("Age of the pet: "); 
		int age = Integer.parseInt(in.next());
		
		int uniqueID; 

		// type = cat 
		if (type.equalsIgnoreCase("cat")) { 
			uniqueID = makeCat(petInfo, name, owner, type, age) ;  
		}
		
		// type = dog 
		else { 
			uniqueID = makeDog(petInfo, name, owner, type, age) ;  
		}
		
		// ask the user if the info is correct and if they would like to save 
		System.out.print("\n(Yes/No) Would you like to save "
				+ "this pet to the file? : "); 
		String save = in.next(); 
		
		// user wants to save 
		if (save.equalsIgnoreCase("yes")) { 
			writeFile(petInfo, "pets.txt"); 
			System.out.print("Your pet has been saved.\n"); 
		}
		// user doesn't want to save 
		else { 
			petInfo.remove(petInfo.get(uniqueID)); 
		}
		
		return; 
		
	} // end add method 

	
	
	/**
	 * Function: to find out what action the user wants to do 
	 * 
	 * @param petInfo, the LinkedList of pet objects 
	 */
	public static void findFunction (LinkedList<Pets> petInfo) {

		// identify the file name 
		String fileName = "pets.txt"; 
		String function = null; 
		
		// exit ends the program when the user chooses exit 
		boolean exit = false;
		while (exit == false) { 
			// set scanner 
			Scanner in = new Scanner (System.in);
			// ask the user for function 
			System.out.println("\nWhat function would to like to perform? "); 
			function = in.nextLine();
		
			// view
			if (function.equalsIgnoreCase("view")) { 
				view(petInfo); 
			}
			// delete
			if (function.equalsIgnoreCase("delete")) {
				delete(petInfo);
			}
			// add
			if (function.equalsIgnoreCase("add")) {
				add(petInfo); 
			}
			// save
			if (function.equalsIgnoreCase("save")) {
				writeFile(petInfo, fileName); 
			}
			// exit 
			if (function.equalsIgnoreCase("exit")) { 
				exit = true;
				in.close(); 
			} 
		} // end while loop 
		
	} // end findFunction method 
	
	
	/**
	 * Main method - starting point of the program 
	 * 
	 * @param args 
	 */
	public static void main (String [] args) {
		
		// identify the input file 
		String inputFile = "Pets.txt";
		// create the array list 
		LinkedList<Pets> petInfo = new LinkedList<Pets>(); 
		
		// print out the functions available to the user 
		System.out.println("Please note, you must type in the "
				+ "functions as shown below.\n"
				+ "The functions available to you are: \n"
				+ "View, delete, add, save, and exit\n"); 
 
		// assign the LinkedList 
		// call readFile to assign into LinkedList 
		petInfo = readFile(inputFile); 
	
		// find the function that the user would like to perform 
		findFunction(petInfo); 
		 
		// program ends when the user chooses to exit 
		// confirm the choice to the user once exit is chosen 
		System.out.println("\nProgram is closing.");

	} // end main method 
	
} // end program 
