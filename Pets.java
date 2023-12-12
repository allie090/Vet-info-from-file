/**
 * Class Name: Pets 
 * @author: Allie Marcum 
 * @version: 2.0
 * Course: CSE 274
 * Date: September 22, 2023
 * 
 * Function: Construct the pet attributes
 */

public class Pets {

	// common attributes 
	protected int uniqueID; // identification of the pet 
	protected String petName; // name of the pet 
	protected String ownerName; // name of the owner 
	protected String type; // cat or dog 
	
	/**
	 * Default constructor - everything set to null 
	 */
	public Pets () { 
		// everything is null automatically
		// necessary for the creation without attributes 
	}
	
	/**
	 * Constructor 
	 * 
	 * @param uniqueID, the number ID of the pet 
	 * @param petName, the name of the pet 
	 * @param ownerName, the name of the owner 
	 * @param type, is the pet a cat or dog 
	 */
	public Pets(int uniqueID, String petName, String ownerName, 
			String type) { 
	
		super(); 
		this.uniqueID = uniqueID; 
		this.petName = petName; 
		this.ownerName = ownerName; 
		this.type = type; 
		
	}

	/**
	 * Method to allow the reading of the pet's uniqueID 
	 * 
	 * @return the number identification of the pet 
	 */
	public int getUniqueID() {
		return uniqueID;
	}

	/**
	 * Method to allow setting of the uniqueID 
	 * 
	 * @param uniqueID
	 */
	public void setUniqueID(int uniqueID) {
		this.uniqueID = uniqueID;
	}

	/**
	 * Method to allow the reading of petName 
	 * 
	 * @return the name of the pet 
	 */
	public String getPetName() {
		return petName;
	}

	/**
	 * Method to allow setting of the petName 
	 * 
	 * @param petName, the name of the pet 
	 */
	public void setPetName(String petName) {
		this.petName = petName;
	}

	/**
	 * Method to allow reading of ownerName 
	 * 
	 * @return the name of the owner 
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Method to allow setting of the ownerName 
	 * 
	 * @param ownerName, the name of the owner 
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * Method to allow reading of the type 
	 * 
	 * @return the type of animal (cat or dog) 
	 */
	public String getType() {
		return type;
	}

	/**
	 * Method to allow setting of the type 
	 * 
	 * @param type, if the pet is a cat or a dog 
	 */
	public void setType(String type) {
		this.type = type;
	}
}
