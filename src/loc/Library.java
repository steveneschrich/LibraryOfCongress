package loc;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * Create a Library class that contains an ArrayList of  books.  
 * Include a method SearchBySubject that takes as parameter a subject string.  
 * For each book in the library that lists the subject string as one of
 *  its headings, SearchBySubject should display the title, the name of the 
 *  author, and the Library of Congress catalog number of the book.
 * @author eschris
 *
 */


public class Library implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4116014297567751541L;
	private ArrayList<Book> books=null;

	
	public Library() {
		books=new ArrayList<Book>();
	}
	
	public void addBook(Book b) throws DuplicateBookException {
//		if ( books.contains(b)) {
//			throw new DuplicateBookException();
//		}
		books.add(b);
	}
	/**
	 * SearchBySubject will search the library for books of a given
	 * subject, then print out book information for each found book.
	 * @param subject - The subject to search for.
	 * 
	 * This is a required method, as given by the following description:
	 * Include a method SearchBySubject that takes as parameter a subject string.  
	 * For each book in the library that lists the subject string as one of
	 *  its headings, SearchBySubject should display the title, the name of the 
	 *  author, and the Library of Congress catalog number of the book.
	 */
	public void SearchBySubject(String subject) {
		ArrayList<Book> matchedBooks=matchSubjects(subject);
		for (int i=0; i < matchedBooks.size(); i++) {
			Book b=matchedBooks.get(i);
			System.out.println(b.getTitle()+"\t"+b.formattedAuthorList()+"\t"+b.getCatalogNumber());
		}
	}
	public int numBooks() {
		return books.size();
	}
	public String toString() {
		StringBuffer sb=new StringBuffer();
		for (int i=0; i < books.size(); i++) {
			Book b=books.get(i);
			sb.append(b.toString());
		}
		return(sb.toString());
	}
	/**
	 * matchSubjects will match the given subject parameter to all books in the 
	 * library, returning a list of books that match this subject.
	 * @param subject The target subject to match
	 * @return An arraylist of books that match the given subject
	 */
	public ArrayList<Book> matchSubjects(String subject) {
		ArrayList<Book> matchedBooks=new ArrayList<Book>();
		
		for (int i=0; i < books.size(); i++) {
			Book b=books.get(i);
			if (b.matchSubject(subject)) {
				matchedBooks.add(b);
			}
		}
		return(matchedBooks);
	}
	
	public Book getBook(int index) {
		return(books.get(index));
	}
	public void saveLibrary(String filename) throws java.io.IOException {
		FileOutputStream fileOut =
				new FileOutputStream(filename);
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(this);
	    out.close();
	    fileOut.close();
	}
	
	public static Library loadLibrary(String filename) throws java.io.IOException, ClassNotFoundException  {
		FileInputStream fileIn = new FileInputStream(filename);
	    ObjectInputStream in = new ObjectInputStream(fileIn);
	    Library l=(Library) in.readObject();
	    in.close();
	    fileIn.close();
	    
	    return(l);
	         
	}
	
	public static void main(String []args) {
//		Library l=new Library();
//		System.out.println(l.toString());
//		Book b=new Book();
//		b.addAuthor("Steven", "Eschrich");
//		b.setTitle("An intersting book");
//		b.setCatalogNumber(123);
//		b.setInCirculation(false);
//		b.setYearOfPublication(2005);
//		b.addSubject("Boring");
//		b.addSubject("Nature");
//		b.addSubject("Sleep");
//		try {
//			l.addBook(b);
//		} catch (Exception e) {
//			
//		}
//		System.out.println(l.toString());
//		try {
//		l.saveLibrary("foo.txt");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Library l=new Library();
		System.out.println(l.numBooks());
//		try {
//		 l=Library.loadLibrary("foo.txt");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(l.toString());
	}
	
}
