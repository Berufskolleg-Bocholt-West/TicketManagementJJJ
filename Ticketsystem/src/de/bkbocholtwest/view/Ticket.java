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

import de.bkbocholtwest.controller.LoginAuth;
import de.bkbocholtwest.model.App;
import de.bkbocholtwest.model.TicketClass;
import de.bkbocholtwest.model.User;

import java.awt.Color;
import javax.swing.JScrollPane;

public class Ticket {

	private JFrame frame;
	private JTextField txtWriteAComment;
	private JTextField txtTitle;
	private JTextField txtDescription;
	private JTextField textStatus;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//temporary
		App a = new App();
		//
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
		frame.setBounds(100, 100, 508, 687);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		TicketClass[] tickets = new TicketClass[User.createdTickets.size()];
		int i=0;
		for (TicketClass ticket : User.createdTickets) {
			tickets[i]=ticket;
			i++;
		}
		
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(466, 22, 17, 409);
		frame.getContentPane().add(scrollBar);
		
		JPanel panelCommentSection = new JPanel();
		panelCommentSection.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelCommentSection.setBounds(20, 435, 448, 193);
		frame.getContentPane().add(panelCommentSection);
		panelCommentSection.setLayout(null);
		
		txtWriteAComment = new JTextField();
		txtWriteAComment.setBounds(10, 11, 428, 51);
		txtWriteAComment.setText("Write a comment...");
		panelCommentSection.add(txtWriteAComment);
		txtWriteAComment.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 0), null, null, null));
		scrollPane.setBounds(10, 183, 428, -113);
		panelCommentSection.add(scrollPane);
		
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
		lblDescription.setBounds(107, 11, 77, 14);
		panelDescription.add(lblDescription);
		
		txtDescription = new JTextField();
		txtDescription.setText(tickets[0].getDescription());
		txtDescription.setBounds(10, 36, 267, 262);
		panelDescription.add(txtDescription);
		txtDescription.setColumns(10);
		
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		titlePanel.setBounds(66, 11, 371, 39);
		frame.getContentPane().add(titlePanel);
		titlePanel.setLayout(null);
		
		txtTitle = new JTextField();
		txtTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTitle.setBounds(10, 0, 351, 39);
		titlePanel.add(txtTitle);
		txtTitle.setText(tickets[0].getTitle());
		txtTitle.setColumns(10);
		
		JPanel panelEditors = new JPanel();
		panelEditors.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelEditors.setBounds(313, 112, 123, 90);
		frame.getContentPane().add(panelEditors);
		panelEditors.setLayout(null);
		
		JLabel lblEditors = new JLabel("editor/s");
		lblEditors.setBounds(38, 7, 46, 14);
		lblEditors.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelEditors.add(lblEditors);
		
		JLabel lblEditor = new JLabel("");
		lblEditor.setBounds(10, 32, 103, 47);
		panelEditors.add(lblEditor);
		
		//panelEditors.setToolTipText(tickets[0].getEditor().getUsername());
		
		JPanel panelStatus = new JPanel();
		panelStatus.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelStatus.setBounds(317, 213, 123, 117);
		
		panelStatus.setToolTipText(tickets[0].getAktuellerStatus().toString());
		
		frame.getContentPane().add(panelStatus);
		panelStatus.setLayout(null);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(43, 7, 37, 14);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelStatus.add(lblStatus);
		
		textStatus = new JTextField();
		textStatus.setBounds(10, 32, 96, 74);
		panelStatus.add(textStatus);
		textStatus.setColumns(10);
		textStatus.setText(tickets[0].getAktuellerStatus().toString());
		
		
		JPanel panelDeadline = new JPanel();
		panelDeadline.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelDeadline.setBounds(313, 331, 123, 90);
		frame.getContentPane().add(panelDeadline);
		panelDeadline.setLayout(null);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(37, 7, 49, 14);
		lblDeadline.setFont(new Font("Tahoma", Font.BOLD, 11));
		panelDeadline.add(lblDeadline);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 24, 103, 55);
		panelDeadline.add(textField_1);
		textField_1.setColumns(10);

	}
}
