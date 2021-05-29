package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import commands.ConfigureTransformerCmd;

import javax.swing.JSlider;
import javax.swing.JLabel;

public class ConfigTransformerDialog extends JDialog implements ActionListener{

	private static final long serialVersionUID = -613671206954902787L; // Random Serial Once Again
	private final JPanel contentPanel = new JPanel();
	private ChangeListener listener;
	
	private JLabel volumeValue = new JLabel("0");
	private JSlider volumeSlider = new JSlider();
	
	private JLabel pitchValue = new JLabel("0");
	private JSlider pitchSlider = new JSlider();
	
	private JSlider rateSlider = new JSlider();
	private JLabel rateValue = new JLabel("0");
	
	private JButton okButton = new JButton("OK");
	private JButton cancelButton = new JButton("Cancel");
	
	
	public ConfigTransformerDialog() {
		setTitle("Configure Transformer");
		setBounds(100, 100, 476, 242);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		makeSliders();
			
		createFinalizeButtons();
		
	
		setVisible(true);
	}
	
	private void makeSliders() {
		listener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				JSlider source = (JSlider) event.getSource();
				float newValue = source.getValue();
				if (source == volumeSlider)
					volumeValue.setText("" + newValue);
				if (source == pitchSlider)
					pitchValue.setText("" + newValue) ;
				if (source == rateSlider)
					rateValue.setText("" + newValue);
			}
		};
		makeLabel("Volume",25, 50);
		createVolumeSlider();
		makeLabel("Pitch", 25, 90);
		createPitchSlider();
		makeLabel("Rate", 25, 130);
		createRateSlider();
	}

	private void createFinalizeButtons() {
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		okButton.addActionListener(this);
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		cancelButton.addActionListener(this);
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
	}
	
	private void createVolumeSlider() {
		volumeSlider.setBounds(150, 50, 200, 20);
		contentPanel.add(volumeSlider);
		volumeSlider.addChangeListener(listener);
	}
	
	private void createPitchSlider() {
		pitchSlider.setBounds(150, 90, 200, 20);
		contentPanel.add(pitchSlider);
		pitchSlider.addChangeListener(listener);
	}
	
	private void createRateSlider() {
		rateSlider.setBounds(150, 130, 200, 16);
		contentPanel.add(rateSlider);
		rateSlider.addChangeListener(listener);
	}
	
	// This should be Refactored
	private void makeLabel(String name, int xOffset, int yOffset) {
		JLabel newLabel = new JLabel(name);
		newLabel.setBounds(xOffset, yOffset, 70, 15);
		contentPanel.add(newLabel);
		// Value Labels
		{
			volumeValue.setBounds(375, 50, 70, 15);
			contentPanel.add(volumeValue);
		}
		{
			pitchValue.setBounds(375, 90, 70, 15);
			contentPanel.add(pitchValue);
		}
		{
			rateValue.setBounds(375, 130, 70, 15);
			contentPanel.add(rateValue);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton)
			finalizeDialog();
		else if (e.getSource() == cancelButton)
			dispose();
	}
	
	private void finalizeDialog() {
		new ConfigureTransformerCmd(volumeSlider.getValue(), 
				pitchSlider.getValue(), 
				rateSlider.getValue());
		dispose();
	}
}
