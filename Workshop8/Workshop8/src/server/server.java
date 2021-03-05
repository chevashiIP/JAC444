package server;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class server implements Runnable{

	private static JFrame frame;
	private static JTextArea serverwindow;
	Socket connectionSocket;     
    public static Vector clients=new Vector();
    
	public server(Socket s){
        try{
                System.out.println("Connection from " + s + " at " + new Date());
                serverwindow.append("Connection from " + s + " at " + new Date() + "\n");
                connectionSocket=s;
        }catch(Exception e){e.printStackTrace();}
	}    
	public static void main(String[] args) throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		serverwindow = new JTextArea();
		serverwindow.setEditable(false);
		serverwindow.setBounds(10, 11, 564, 439);
		frame.getContentPane().add(serverwindow);
		
		frame.setVisible(true); 
		Date date = new Date();
		System.out.println("MultiThreadServer started at " + date);
		serverwindow.append("MultiThreadServer started at " + date+ "\n");
	    ServerSocket mysocket = new ServerSocket(5555);
	        while(true){
	        Socket sock = mysocket.accept();
	        server server= new server(sock);
	        Thread serverThread=new Thread(server);
	        serverThread.start();
	        }
	    }
	@Override
	public void run(){
	    try{
	    	
	            BufferedReader reader =
	                            new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
	            BufferedWriter writer= 
	                            new BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));
	            
	            clients.add(writer); 
	            
	        while(true){
	        	String data1 = "";
	        	
	        		data1 = reader.readLine().trim();
	        	
	            System.out.println("Received : "+data1);      
	            serverwindow.append(data1 + "\n");
	            for (int i=0;i<clients.size();i++){
	               try{
	                    BufferedWriter bw= (BufferedWriter)clients.get(i);
	                    
	                    bw.write(data1);
	                    bw.write("\r\n");
	                    bw.flush();
	                }catch(Exception e){e.printStackTrace();}
	            }
	        }
	    }catch(Exception e){e.printStackTrace();}
	}
}
