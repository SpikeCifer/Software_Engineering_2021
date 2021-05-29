package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/* These imports could be hidden with a factory
 * pattern but the parameters are different each 
 * time so we considered this as impossible
 */
import commands.PlayRecordingCmd;
import commands.StartRecordingCommand;
import commands.StopRecordingCmd;
import commands.TransformContentsCmd;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Text2SpeechApp implements ActionListener{

	private static final int BUTTON_HEIGHT = 25;
	private static final int HEIGHT_OFFSET = 50;
	private static final int WIDTH_OFFSET = 65;
	private static final int BUTTON_WIDTH = 200;
	
	private  final JButton btnOpenDocument = new JButton("Open Document");
	private  final JButton btnEditDocument = new JButton("Edit Document");
	private  final JButton btnSaveDocument = new JButton("Save Document");
	
	private final JButton btnTransformContents = new JButton("Transform Contents");
	private final JButton btnTransformSpecified = new JButton("Transform Specific Lines");
	private final JButton btnConfigureTransformer = new JButton("Configure Transformer");
	
	private final JButton btnStartRecording = new JButton("Start Recording");
	private final JButton btnPlayRecording = new JButton("Play Recording");
	private final JButton btnStopRecording = new JButton("Stop Recording");
	
	private final JButton[] buttonsMenu = {
			btnOpenDocument, btnEditDocument, btnSaveDocument,
			btnTransformContents, btnTransformSpecified, btnConfigureTransformer,
			btnStartRecording, btnPlayRecording, btnStopRecording};
	
	JLabel lblRecorderActivity = new JLabel("Inactive");
	
	private JFrame frmTextspeechapp;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Text2SpeechApp window = new Text2SpeechApp();
					window.frmTextspeechapp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Text2SpeechApp() {
		frmTextspeechapp = new JFrame();
		frmTextspeechapp.setTitle("Text2SpeechApp");
		frmTextspeechapp.setBounds(200, 100, 314, 326);
		frmTextspeechapp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTextspeechapp.getContentPane().setLayout(null);
		
		makeStatusLabels();
		
		for (int i = 0; i < buttonsMenu.length; i++)
			createButton(i);
	}
	
	private void makeStatusLabels() {
		JLabel lblRecorderStatus = new JLabel("Recorder Status");
		lblRecorderStatus.setBounds(12, 12, 122, 15);
		frmTextspeechapp.getContentPane().add(lblRecorderStatus);
		
		lblRecorderActivity.setBounds(198, 12, 70, 15);
		frmTextspeechapp.getContentPane().add(lblRecorderActivity);
		lblRecorderActivity.setForeground(Color.RED);
	}
	
	private void createButton(int buttonIndex) {
		JButton currentButton = buttonsMenu[buttonIndex];
		currentButton.setBounds(
				WIDTH_OFFSET, HEIGHT_OFFSET + buttonIndex*BUTTON_HEIGHT, 
				BUTTON_WIDTH, BUTTON_HEIGHT);
		frmTextspeechapp.getContentPane().add(currentButton);
		currentButton.addActionListener(this);
	}
	
	/*
	 * This function could be even prettier with a dictionary Button -> Function 
	 * but we lack the knowledge of creating that
	 */
	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == btnOpenDocument)
			new OpenDocumentDialog();
		
		else if (evt.getSource() == btnEditDocument)
			new EditDocumentDialog();
		
		else if (evt.getSource() == btnSaveDocument)
			new SaveDocumentDialog();
		
		else if (evt.getSource() == btnTransformContents)
			new TransformContentsCmd().execute();
		
		else if (evt.getSource() == btnTransformSpecified)
			new SpecifyTransformContentDialog();
		
		else if (evt.getSource() == btnConfigureTransformer)
			new ConfigTransformerDialog();
		
		else if (evt.getSource() == btnStartRecording) {
			new StartRecordingCommand().execute();
			updateStatus("Active");
		}
			
		else if (evt.getSource() == btnPlayRecording)
			new PlayRecordingCmd().execute();
		
		else if (evt.getSource() == btnStopRecording) {
			new StopRecordingCmd().execute();
			updateStatus("Inactive");
		}	
	}
	
	private void updateStatus(String status) {
		lblRecorderActivity.setText(status);
		
		if (status.equals("Active"))
			lblRecorderActivity.setForeground(Color.GREEN.darker());
		else
			lblRecorderActivity.setForeground(Color.RED);
	}
}
