package loc;


import javax.swing.table.DefaultTableModel;

public class LibraryTableModel extends DefaultTableModel {

	private Library bookLibrary=null;
	private String columnNames[]={"Title","Authors","Catalog Num","Subjects","Publisher","Year of Publication","In Circulation"};
	public LibraryTableModel(Library l) {
		this.bookLibrary=l;
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	  
	@Override
	public int getRowCount() {
		if (bookLibrary==null ) {
			return 0;
		}
		return bookLibrary.numBooks();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// The rowIndex refers to the book
		Book b=bookLibrary.getBook(rowIndex);
		// columnIndex refers to the appropriate variable of the book
		switch (columnIndex) {
			case 0:	return(b.getTitle());
			case 1:	return(b.formattedAuthorList());
			case 2:	return(new Integer(b.getCatalogNumber()));
			case 3:	return(b.getSubjects().toString());
			case 4:	return(b.getPublisher());
			case 5:	return(new Integer(b.getYearOfPublication()));
			case 6:	return(new Boolean(b.isInCirculation()));
		}
		return null;
	}

	protected void addBook(Book b) {
		try {
			bookLibrary.addBook(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		fireTableRowsInserted(1, bookLibrary.numBooks());
	}
	
	public void setLibrary(Library l) {
		this.bookLibrary=l;
		fireTableDataChanged();
	}
	public Book getBook(int i) {
		return bookLibrary.getBook(i);
	}
	public Library getLibrary() {
		return this.bookLibrary;
	}
}
