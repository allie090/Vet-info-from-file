/**
 * Class Name: Cats 
 * @author: Allie Marcum 
 * @version: 2.0
 * Course: CSE 274
 * Date: September 22, 2023
 * 
 * Function: to construct the attributes specific to Cats 
 * child class of pets 
 */
public class Cats extends Pets{

		// unique attribute to Cats 
		boolean longFur; // true if cat has long fur 
		int age; // age of the cat 
		
		/**
		 * Constructor 
		 * 
		 * @param uniqueID, the number ID of the pet 
		 * @param petName, the name of the pet 
		 * @param ownerName, the name of the owner 
		 * @param type, is the pet a cat or dog 
		 * @param age, the age of the pet 
		 * @param longFur, true if the cat has long fur  
		 */
		public Cats (int uniqueID, String petName, String ownerName,
				String type, int age, boolean longFur) { 
			super(uniqueID, petName, ownerName, type); 
			this.longFur = longFur; 
			this.age = age; 
		}
		
		/**
		 * default constructor 
		 * 
		 */
		public Cats () { 
			// default constructor - sets values to null
		}

		/**
		 * Method to get longFur 
		 * 
		 * @return true if the cat has long fur  
		 */
		public boolean getLongFur () {
			return longFur;
		}

		/**
		 * Method to set longFur
		 * 
		 * @param longFur, true if the cat is a long fur breed  
		 */
		public void setLongFur (boolean longFur) {
			this.longFur = longFur;
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
