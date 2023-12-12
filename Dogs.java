/**
 * Class Name: Dogs 
 * @author: Allie Marcum 
 * @version: 2.0
 * Course: CSE 274
 * Date: September 22, 2023
 * 
 * Function: construct the attributes specific to dogs 
 * is the child class of Pets
 */
public class Dogs extends Pets {
	
	// unique attribute to Dogs 
	String breed; // breed of the dog 
	int age; // how old the dog is 
	
	/**
	 * Constructor 
	 * 
	 * @param uniqueID, the number ID of the pet 
	 * @param petName, the name of the pet 
	 * @param ownerName, the name of the owner 
	 * @param type, is the pet a cat or dog 
	 * @param age, the age of the pet 
	 * @param breed, the breed specific to dogs 
	 */
	public Dogs (int uniqueID, String petName, String ownerName,
			String type, int age, String breed) { 
		super(uniqueID, petName, ownerName, type); 
		this.breed = breed; 
		this.age = age; 
	}
	
	/**
	 * default constructor 
	 * 
	 */
	public Dogs () { 
		// default constructor - sets values to null
	}

	/**
	 * Method to get breed 
	 * 
	 * @return the breed of the dog 
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * Method to set breed 
	 * 
	 * @param breed, the breed of the dog 
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	/**
	 * Method to get age
	 * 
	 * @return the age of the pet 
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Method to set age
	 * 
	 * @param age, the age of the pet 
	 */
	public void setAge(int age) {
		this.age = age;
	}
	

}
