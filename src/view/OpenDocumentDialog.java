package view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import commands.OpenDocumentCmd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class OpenDocumentDialog extends JDialog {

	private static final long serialVersionUID = 5028144672411348559L; // We have literally no idea what this is for, but eclipse was nagging
	private final JFileChooser fc = new JFileChooser();
	private JLabel selectedFileName = new JLabel("None");
	private JComboBox<String> comboBox = new JComboBox<String>();
	private String filename;

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
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(54, 167, 117, 25);
		getContentPane().add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenDocumentCmd openCmd = new OpenDocumentCmd(filename, (String) comboBox.getSelectedItem());
				openCmd.execute();
				dispose();
			}
		});
	}
	
	private void makeCancelButton() {
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(244, 167, 117, 25);
		getContentPane().add(btnCancel);
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}
	
	private void makeSelectDocumentButton() {
		JButton btnSelectDocument = new JButton("Select Document");
		btnSelectDocument.setBounds(111, 111, 170, 25);
		getContentPane().add(btnSelectDocument);
		
		btnSelectDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectDocument();
			}
		});
	}
	
	private void showSelectedFile() {
		JLabel lblSelectedFile = new JLabel("Selected File:");
		lblSelectedFile.setBounds(25, 24, 137, 15);
		getContentPane().add(lblSelectedFile);
		selectedFileName.setBounds(174, 24, 194, 15);
		getContentPane().add(selectedFileName);
	}
	
	private void createEncryptionSelectionBox() {
		comboBox.setBounds(193, 65, 154, 24);
		getContentPane().add(comboBox);
		
		JLabel lblEncryption = new JLabel("Encryption:");
		lblEncryption.setBounds(25, 70, 106, 15);
		getContentPane().add(lblEncryption);
		
		comboBox.addItem("None");
		comboBox.addItem("Rot13");
		comboBox.addItem("AtBash");
	}
	
	private void setFileFilters() {
		fc.addChoosableFileFilter(new FileNameExtensionFilter("*.docx", "docx"));
		fc.addChoosableFileFilter(new FileNameExtensionFilter("*.xlsx", "xlsx"));
		fc.setAcceptAllFileFilterUsed(false);
	}
	
	private void selectDocument() {		
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			filename = fc.getSelectedFile().getAbsolutePath();
			selectedFileName.setText(filename);
		}		
	}
}
