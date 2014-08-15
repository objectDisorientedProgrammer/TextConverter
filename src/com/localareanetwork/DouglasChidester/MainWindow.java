/*
 * created Sept 10, 2013 around 11:46 PM
 * finished 
 * 
 * main gui window
 * 
 * To Do
 *   make window and components resize
 *   add 'tab' key
 *   add read/write to file option?
 *   stop extending jframe
 *   make a initComponents() method
 *   check for invalid input text/binary/hex
 *   combobox change listener
 */

package com.localareanetwork.DouglasChidester;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MainWindow extends JFrame
{
	// variables
	private static final String applicationName = "Text Converter";
	private static final String version = " v0.8.11b";
	//private final static String author = "Douglas Chidester";
	private static int frameWidth = 400;
	private static int frameHeight = 285;
	
	private String[] conversionOptions = { "Text to Binary", "Binary to Text" ,
			"Text to Hexadecimal", "Hexadecimal to Text" ,"Binary to Hexadecimal", "Hexadecimal to Binary" };
	private String ascii = "Text";
	private String binary = "Binary";
	private String hex = "Hexidecimal";
	
	// the UI will be divided up into left and right components
	private JPanel mainPanel;
	
	private JTextArea leftTextArea;
	private JScrollPane leftScrollPane;
	private JTextArea rightTextArea;
	private JScrollPane rightScrollPane;
	private JLabel leftLabel;
	private JLabel rightLabel;
	
	private JComboBox<String> comboBox;
	private JButton convertButton;
	private JButton clearButton;
	
	
	public MainWindow()
	{
		super(applicationName + version);
		mainPanel = new JPanel(new GridLayout(0, 2, 5, 5));
		
		mainPanel.setBackground(Color.LIGHT_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(frameWidth, frameHeight);			// set frame size 
		setLocationRelativeTo(null);					// set frame location to center of screen
		
		leftTextArea = new JTextArea();
		leftTextArea.setToolTipText("Type here.");
		leftTextArea.setLineWrap(true);
		leftTextArea.setTabSize(4);
		
		leftScrollPane = new JScrollPane(leftTextArea);
		leftScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		rightTextArea = new JTextArea();
		rightTextArea.setEditable(false);
		rightTextArea.setLineWrap(true);
		
		rightScrollPane = new JScrollPane(rightTextArea);
		rightScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		leftLabel = new JLabel("Ascii");
		leftLabel.setFont(new Font("Serif", Font.BOLD, 16));
		leftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		leftLabel.setLabelFor(leftTextArea);
		leftLabel.setToolTipText("From");
		
		rightLabel = new JLabel("Binary");
		rightLabel.setFont(new Font("Serif", Font.BOLD, 16));
		rightLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rightLabel.setLabelFor(rightTextArea);
		rightLabel.setToolTipText("To");
		
		comboBox = new JComboBox<String>(conversionOptions);
		// When selection is changed, update labels
		comboBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				switch(comboBox.getSelectedIndex())
				{
					case 0:	// a -> b
						leftLabel.setText(ascii);
						rightLabel.setText(binary);
						break;
					case 1:	// b -> a
						leftLabel.setText(binary);
						rightLabel.setText(ascii);
						break;
					case 2:	// t -> h
						leftLabel.setText(ascii);
						rightLabel.setText(hex);
						break;
					case 3:	// h -> t
						leftLabel.setText(hex);
						rightLabel.setText(ascii);
						break;
					case 4:	// b -> h
						leftLabel.setText(binary);
						rightLabel.setText(hex);
						break;
					case 5:	// h -> b
						leftLabel.setText(hex);
						rightLabel.setText(binary);
						break;
					default:
						leftLabel.setText(ascii);
						rightLabel.setText(binary);
				}
			}
		});
		
		
		convertButton = new JButton("Convert");
		convertButton.setBackground(new Color(255, 204, 102));
		// when user hits convert, take text from leftTextArea and convert it based on selected option
		convertButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				AsciiToBinaryConverter ascToBin = new AsciiToBinaryConverter();
				BinaryToAsciiConverter binToAsc = new BinaryToAsciiConverter();
				AsciiToHexConverter ascToHex = new AsciiToHexConverter();
				HexToAsciiConverter hexToAsc = new HexToAsciiConverter();
				switch(comboBox.getSelectedIndex())
				{
					case 0:	// a -> b
						rightTextArea.setText(ascToBin.convertString(leftTextArea.getText()));
						break;
					case 1:	// b -> a
						rightTextArea.setText(binToAsc.convertString(leftTextArea.getText()));
						break;
					case 2:	// t -> h
						rightTextArea.setText(ascToHex.convertString(leftTextArea.getText()));
						break;
					case 3:	// h -> t
						rightTextArea.setText(hexToAsc.convertString(leftTextArea.getText()));
						break;
					case 4:	// b -> a -> h
						rightTextArea.setText(ascToHex.convertString(binToAsc.convertString(leftTextArea.getText())));
						break;
					case 5:	// h -> a -> b
						rightTextArea.setText(ascToBin.convertString(hexToAsc.convertString(leftTextArea.getText())));
						break;
					default:
						rightTextArea.setText("This should never show.");
				}
			}
		});
		
		
		clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent ae)
			{
				leftTextArea.setText("");
				rightTextArea.setText("");
			}
		});
		
		addComponents();
		add(mainPanel);
		//pack();
		setVisible(true);
	}
	
	private void addComponents()
	{
		mainPanel.add(leftLabel);
		mainPanel.add(rightLabel);
		mainPanel.add(leftScrollPane);
		mainPanel.add(rightScrollPane);
		mainPanel.add(comboBox);
		mainPanel.add(convertButton);
		mainPanel.add(clearButton);
	}
}
