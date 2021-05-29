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

public class EditDocumentDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = -5859261970688542130L; // TRALALA THE BLOODY Serial
	
	private final JPanel contentPanel = new JPanel();
	private final JPanel buttonPane = new JPanel(); // OK Cancel Area
	private final ArrayList<String> docContents = Document.getInstance().getContents();
	private JTextArea textArea = new JTextArea();
	
	private JButton okButton;
	private JButton cancelButton;
	
	public EditDocumentDialog() {
		initFrame();
		transformContentsToTextArea();
		makeOkButton();
		makeCancelButton();
		
		setVisible(true);
	}
	
	private void initFrame() {
		setTitle("Edit Document");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}
	
	private void transformContentsToTextArea() {
		for (String line: docContents)
			textArea.append(line + "\n");
		getContentPane().add(textArea);
	}
	
	private void makeOkButton() {
		okButton = new JButton("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		okButton.addActionListener(this);
	}
	
	private void makeCancelButton() {
		JButton cancelButton = new JButton("Cancel");
		buttonPane.add(cancelButton);
		cancelButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton)
			dialogFinalize();
		if (e.getSource() == cancelButton)
			dispose();
	}
	
	private void dialogFinalize() {
		ArrayList<String> newContents = new ArrayList<String>();
		
		for (String line: textArea.getText().split("\n"))
			newContents.add(line);
		
		new EditDocumentCmd(newContents).execute();
		dispose();
	}
}
