package Main;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.*;
import server.*;
public class Testerclass {
	private static JFrame frame;
	private static JTextField sendtf = new JTextField();;
	
	public static void main(String[] args) throws IOException {
		
		frame = new JFrame("Login page");
		frame.setBounds(100, 100, 503, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		sendtf.setBounds(10, 274, 320, 28);
		frame.getContentPane().add(sendtf);
		sendtf.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String login = sendtf.getText();
					client c = new client(login);
					Thread t = new Thread(c);
					t.start();
				frame.setVisible(false);
			}
		});
		btnSend.setBounds(340, 277, 137, 25);
		frame.getContentPane().add(btnSend);
		
		JLabel lblEnterYourNickname = new JLabel("Enter your Nickname");
		lblEnterYourNickname.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblEnterYourNickname.setBounds(94, 94, 328, 134);
		frame.getContentPane().add(lblEnterYourNickname);
		
		frame.setVisible(true);
		
		
	}
}
