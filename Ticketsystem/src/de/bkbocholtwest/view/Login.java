package de.bkbocholtwest.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import de.bkbocholtwest.model.Admin;
import de.bkbocholtwest.model.App;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends mainView{

	public JFrame frame;
	private JTextField txtUsername;
	
	private JPasswordField txtpasswordField;
	
	public int counter = 2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public int attemptCounter(int counter, JLabel lblAttemptsCounter) {
		
		lblAttemptsCounter.setText("You have "+counter+" attempts left.");
		lblAttemptsCounter.setVisible(true);
		
		return counter;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNoText =  new JLabel("Password and Username cannot be empty!");
		lblNoText.setBounds(154, 224, 272, 28);
		lblNoText.setVisible(false);
		frame.getContentPane().add(lblNoText);
		
		JLabel lblAttemptsCounter = new JLabel("You have "+counter+" attempts left.");
		lblAttemptsCounter.setBounds(154, 249, 220, 37);
		lblAttemptsCounter.setVisible(false);
		frame.getContentPane().add(lblAttemptsCounter);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(52, 54, 92, 25);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(52, 90, 92, 21);
		frame.getContentPane().add(lblPassword);
		
		
		JButton btnRegister = new JButton("I dont have an Account");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//hier noch überprüfen ob der User ein Admin ist.				
				
				mainWindow.goToRegister();
				
				
			}
		});
		
		btnRegister.setBounds(154, 167, 220, 28);
		frame.getContentPane().add(btnRegister);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(154, 54, 220, 28);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassOrUserWrong = new JLabel("Password or Username is incorrect!");
		lblPassOrUserWrong.setEnabled(false);
		lblPassOrUserWrong.setBounds(154, 206, 220, 46);
		lblPassOrUserWrong.setVisible(false);
		frame.getContentPane().add(lblPassOrUserWrong);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int successLog = mainWindow.getPRG().login(txtUsername.getText(), txtpasswordField.getText());
				if (successLog == 1) {
					//success login username and pass are correct
					lblPassOrUserWrong.setEnabled(false);
					lblPassOrUserWrong.setVisible(false);
					lblAttemptsCounter.setVisible(false);
					lblNoText.setVisible(false);
					//hier wird das nächste gui aufgerufen
					mainWindow.goToMenu();
					
				}else if(successLog == 2) {
					lblPassOrUserWrong.setEnabled(false);
					lblPassOrUserWrong.setVisible(false);
					lblAttemptsCounter.setVisible(false);
					lblNoText.setVisible(true);
					
				}
				else{
					lblPassOrUserWrong.setEnabled(true);
					lblPassOrUserWrong.setVisible(true);
					lblNoText.setVisible(false);
					
					attemptCounter(counter, lblAttemptsCounter);
					counter--;
					if (counter == 0) {
						counter = 3;
					}
				}
				
				if(mainWindow.getPRG().getIsLocked()) {
					mainWindow.goToLock();
				}
			}	
		});
		btnLogin.setBounds(154, 125, 220, 28);
		frame.getContentPane().add(btnLogin);
		
		txtpasswordField = new JPasswordField();
		txtpasswordField.setBounds(154, 86, 220, 28);
		frame.getContentPane().add(txtpasswordField);
		

		
		


		
		
	}
}
