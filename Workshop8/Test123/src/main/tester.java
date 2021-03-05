package main;
import client.*;

public class tester {
	public static void main(String [] args){
 	   try{
 	        System.out.println("Hello ");        	        
                 client c = new client("My Name Here");   
                 Thread t1 = new Thread(c);
                 Thread t2 = new Thread(c);
                 t1.start();
                 
                 
 	   }catch(Exception e){e.printStackTrace();}
 
	}
}
