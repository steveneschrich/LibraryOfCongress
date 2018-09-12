package loc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;

import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddBookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtTitle;
	private JTextField txtCatalogNumber;
	private JTextField txtPublisher;
	private JTextField txtPublicationYear;
	private JTextField txtSubjects;
	private JTextField txtAuthors;
	private JCheckBox chckbxInCirculation;
	private MainApp parent=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AddBookDialog dialog = new AddBookDialog(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AddBookDialog(MainApp parent) {
		this.parent=parent;
		setTitle("Add New Book");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblTitle = new JLabel("Book Title");
			GridBagConstraints gbc_lblTitle = new GridBagConstraints();
			gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
			gbc_lblTitle.anchor = GridBagConstraints.EAST;
			gbc_lblTitle.gridx = 1;
			gbc_lblTitle.gridy = 0;
			contentPanel.add(lblTitle, gbc_lblTitle);
		}
		{
			txtTitle = new JTextField();
			GridBagConstraints gbc_txtTitle = new GridBagConstraints();
			gbc_txtTitle.insets = new Insets(0, 0, 5, 0);
			gbc_txtTitle.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtTitle.gridx = 2;
			gbc_txtTitle.gridy = 0;
			contentPanel.add(txtTitle, gbc_txtTitle);
			txtTitle.setColumns(10);
		}
		{
			JLabel lblAuthors = new JLabel("Authors");
			GridBagConstraints gbc_lblAuthors = new GridBagConstraints();
			gbc_lblAuthors.anchor = GridBagConstraints.EAST;
			gbc_lblAuthors.insets = new Insets(0, 0, 5, 5);
			gbc_lblAuthors.gridx = 1;
			gbc_lblAuthors.gridy = 1;
			contentPanel.add(lblAuthors, gbc_lblAuthors);
		}
		{
			txtAuthors = new JTextField();
			txtAuthors.setToolTipText("Use a comma separated list for multiple authors.");
			GridBagConstraints gbc_txtAuthors = new GridBagConstraints();
			gbc_txtAuthors.insets = new Insets(0, 0, 5, 0);
			gbc_txtAuthors.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtAuthors.gridx = 2;
			gbc_txtAuthors.gridy = 1;
			contentPanel.add(txtAuthors, gbc_txtAuthors);
			txtAuthors.setColumns(10);
		}
		{
			JLabel lblCatalogNumber = new JLabel("Catalog Number");
			GridBagConstraints gbc_lblCatalogNumber = new GridBagConstraints();
			gbc_lblCatalogNumber.anchor = GridBagConstraints.EAST;
			gbc_lblCatalogNumber.insets = new Insets(0, 0, 5, 5);
			gbc_lblCatalogNumber.gridx = 1;
			gbc_lblCatalogNumber.gridy = 2;
			contentPanel.add(lblCatalogNumber, gbc_lblCatalogNumber);
		}
		{
			txtCatalogNumber = new JTextField();
			GridBagConstraints gbc_txtCatalogNumber = new GridBagConstraints();
			gbc_txtCatalogNumber.insets = new Insets(0, 0, 5, 0);
			gbc_txtCatalogNumber.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtCatalogNumber.gridx = 2;
			gbc_txtCatalogNumber.gridy = 2;
			contentPanel.add(txtCatalogNumber, gbc_txtCatalogNumber);
			txtCatalogNumber.setColumns(10);
		}
		{
			JLabel lblPublisher = new JLabel("Publisher");
			GridBagConstraints gbc_lblPublisher = new GridBagConstraints();
			gbc_lblPublisher.anchor = GridBagConstraints.EAST;
			gbc_lblPublisher.insets = new Insets(0, 0, 5, 5);
			gbc_lblPublisher.gridx = 1;
			gbc_lblPublisher.gridy = 3;
			contentPanel.add(lblPublisher, gbc_lblPublisher);
		}
		{
			txtPublisher = new JTextField();
			GridBagConstraints gbc_txtPublisher = new GridBagConstraints();
			gbc_txtPublisher.insets = new Insets(0, 0, 5, 0);
			gbc_txtPublisher.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPublisher.gridx = 2;
			gbc_txtPublisher.gridy = 3;
			contentPanel.add(txtPublisher, gbc_txtPublisher);
			txtPublisher.setColumns(10);
		}
		{
			JLabel lblYearOfPublication = new JLabel("Year of Publication");
			GridBagConstraints gbc_lblYearOfPublication = new GridBagConstraints();
			gbc_lblYearOfPublication.insets = new Insets(0, 0, 5, 5);
			gbc_lblYearOfPublication.gridx = 1;
			gbc_lblYearOfPublication.gridy = 4;
			contentPanel.add(lblYearOfPublication, gbc_lblYearOfPublication);
		}
		{
			txtPublicationYear = new JTextField();
			GridBagConstraints gbc_txtPublicationYear = new GridBagConstraints();
			gbc_txtPublicationYear.insets = new Insets(0, 0, 5, 0);
			gbc_txtPublicationYear.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPublicationYear.gridx = 2;
			gbc_txtPublicationYear.gridy = 4;
			contentPanel.add(txtPublicationYear, gbc_txtPublicationYear);
			txtPublicationYear.setColumns(10);
		}
		{
			chckbxInCirculation = new JCheckBox("In Circulation?");
			GridBagConstraints gbc_chckbxInCirculation = new GridBagConstraints();
			gbc_chckbxInCirculation.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxInCirculation.gridx = 1;
			gbc_chckbxInCirculation.gridy = 5;
			contentPanel.add(chckbxInCirculation, gbc_chckbxInCirculation);
		}
		{
			JLabel lblSubjects = new JLabel("Subject");
			lblSubjects.setToolTipText("Include multiple subjects as comma separated names");
			GridBagConstraints gbc_lblSubjects = new GridBagConstraints();
			gbc_lblSubjects.anchor = GridBagConstraints.EAST;
			gbc_lblSubjects.insets = new Insets(0, 0, 0, 5);
			gbc_lblSubjects.gridx = 1;
			gbc_lblSubjects.gridy = 6;
			contentPanel.add(lblSubjects, gbc_lblSubjects);
		}
		{
			txtSubjects = new JTextField();
			txtSubjects.setToolTipText("Include multiple subjects as comma separated names");
			GridBagConstraints gbc_txtSubjects = new GridBagConstraints();
			gbc_txtSubjects.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtSubjects.gridx = 2;
			gbc_txtSubjects.gridy = 6;
			contentPanel.add(txtSubjects, gbc_txtSubjects);
			txtSubjects.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addAction();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelAction();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void cancelAction() {
		this.dispose();
	}
	private void addAction() {
		Book b=new Book();
		b.setTitle(txtTitle.getText());
		b.setCatalogNumber(Integer.parseInt(txtCatalogNumber.getText()));
		b.setInCirculation(chckbxInCirculation.isSelected());
		b.setPublisher(txtPublisher.getText());
		b.setYearOfPublication(Integer.parseInt(txtPublicationYear.getText()));
		String[] subjects=txtSubjects.getText().split(",");
		for (int i=0; i < subjects.length; i++) {
			b.addSubject(subjects[i].trim());
		}
		String[] authors=txtAuthors.getText().split(",");
		for (int i=0; i < authors.length; i++) {
			Author a=new Author();
			a.setName(authors[i].trim());
			b.addAuthor(a);
		}
		parent.addBook(b);
		
		this.dispose();
		
	}
}
