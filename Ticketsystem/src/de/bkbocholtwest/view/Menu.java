package de.bkbocholtwest.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.SpringLayout;

import de.bkbocholtwest.model.App;
import de.bkbocholtwest.model.CommentSection;
import de.bkbocholtwest.model.Department;
import de.bkbocholtwest.model.TicketClass;
import de.bkbocholtwest.model.User;

import java.awt.event.ActionListener;
import java.io.ObjectInputStream.GetField;
import java.sql.Date;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.CardLayout;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;

public class Menu extends mainView {

	public JFrame frame;
	private JTextField txtTitle;
	private JTextField txtDescription;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
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
	public Menu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		String[] UserTickets = new String[User.createdTickets.size()];
		//TicketClass[] UserTickets = new TicketClass[User.createdTickets.size()];
		int i=0;
		for (TicketClass ticket : User.createdTickets) {
			UserTickets[i]=ticket.toString();
			i++;
		}
		frame.getContentPane().setLayout(null);
		
		JLabel lblTickets = new JLabel("Tickets");
		lblTickets.setBounds(36, 46, 87, 23);
		frame.getContentPane().add(lblTickets);
		//mainWindow.getPRG().activeUser.createdTickets;

		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(339, 11, 87, 23);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainWindow.getPRG().activeUser.Logout();
				
				mainWindow.goToLogin();
			}
		});
		frame.getContentPane().add(btnLogOut);
		JList list = new JList(UserTickets);
		list.setBounds(36, 69, 254, 51);
		frame.getContentPane().add(list);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(36, 145, 87, 23);
		frame.getContentPane().add(lblTitle);		
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(133, 149, 96, 14);
		frame.getContentPane().add(lblDescription);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(36, 179, 87, 20);
		frame.getContentPane().add(txtTitle);
		txtTitle.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setBounds(133, 179, 157, 20);
		frame.getContentPane().add(txtDescription);
		txtDescription.setColumns(10);
		
		JButton btnCreateTickets = new JButton("Create");
		btnCreateTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!txtTitle.getText().isEmpty() && !txtDescription.getText().isEmpty()) {
					//Tickets werden in der Datenbank erstellt und in die ArrayList createdTickets geschrieben
					App.activeUser.createTickets(txtDescription.getText(), txtTitle.getText());
				}
			}
		});
		
		btnCreateTickets.setBounds(36, 210, 89, 23);
		frame.getContentPane().add(btnCreateTickets);

		
		JLabel lblCreateTickets = new JLabel("CreateTickets");
		lblCreateTickets.setBounds(36, 120, 157, 23);
		frame.getContentPane().add(lblCreateTickets);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(289, 69, 23, 51);
		frame.getContentPane().add(scrollBar);


	}
}
