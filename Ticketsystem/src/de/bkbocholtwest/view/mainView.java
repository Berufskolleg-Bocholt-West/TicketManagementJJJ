package de.bkbocholtwest.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import de.bkbocholtwest.model.App;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mainView {

	private JFrame mainFrame;
	
	public static mainView mainWindow;
	
	private App prg;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					mainWindow = new mainView();
					mainWindow.mainFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainView() {
		initialize();
		prg = new App();
	}
	
	public App getPRG() {
		return prg;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start System");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 goToLogin();
				
			}
		});
		btnNewButton.setBounds(166, 118, 95, 23);
		mainFrame.getContentPane().add(btnNewButton);
	}
	
	public JFrame getMainFrame() {
		return mainFrame;
	}
	
	public void goToLogin() {
		Login log = new Login();
		mainFrame.setVisible(false);
		
		mainFrame.setContentPane(log.frame.getContentPane());  
		
		mainFrame.setVisible(true);
	}
	
	public void goToRegister() {
		Register reg = new Register();
		mainFrame.setVisible(false);
		
		mainFrame.setContentPane(reg.frame.getContentPane());  
		
		mainFrame.setVisible(true);
	}
	
	

}
