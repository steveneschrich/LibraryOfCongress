package loc;

import java.util.ArrayList;
import java.io.Serializable;
/**
 *  The title
 * 	A list of authors
 *	The Library of Congress catalog number
 * 	A list of subject headings
 *	The publisher
 *	The year of publication
 *	Whether the book is circulating or non-circulating
*/
public class Book implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7914459263650509009L;
	private String title=null;
	private ArrayList<Author> authors=null;
	private int catalogNumber=-1;
	private ArrayList<String> subjects=null;
	private String publisher=null;
	private int yearOfPublication=0;
	private boolean inCirculation=false;
	
	public Book() {
		authors=new ArrayList<Author>();
		subjects=new ArrayList<String>();
	}
	
	public boolean equals(Book b) {
		boolean isEqual=false;
		
		if ( b.getTitle().equals(this.title) && b.getCatalogNumber()==this.catalogNumber &&
				b.getYearOfPublication()==this.yearOfPublication) {
			isEqual=true;
		}
		return isEqual;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Author> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<Author> authors) {
		this.authors = authors;
	}
	public void addAuthor(String firstName, String lastName) {
		this.addAuthor(firstName,null,lastName);
	}
	public void addAuthor(String firstName, String middleName, String lastName){
		Author a=new Author();
		a.setFirstName(firstName);
		a.setMiddleName(middleName);
		a.setLastName(lastName);
		authors.add(a);
	}
	public void addAuthor(Author a) {
		authors.add(a);
	}
	public void addSubject(String subject) {
		subjects.add(subject);
	}
	public int getCatalogNumber() {
		return catalogNumber;
	}
	public void setCatalogNumber(int catalogNumber) {
		this.catalogNumber = catalogNumber;
	}
	public ArrayList<String> getSubjects() {
		return subjects;
	}
	public void setSubjects(ArrayList<String> subjects) {
		this.subjects = subjects;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYearOfPublication() {
		return yearOfPublication;
	}
	public void setYearOfPublication(int yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
	public boolean isInCirculation() {
		return inCirculation;
	}
	public void setInCirculation(boolean inCirculation) {
		this.inCirculation = inCirculation;
	}
	
	/**
	 * Determine if the given subject is one of the subjects of the book.
	 * @param subject - String representing the subject
	 * @return True/False whether or not book contains the subject
	 */
	public boolean matchSubject(String subject) {
		return(subjects.contains(subject));
	}
	
	/**
	 * The authors can be returned as a formatted string with all authors present.
	 * @return
	 */
	public String formattedAuthorList() {
		
		StringBuffer b=new StringBuffer();
		
		for (int i=0; i < authors.size(); i++ ) {
			b.append(authors.get(i).toString());
			if ( i < authors.size()-1 ) {
				b.append(",");
			}
		}
		return b.toString();
	}
	
	public String toString() {
		StringBuffer b=new StringBuffer();
		
		b.append(getTitle());
		b.append(" ");
		b.append(formattedAuthorList());
		b.append(" ");
		b.append(getCatalogNumber());
		b.append(" ");
		b.append(getSubjects().toString());
		b.append(" ");
		b.append(getPublisher());
		b.append(" ");
		b.append(getYearOfPublication());
		b.append(" ");
		b.append(isInCirculation());
		
		return(b.toString());
		
	}
	
}
