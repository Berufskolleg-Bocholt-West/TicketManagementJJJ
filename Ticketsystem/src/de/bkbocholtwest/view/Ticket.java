package de.bkbocholtwest.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;

import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Panel;
import java.awt.Font;
import java.awt.ScrollPane;

public class Ticket {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket window = new Ticket();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ticket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 507, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(20, 22, 417, 22);
		frame.getContentPane().add(menuBar);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(466, 22, 17, 409);
		frame.getContentPane().add(scrollBar);
		
		Panel panel = new Panel();
		panel.setBounds(20, 50, 417, 39);
		frame.getContentPane().add(panel);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblTitle);
		
		Panel panel_1 = new Panel();
		panel_1.setBounds(20, 103, 288, 369);
		frame.getContentPane().add(panel_1);
		
		JLabel lblDescription = new JLabel("Desscription");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_1.add(lblDescription);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(314, 104, 124, 96);
		frame.getContentPane().add(panel_2);
		
		JLabel lbleditor = new JLabel("editor");
		panel_2.add(lbleditor);
		
		Panel panel_3 = new Panel();
		panel_3.setBounds(314, 205, 123, 153);
		frame.getContentPane().add(panel_3);
		
		JLabel lblStatus = new JLabel("Status");
		panel_3.add(lblStatus);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(314, 364, 124, 108);
		frame.getContentPane().add(panel_4);
		
		JLabel lblDeadline = new JLabel("Deadline");
		panel_4.add(lblDeadline);

	}
}
