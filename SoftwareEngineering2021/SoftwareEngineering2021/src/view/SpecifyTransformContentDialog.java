package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import commands.TransformSpecifiedTextCmd;
import model.Document;

import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;

public class SpecifyTransformContentDialog extends JDialog implements ActionListener{
	private static final long serialVersionUID = 7875541939315316601L;
	private ArrayList<String> docContents = Document.getInstance().getContents();
	
	private final SpinnerModel startLineModel = new SpinnerNumberModel(0, 0, docContents.size(), 1);
	private final SpinnerModel endLineModel = new SpinnerNumberModel(0, 0, docContents.size(), 1);
	private final JSpinner startLineSpinner = new JSpinner(startLineModel);
	private final JSpinner lastLineSpinner = new JSpinner(endLineModel);
	
	private final JPanel contentPanel = new JPanel();
	private final JTextArea textArea = new JTextArea();

	private JButton btnShowDocument = new JButton("ShowDocument");
	private JButton cancelButton = new JButton("Cancel");
	private JButton okButton = new JButton("OK");
	
	private JFrame documentFrame = new JFrame();

	public SpecifyTransformContentDialog() {		
		setBounds(100, 100, 357, 245);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		createDocFrame();
		
		selectStartingLine();	
		selectLastLine();
		createshowDocumentBtn();
		
		createFinalizeButtons();
		setVisible(true);
	}
	
	private void createDocFrame() {
		documentFrame.setBounds(100, 100, 450, 300);
		for (String line: docContents)
			textArea.append(line + "\n");
		documentFrame.getContentPane().add(textArea);
	}
	
	private void selectStartingLine() {
		JLabel lblStartLine = new JLabel("First Line");
		lblStartLine.setBounds(50, 50, 70, 15);
		contentPanel.add(lblStartLine);
		
		startLineSpinner.setBounds(225, 50, 100, 20);
		contentPanel.add(startLineSpinner);
	}
	
	private void selectLastLine() {
		JLabel lblLastLine = new JLabel("Last Line");
		lblLastLine.setBounds(50, 100, 70, 15);
		contentPanel.add(lblLastLine);
		
		lastLineSpinner.setBounds(226, 99, 100, 20);
		contentPanel.add(lastLineSpinner);
	}
	
	private void createshowDocumentBtn() {
		btnShowDocument.setBounds(12, 150, 333, 25);
		contentPanel.add(btnShowDocument);
		btnShowDocument.addActionListener(this);
	}
	
	private void createFinalizeButtons() {
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		okButton.addActionListener(this);
		
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		cancelButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton)
			finalizeDialog();
		else if (e.getSource() == cancelButton)
			dispose();
		else if (e.getSource() == btnShowDocument)
			showDocument();
	}
	
	private void finalizeDialog() {
		new TransformSpecifiedTextCmd((Integer) startLineSpinner.getValue(), 
				(Integer) lastLineSpinner.getValue()).execute();
		dispose();
	}
	
	private void showDocument() {
		documentFrame.setVisible(true);
	}
}
