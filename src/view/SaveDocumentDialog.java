package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class SaveDocumentDialog extends JDialog {
	// TODO: Have not Finished this Menu
	private static final long serialVersionUID = 1365930912993580382L; // Bloody Serial Tralalala
	private final JPanel contentPanel = new JPanel();


	public SaveDocumentDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnSelectFolder = new JButton("Select Folder");
			btnSelectFolder.setBounds(147, 156, 139, 25);
			contentPanel.add(btnSelectFolder);
		}
		{
			JComboBox encryptionOptions = new JComboBox();
			encryptionOptions.setBounds(147, 89, 162, 24);
			contentPanel.add(encryptionOptions);
		}
		{
			JLabel lblFileFormat = new JLabel("File Format:");
			lblFileFormat.setBounds(25, 55, 92, 15);
			contentPanel.add(lblFileFormat);
		}
		{
			JLabel lblEncryption = new JLabel("Encryption:");
			lblEncryption.setBounds(25, 94, 92, 15);
			contentPanel.add(lblEncryption);
		}
		{
			JComboBox fileFormatOptions = new JComboBox();
			fileFormatOptions.setBounds(147, 46, 162, 24);
			contentPanel.add(fileFormatOptions);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		setVisible(true);
	}
}
