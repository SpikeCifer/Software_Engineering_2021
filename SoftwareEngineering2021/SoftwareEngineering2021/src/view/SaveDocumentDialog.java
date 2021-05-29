package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commands.SaveDocumentCmd;

import javax.swing.JComboBox;
import javax.swing.JTextField;

public class SaveDocumentDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = -8162982523484143804L;
	private final JPanel contentPanel = new JPanel();
	private final JPanel buttonPane = new JPanel();
	
	private JComboBox<String> encryptionOptions = new JComboBox<String>();
	private JComboBox<String> formatOptions = new JComboBox<String>();
	
	private final JFileChooser fc = new JFileChooser();
	private JLabel destinationFolder = new JLabel("None");
	
	private JButton btnSelectDocument = new JButton("Select Destination");
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("Cancel");
	private JTextField txtFilename = new JTextField();

	public SaveDocumentDialog() {
		setBounds(100, 100, 450, 379);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		createFilenameField();
		createEncryptionBox();
		createFormatBox();
		makeSelectDestinationButton();
		showDestination();
		
		createCompletionButtons();
		
		setVisible(true);
	}
	
	private void createCompletionButtons() {
		okButton.addActionListener(this);
		cancelButton.addActionListener(this);
		buttonPane.add(okButton);
		buttonPane.add(cancelButton);
	}
			
	private void createFilenameField() {
		txtFilename.setText("Filename");
		txtFilename.setBounds(100, 50, 225, 20);
		contentPanel.add(txtFilename);
		txtFilename.setColumns(10);
	}
	
	private void showDestination() {
		JLabel lblSelectedFile = new JLabel("Destination Folder:");
		lblSelectedFile.setBounds(26, 75, 137, 15);
		contentPanel.add(lblSelectedFile);
		destinationFolder.setBounds(173, 75, 194, 15);
		contentPanel.add(destinationFolder);
	}
	
	private void createEncryptionBox() {
		encryptionOptions.setBounds(200, 125, 150, 25);
		contentPanel.add(encryptionOptions);
		
		JLabel lblEncryption = new JLabel("Encryption:");
		lblEncryption.setBounds(26, 125, 100, 25);
		contentPanel.add(lblEncryption);
		
		encryptionOptions.addItem("None");
		encryptionOptions.addItem("Rot13");
		encryptionOptions.addItem("AtBash");
	}
	
	private void createFormatBox() {
		JLabel lblFormat = new JLabel("File Format:");
		lblFormat.setBounds(25, 175, 150, 25);
		contentPanel.add(lblFormat);
		
		formatOptions.setBounds(200, 175, 150, 25);
		contentPanel.add(formatOptions);
		
		formatOptions.addItem(".docx");
		formatOptions.addItem(".xlsx");
	}
	
	private void makeSelectDestinationButton() {
		btnSelectDocument.setBounds(125, 250, 170, 25);
		contentPanel.add(btnSelectDocument);
		btnSelectDocument.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSelectDocument) {
			selectDocument();
		}
		else if (e.getSource() == okButton) {
			finalizeDialog();
		}
		else if (e.getSource() == cancelButton) {
			dispose();
		}
	}
	
	private void selectDocument() {	
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
			destinationFolder.setText(fc.getSelectedFile().getAbsolutePath());
		}		
	}
	
	private void finalizeDialog() {
		String filename = txtFilename.getText() + (String) formatOptions.getSelectedItem();
		SaveDocumentCmd saveCmd = new SaveDocumentCmd(filename, (String) encryptionOptions.getSelectedItem());
		saveCmd.execute();
		dispose();
	}
}
