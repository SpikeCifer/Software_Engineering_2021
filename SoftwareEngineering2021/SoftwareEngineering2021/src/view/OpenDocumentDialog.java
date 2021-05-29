package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import commands.OpenDocumentCmd;

// import commands.OpenDocumentCmd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class OpenDocumentDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 5028144672411348559L; // Eclipse was complaining, so we added it randomly
	private final JFileChooser fc = new JFileChooser();
	private JLabel selectedFileName = new JLabel("None");
	private JComboBox<String> encryptionOptions = new JComboBox<String>();
	private String filename;
	
	private JButton btnCancel = new JButton("Cancel");
	private JButton btnSelectDocument = new JButton("Select Document");
	private JButton btnOk = new JButton("OK");
			

	public OpenDocumentDialog() {
		setTitle("Open Document Window");
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(null);
		
		makeOkButton();
		makeCancelButton();
		makeSelectDocumentButton();
		
		createEncryptionSelectionBox();
		setFileFilters();
		showSelectedFile();
		setVisible(true);
	}
	
	private void makeOkButton() {
		btnOk.setBounds(54, 167, 117, 25);
		getContentPane().add(btnOk);
		btnOk.addActionListener(this);
	}
	
	private void makeCancelButton() {
		btnCancel.setBounds(244, 167, 117, 25);
		getContentPane().add(btnCancel);
		btnCancel.addActionListener(this);
	}
	
	private void makeSelectDocumentButton() {
		btnSelectDocument.setBounds(125, 115, 170, 25);
		getContentPane().add(btnSelectDocument);
		btnSelectDocument.addActionListener(this);
	}
	
	private void showSelectedFile() {
		JLabel lblSelectedFile = new JLabel("Selected File:");
		lblSelectedFile.setBounds(25, 24, 137, 15);
		getContentPane().add(lblSelectedFile);
		selectedFileName.setBounds(174, 24, 194, 15);
		getContentPane().add(selectedFileName);
	}
	
	private void createEncryptionSelectionBox() {
		encryptionOptions.setBounds(174, 65, 173, 24);
		getContentPane().add(encryptionOptions);
		
		JLabel lblEncryption = new JLabel("Encryption:");
		lblEncryption.setBounds(25, 70, 106, 15);
		getContentPane().add(lblEncryption);
		
		encryptionOptions.addItem("None");
		encryptionOptions.addItem("Rot13");
		encryptionOptions.addItem("AtBash");
	}
	
	private void setFileFilters() {
		fc.addChoosableFileFilter(new FileNameExtensionFilter("*.docx", "docx"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("*.xlsx", "xlsx"));
		fc.setAcceptAllFileFilterUsed(false); // Only choose between the above 2 formats
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelectDocument) {
			selectDocument();
		}
		else if (e.getSource() == btnOk) {
			completeDialog();
			dispose();
		}
		else if (e.getSource() == btnCancel) {
			dispose();
		}
	}
	
	private void selectDocument() {		
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			filename = fc.getSelectedFile().getAbsolutePath();
			selectedFileName.setText(filename);
		}		
	}
	
	private void completeDialog() {
		OpenDocumentCmd openCmd = new OpenDocumentCmd(filename, 
				(String) encryptionOptions.getSelectedItem());
		openCmd.execute();
	}
}
