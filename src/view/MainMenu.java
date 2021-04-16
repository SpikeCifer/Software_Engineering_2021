package view;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MainMenu extends JFrame {
	private static final int BUTTONS_N = 9;

	private JPanel contentPane;	
	
	// Document Buttons
	private JButton btnOpenDoc = new JButton("Open Document");
	private JButton btnEditDoc = new JButton("Edit Document");
	private JButton btnSaveDoc = new JButton("Save Document");
	
	// Transform Buttons
	private JButton btnTransform = new JButton("Transform Full");
	private JButton btnTransformLines = new JButton("Transform Specific Lines");
	private JButton btnConfigure = new JButton("Transform Settings");
	
	// Replay Buttons
	private JButton btnActivateReplay = new JButton("Start Recording");
	private JButton btnReplayRecorded = new JButton("Replay Recorded");
	private JButton btnDeactivateReplay = new JButton("Stop Recorded");
	
	private JButton[] menuButtons = {
			btnOpenDoc, btnEditDoc,btnSaveDoc,
			btnTransform, btnTransformLines, btnConfigure,
			btnActivateReplay, btnReplayRecorded, btnDeactivateReplay
	};
	
	public MainMenu() {
		setTitle("Text 2 Speech Transformer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(BUTTONS_N, 1, 0, 0));
		
		for (int i = 0; i < BUTTONS_N; i++)
			contentPane.add(menuButtons[i]);
	}
	
	

}
