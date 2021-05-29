package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import model.Document;
import commands.EditDocumentCmd;

public class EditDocumentDialog extends JDialog {
	private static final long serialVersionUID = -5859261970688542130L; // TRALALA THE BLOODY Serial
	private final JPanel contentPanel = new JPanel();
	private final JPanel buttonPane = new JPanel();
	private final ArrayList<String> docContents = Document.getInstance().getContents();
	private JTextArea textArea = new JTextArea();

	public EditDocumentDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		
		for (String line: docContents)
			textArea.append(line + "\n");
		getContentPane().add(textArea);
		
		
		makeOkButton();
		makeCancelButton();
		
		setVisible(true);
	}
	
	private void makeOkButton() {
		JButton okButton = new JButton("OK");
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> newContents = new ArrayList<String>();
				
				for (String line: textArea.getText().split("\r|\r\n"))
					newContents.add(line);
				
				new EditDocumentCmd(newContents).execute();
				dispose();
			}
		});
	}
	
	private void makeCancelButton() {
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
}
