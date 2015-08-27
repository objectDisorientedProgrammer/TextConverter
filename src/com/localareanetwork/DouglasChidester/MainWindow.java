/*
 * created Sept 10, 2013 around 11:46 PM
 * 
 * Main GUI for Text Converter.
 *  Copyright (C) 2013  Douglas Chidester
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * 
 * To Do
 *   make window and components resize
 *   add 'tab' key
 *   add read/write to file option?
 *   check for invalid input text/binary/hex
 */

package com.localareanetwork.DouglasChidester;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class MainWindow
{
	// variables
	private static final String applicationName = "Text Converter";
	private static final String version = " v0.9.1b";
	private final static String author = "Douglas Chidester";
	private static int frameWidth = 400;
	private static int frameHeight = 285;
	private static int padding = 3;
	
	private String[] conversionOptions = { "Text to Binary", "Binary to Text" ,
			"Text to Hexadecimal", "Hexadecimal to Text" ,"Binary to Hexadecimal", "Hexadecimal to Binary" };
	private String ascii = "Text";
	private String binary = "Binary";
	private String hex = "Hexidecimal";
	
	// the UI will be divided up into left and right components
	private JFrame mainFrame;
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
	
	// Images
	String imagePath = "/images/";	// path in jar file
	
	public MainWindow()
	{
		super();
		initFrame();
		initPanel();
		createMenubar();
		initGUIelements();
		addComponents();
		mainFrame.setVisible(true);
	}

	/**
	 * Create and set up the panel.
	 */
	private void initPanel() 
	{
		mainPanel = new JPanel(new GridLayout(0, 2, padding, padding)); // row, col, hgap, vgap
		mainPanel.setBackground(Color.LIGHT_GRAY);
	}

	/**
	 * Create and set up all GUI components.
	 */
	private void initGUIelements()
	{
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
		
		leftLabel = new JLabel("Text");
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
				// TODO convert on different selection type.
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
				// TODO clean this up
				AsciiToBinaryConverter ascToBin = new AsciiToBinaryConverter();
				BinaryToAsciiConverter binToAsc = new BinaryToAsciiConverter();
				AsciiToHexConverter ascToHex = new AsciiToHexConverter();
				HexToAsciiConverter hexToAsc = new HexToAsciiConverter();
				
				// TODO maybe add this switch into its own action listener so multiple things can use it
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
					default: // should never show
						JOptionPane.showMessageDialog(mainFrame, "Invalid conversion option.", "Conversion Error!", JOptionPane.ERROR_MESSAGE);
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
	}
	
	/**
	 * Create and set attributes for the frame.
	 */
	private void initFrame()
	{
		mainFrame = new JFrame(applicationName + version);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setSize(frameWidth, frameHeight);		// set frame size 
		mainFrame.setLocationRelativeTo(null);			// set frame location to center of screen
	}
	
	/**
	 * Create and add a menu bar to the frame.
	 */
	private void createMenubar()
	{
		JMenuBar menuBar = new JMenuBar();
        mainFrame.setJMenuBar(menuBar);
        
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);
        
        JMenuItem menuItemExit = new JMenuItem("Exit", new ImageIcon(this.getClass().getResource(imagePath+"exit.png")));
        menuItemExit.setMnemonic(KeyEvent.VK_E);
        menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.dispose(); // close program if user clicks: File -> Exit
			}
		});
        fileMenu.add(menuItemExit);
        
        JMenu helpMenu = new JMenu("Help");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        menuBar.add(helpMenu);
        
        JMenuItem menuItemGettingStarted = new JMenuItem("Getting Started", new ImageIcon(this.getClass().getResource(imagePath+"help.png")));
        menuItemGettingStarted.setMnemonic(KeyEvent.VK_G);
        menuItemGettingStarted.setToolTipText("Basic useage instructions");
        menuItemGettingStarted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// show basic use instructions if user clicks: Help -> Getting Started
				JOptionPane.showMessageDialog(null, "Assumes 8 bits for binary and 2 digits for hex.", "Getting Started",
						JOptionPane.PLAIN_MESSAGE, new ImageIcon(this.getClass().getResource(imagePath+"help64.png")));
			}
		});
        helpMenu.add(menuItemGettingStarted);
        
        JMenuItem menuItemAbout = new JMenuItem("About", new ImageIcon(this.getClass().getResource(imagePath+"about.png")));
        menuItemAbout.setMnemonic(KeyEvent.VK_A);
        menuItemAbout.setToolTipText("About this program");
        menuItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// show credits & version if user clicks: Help -> About
				JOptionPane.showMessageDialog(null, "Created by " + author + "\nVersion " + version, "About",
						JOptionPane.INFORMATION_MESSAGE, new ImageIcon(this.getClass().getResource(imagePath+"person.png")));
			}
		});
        helpMenu.add(menuItemAbout);
	}

	/**
	 * Add GUI elements to the panel and the panel to the frame.
	 */
	private void addComponents()
	{
		mainPanel.add(leftLabel);
		mainPanel.add(rightLabel);
		mainPanel.add(leftScrollPane);
		mainPanel.add(rightScrollPane);
		mainPanel.add(comboBox);
		mainPanel.add(convertButton);
		mainPanel.add(clearButton);
		
		mainFrame.add(mainPanel);
	}
}
