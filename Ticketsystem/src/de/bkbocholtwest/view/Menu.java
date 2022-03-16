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

public class Menu extends mainView {

	public JFrame frame;

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
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);

		//die hier müssen natürlich eigentlich aus der Datenbank gezogen werden und dann im LoginAuth erstellt werden
		App.activeUser.createTickets("description", "title");
		App.activeUser.createTickets("Das ist ein Test description", "test title");
		
		String[] UserTickets = new String[User.createdTickets.size()];
		//TicketClass[] UserTickets = new TicketClass[User.createdTickets.size()];
		int i=0;
		for (TicketClass ticket : User.createdTickets) {
			UserTickets[i]=ticket.toString();
			i++;
		}
		JList list = new JList(UserTickets);
		springLayout.putConstraint(SpringLayout.NORTH, list, 97, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list, 107, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(list);
		//mainWindow.getPRG().activeUser.createdTickets;

		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mainWindow.getPRG().activeUser.Logout();
				mainWindow.goToLogin();
			}
		});
		
		springLayout.putConstraint(SpringLayout.NORTH, btnLogOut, 10, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnLogOut, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnLogOut);


	}
}
