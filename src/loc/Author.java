package loc;

import java.io.Serializable;

public class Author implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4513247824309916606L;
	private String firstName=null;
	private String lastName=null;
	private String middleName=null;
	
	public Author() {
		
		
	}
	// TODO: Split name into first, last, etc.
	public Author(String name) {
		
	}
	public Author(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public Author(String firstName, String middleName, String lastName) {
		this.firstName=firstName;
		this.middleName=middleName;
		this.lastName=lastName;
	}
	
	public String toString() {
		StringBuffer b=new StringBuffer();
		
		b.append(lastName);
		b.append(" ");
		b.append(firstName);
		b.append(" ");
		b.append(middleName);
		
		return(b.toString());
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public void setName(String name) {
		String []nameParts=name.split(" ");
		this.setFirstName(nameParts[0]);
		if (nameParts.length==2) {
			this.setLastName(nameParts[1]);
		} 
		if ( nameParts.length==3) {
			this.setMiddleName(nameParts[1]);
			this.setLastName(nameParts[2]);
		}
		
	}
}

