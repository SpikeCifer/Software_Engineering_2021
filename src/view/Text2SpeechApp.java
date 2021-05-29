package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import commands.PlayRecordingCmd;
import commands.StartRecordingCommand;
import commands.StopRecordingCmd;
import commands.TransformContentsCmd;

import javax.swing.JButton;

public class Text2SpeechApp {

	private JFrame frame;
	private  final JButton btnOpenDocument = new JButton("Open Document");
	private  final JButton btnEditDocument = new JButton("Edit Document");
	private  final JButton btnSaveDocument = new JButton("Save Document");
	
	private final JButton btnTransformContents = new JButton("Transform Contents");
	private final JButton btnTransformSpecified = new JButton("Transform Specified Contents");
	private final JButton btnConfigureTransformer = new JButton("Configure Transformer");
	
	private final JButton btnStartRecording = new JButton("Start Recording");
	private final JButton btnPlayRecording = new JButton("Play Recording");
	private final JButton btnStopRecording = new JButton("Stop Recording");
	
	private final int BUTTON_DISTANCE = 25;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Text2SpeechApp window = new Text2SpeechApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Text2SpeechApp() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		createOpenDocButton();
		createEditDocButton();
		createSaveDocButton();
	
		createTransformContentsButton();
		createTransformSpecifiedContentsButton();
		createConfigureTransformerButton();
		
		createStartRecordingButton();
		createPlayRecordingButton();
		createStopRecordingButton();
	}
	
	private void createOpenDocButton() {
		btnOpenDocument.setBounds(133, 0, 155, BUTTON_DISTANCE);
		frame.getContentPane().add(btnOpenDocument);
		
		btnOpenDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpenDocumentDialog();
			}
		});
	}
	
	private void createEditDocButton() {
		btnEditDocument.setBounds(133, 25, 155, BUTTON_DISTANCE);
		frame.getContentPane().add(btnEditDocument);
		
		btnEditDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditDocumentDialog();
			}
		});
	}
	
	private void createSaveDocButton() {
		btnSaveDocument.setBounds(133, 50, 155, BUTTON_DISTANCE);
		frame.getContentPane().add(btnSaveDocument);
		
		btnSaveDocument.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SaveDocumentDialog();
			}
		});
	}
	
	private void createTransformContentsButton() {
		btnTransformContents.setBounds(133, 75, 155, BUTTON_DISTANCE);
		frame.getContentPane().add(btnTransformContents);
		
		btnTransformContents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TransformContentsCmd().execute();
			}
		});
	}
	
	private void createTransformSpecifiedContentsButton() {
		btnTransformSpecified.setBounds(133, 100, 155, BUTTON_DISTANCE);
		frame.getContentPane().add(btnTransformSpecified);
		
		btnTransformSpecified.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	
	private void createConfigureTransformerButton() {
		btnConfigureTransformer.setBounds(133, 125, 155, BUTTON_DISTANCE);
		frame.getContentPane().add(btnConfigureTransformer);
		
		btnConfigureTransformer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OpenDocumentDialog();
			}
		});
	}
	
	private void createStartRecordingButton() {
		btnStartRecording.setBounds(133, 150, 155, BUTTON_DISTANCE);
		frame.getContentPane().add(btnStartRecording);
		
		btnStartRecording.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StartRecordingCommand().execute();
			}
		});
	}
	
	private void createPlayRecordingButton() {
		btnPlayRecording.setBounds(133, 175, 155, BUTTON_DISTANCE);
		frame.getContentPane().add(btnPlayRecording);
		
		btnPlayRecording.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PlayRecordingCmd().execute();
			}
		});
	}
	
	private void createStopRecordingButton() {
		btnStopRecording.setBounds(133, 200, 155, BUTTON_DISTANCE);
		frame.getContentPane().add(btnStopRecording);
		
		btnStopRecording.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StopRecordingCmd().execute();
			}
		});
	}

}
