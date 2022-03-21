package de.bkbocholtwest.view;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DeviceIsLocked extends mainView{

	public JFrame frame;
	private JLabel lblTimer = new JLabel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeviceIsLocked window = new DeviceIsLocked();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLock = new JLabel("Your Device has been locked!");
		lblLock.setBounds(125, 58, 187, 32);
		frame.getContentPane().add(lblLock);
		
		lblTimer.setBounds(125, 101, 187, 32);
		frame.getContentPane().add(lblTimer);
	}
	
	public void setTimer(String timer) {
		lblTimer.setText("Locked For: "+ timer);

	}

	/**
	 * Create the application.
	 */
	public DeviceIsLocked() {
		initialize();
		Timer timer = new Timer();
		clock();
	}
	
	
	public void clock() {
		Date penaltyTime = mainWindow.getPRG().getPenalty();
		Thread tim = new Thread() {
			public void run() {
				long timeDifference;
				int hours;
				int minutes;
				int seconds;
				try {
					for(;;) {
						timeDifference = penaltyTime.getTime()-new Date().getTime();
						 
						seconds = (int) (timeDifference / 1000) % 60 ;
						minutes = (int) ((timeDifference / (1000*60)) % 60);
						hours   = (int) ((timeDifference / (1000*60*60)) % 24);
						 
						String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
						setTimer(timeString);
						sleep(1000);
						mainWindow.getPRG().checkPenalty();
						if(!mainWindow.getPRG().getIsLocked()) {
							break;
						}
						
					}
					mainWindow.goToLogin();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		tim.start();
			
		
	}


}









