package de.bkbocholtwest.view;

import java.awt.EventQueue;
import java.util.Date;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class DeviceIsLocked extends mainView{

	public JFrame frame;
	

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
	 * Create the application.
	 */
	public DeviceIsLocked() {
		initialize();
		Timer timer = new Timer();
		clock();
	}
	
	
	public void clock() {
		Date rP = mainWindow.getPRG().getPenalty();
		Thread tim = new Thread() {
			public void run() {
				long dt;
				int hours;
				int minutes;
				int seconds;
				try {
					for(;;) {
						 dt = rP.getTime()-new Date().getTime();
						Date d=new Date(dt);
						 hours = d.getHours();
						 minutes = d.getMinutes();
						 seconds = d.getSeconds();

						String timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
						System.out.println(timeString);
						sleep(1000);
					}
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		};
		tim.start();
			
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your Device has been locked");
		lblNewLabel.setBounds(121, 105, 159, 32);
		frame.getContentPane().add(lblNewLabel);
	}
}









