package client;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class client implements Runnable  {

	private JFrame frame;
	private static JFrame frame1;
	private static JTextField sendtf = new JTextField();;
	private static JTextArea cl = new JTextArea();
	
	public String login="Imed";
    BufferedWriter writer;
    BufferedReader reader;
    
    public static void main(String[] args) throws IOException {
    	frame1 = new JFrame("Login page");
		frame1.setBounds(100, 100, 503, 366);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		
		sendtf.setBounds(10, 274, 320, 28);
		frame1.getContentPane().add(sendtf);
		sendtf.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String login = sendtf.getText();
					client c = new client(login);
					Thread t = new Thread(c);
					t.start();
				frame1.setVisible(false);
			}
		});
		btnSend.setBounds(340, 277, 137, 25);
		frame1.getContentPane().add(btnSend);
		
		JLabel lblEnterYourNickname = new JLabel("Enter your Nickname");
		lblEnterYourNickname.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblEnterYourNickname.setBounds(94, 94, 328, 134);
		frame1.getContentPane().add(lblEnterYourNickname);
		
		frame1.setVisible(true);
    }
    
	public client(String l){
		frame = new JFrame(l);
		frame.setBounds(100, 100, 503, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		cl.setEditable(false);
		cl.setBounds(10, 11, 467, 252);
		frame.getContentPane().add(cl);
		
		
		sendtf.setBounds(10, 274, 320, 28);
		frame.getContentPane().add(sendtf);
		sendtf.setColumns(10);
		login = l;
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=login+" : "+ sendtf.getText();  
                sendtf.setText("");
                try{
                    writer.write(s);
                    writer.write("\r\n");
                    writer.flush(); 
                }catch(Exception a){
                    a.printStackTrace();
                }
			}
		});
		btnSend.setBounds(340, 277, 137, 25);
		frame.getContentPane().add(btnSend);
		
		frame.setVisible(true);
		
		try{
            Socket socketClient= new Socket("localhost",5555);
            writer= new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            reader =new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	@Override
	public void run(){
        try{
           String serverMsg=""; 
           while((serverMsg = reader.readLine()) != null){
               System.out.println("from server: " + serverMsg);
               cl.append(serverMsg+"\n");
           }
   }catch(Exception e){e.printStackTrace();}   
}
}
