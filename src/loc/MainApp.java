package loc;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.RowFilter;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableRowSorter;

import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.GridLayout;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JInternalFrame;
import javax.swing.JTable;

public class MainApp {

	private JFrame frmLibrary;
	private JTable libraryTable;
	private MainApp mainapp=null;
	private LibraryTableModel libraryTableModel=null;
	private boolean dataSaved=true;
	
	private TableRowSorter<LibraryTableModel> libraryTableSorter;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.mainapp=window;
					window.frmLibrary.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibrary = new JFrame();
		frmLibrary.setTitle("Library Application v1.0");
		frmLibrary.setBounds(100, 100, 450, 300);
		frmLibrary.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmLibrary.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, 0));
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openLibrary();
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0));
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveLibrary();
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, 0));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( !dataSaved) {
					saveLibrary();
				}
				frmLibrary.dispose();
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnAdd = new JMenu("Add");
		menuBar.add(mnAdd);
		JMenuItem mntmAddBook = new JMenuItem("Book");
		mntmAddBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, 0));
		mntmAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookDialog d=new AddBookDialog(mainapp);
				d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				d.setVisible(true);
			}
		});
		mnAdd.add(mntmAddBook);
		
		JMenu mnSearch = new JMenu("Search");
		menuBar.add(mnSearch);
		JMenuItem mntmSearchSubject = new JMenuItem("Subject");
		mntmSearchSubject.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, 0));
		mntmSearchSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = (String)JOptionPane.showInputDialog(
				                    frmLibrary,
				                    "Enter subject to search for",
				                    JOptionPane.PLAIN_MESSAGE);
				setLibraryFilter(s); 				                  
			}
		});
		mnSearch.add(mntmSearchSubject);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		
		
		JInternalFrame libraryFrame = new JInternalFrame("Library");
		frmLibrary.getContentPane().add(libraryFrame, BorderLayout.CENTER);
	
		
		libraryTableModel=new LibraryTableModel(new Library());
		
		
		libraryTable = new JTable(libraryTableModel);
		libraryTableSorter = new TableRowSorter<LibraryTableModel>(libraryTableModel);
		libraryTable.setRowSorter(libraryTableSorter);
		JScrollPane libraryScrollPane = new JScrollPane(libraryTable);
		libraryTable.setFillsViewportHeight(true);
		libraryFrame.getContentPane().add(libraryScrollPane, BorderLayout.CENTER);
		libraryFrame.setVisible(true);
		
		
		
		JPanel statusPanel = new JPanel();
		frmLibrary.getContentPane().add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		StatusLabel lblRecordnumber = new StatusLabel("recordNumber");
		lblRecordnumber.setText("0 books available.");
		libraryTableModel.addTableModelListener(libraryTable);
		libraryTableModel.addTableModelListener(lblRecordnumber);
		statusPanel.add(lblRecordnumber);
		
	}
	private class StatusLabel extends JLabel implements TableModelListener {
		public StatusLabel(String s){
			super(s);
		}
		@Override
		public void tableChanged(TableModelEvent e) {
			this.setText(libraryTableModel.getLibrary().numBooks()+" books available.");
		}
		
	}
	private void openLibrary() {
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Stored Database (*.res)", "res");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(frmLibrary);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	try {
	    		Library bookLibrary=Library.loadLibrary(chooser.getSelectedFile().getPath());
	    		libraryTableModel.setLibrary(bookLibrary);
	    	} catch (java.io.IOException err) {
	    		JOptionPane.showMessageDialog(frmLibrary, "Could not load library: "+chooser.getSelectedFile().getPath());
	    	} catch (ClassNotFoundException err) {
	    		JOptionPane.showMessageDialog(frmLibrary, "Error loading library into objects.");
	    	}
	    }
	
	}
	private void saveLibrary() {
		JFileChooser chooser=new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Stored Database (*.res)", "res");
		    chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(frmLibrary);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	try {
	    		libraryTableModel.getLibrary().saveLibrary(chooser.getSelectedFile().getPath());
	    		dataSaved=true;
	    	} catch (java.io.IOException err) {
	    		JOptionPane.showMessageDialog(frmLibrary, "Could not save library: "+chooser.getSelectedFile().getPath());
	    	}
	    }
	}
	
	public void addBook(Book b) {
		libraryTableModel.addBook(b);
		dataSaved=false;
	}
	
	public void setLibraryFilter(String s) {
		 RowFilter<LibraryTableModel,Integer> subjectFilter = new RowFilter<LibraryTableModel,Integer>() {
			   public boolean include(Entry<? extends LibraryTableModel, ? extends Integer> entry) {
			     LibraryTableModel libraryTableModel = entry.getModel();
			     Book b = libraryTableModel.getBook(entry.getIdentifier());
			     if (b.matchSubject(s)) {
			       // Returning true indicates this row should be shown.
			       return true;
			     }
			     // Age is <= 20, don't show it.
			     return false;
			   }
			 };
		
		libraryTableSorter.setRowFilter(subjectFilter);
		
	}
	
}
