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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Color;

public class Ticket {

	private JFrame frame;
	private JTextField txtWriteAComment;
	private JTextField txtWriteATitle;
	private JTextField txtDescription;

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
		frame.setBounds(100, 100, 507, 678);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(466, 22, 17, 409);
		frame.getContentPane().add(scrollBar);
		
		JPanel panelCommentSection = new JPanel();
		panelCommentSection.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelCommentSection.setBounds(20, 435, 448, 193);
		frame.getContentPane().add(panelCommentSection);
		panelCommentSection.setLayout(null);
		
		txtWriteAComment = new JTextField();
		txtWriteAComment.setText("Write a comment...");
		txtWriteAComment.setBounds(10, 11, 428, 51);
		panelCommentSection.add(txtWriteAComment);
		txtWriteAComment.setColumns(10);
		
		JScrollBar scrollBarCommentSection = new JScrollBar();
		scrollBarCommentSection.setBounds(10, 66, 428, 116);
		panelCommentSection.add(scrollBarCommentSection);
		
		JPanel panelTicketId = new JPanel();
		panelTicketId.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelTicketId.setBounds(20, 10, 39, 39);
		frame.getContentPane().add(panelTicketId);
		
		JLabel lblTicketID = new JLabel("Ticket-ID");
		lblTicketID.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelTicketId.add(lblTicketID);
		
		JPanel PanelCreators = new JPanel();
		PanelCreators.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		PanelCreators.setBounds(20, 55, 416, 50);
		frame.getContentPane().add(PanelCreators);
		PanelCreators.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Created at date:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 25, 108, 14);
		PanelCreators.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("created from:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(162, 25, 89, 14);
		PanelCreators.add(lblNewLabel_2);
		
		JPanel panelDescription = new JPanel();
		panelDescription.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelDescription.setBounds(20, 112, 287, 309);
		frame.getContentPane().add(panelDescription);
		panelDescription.setLayout(null);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDescription.setBounds(119, 11, 64, 14);
		panelDescription.add(lblDescription);
		
		txtDescription = new JTextField();
		txtDescription.setText("Write a description...");
		txtDescription.setBounds(10, 36, 267, 262);
		panelDescription.add(txtDescription);
		txtDescription.setColumns(10);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		titlePanel.setBounds(66, 11, 371, 39);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		txtWriteATitle = new JTextField();
		txtWriteATitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtWriteATitle.setBounds(10, 0, 351, 39);
		titlePanel.add(txtWriteATitle);
		txtWriteATitle.setText("Write a title...");
		txtWriteATitle.setColumns(10);
		
		JPanel panelEditors = new JPanel();
		panelEditors.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelEditors.setBounds(313, 112, 123, 90);
		frame.getContentPane().add(panelEditors);
		
		JLabel lblEditors = new JLabel("editor/s");
		lblEditors.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelEditors.add(lblEditors);
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelStatus.setBounds(313, 207, 123, 117);
		frame.getContentPane().add(panelStatus);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelStatus.add(lblStatus);
		
		JPanel panelDeadline = new JPanel();
		panelDeadline.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelDeadline.setBounds(313, 331, 123, 90);
		frame.getContentPane().add(panelDeadline);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelDeadline.add(lblDeadline);

	}
}
