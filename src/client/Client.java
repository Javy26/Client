package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	private ObjectInputStream inputStream;
	private ObjectOutputStream outputStream;
	private Socket sock;
	
	
	Client(){
		
		try {
			sock = new Socket ("localhost", 3008);
			outputStream = new ObjectOutputStream(sock.getOutputStream());
			inputStream = new ObjectInputStream(sock.getInputStream());
			
		
			Scanner input= new Scanner(System.in);
			System.out.println("Enter a number");
			int num1 = input.nextInt();
			
			System.out.println("Enter the operation");
			Scanner input3= new Scanner(System.in);
			String operation = input3.nextLine();
			
			
			System.out.println("Enter a second number");
			Scanner input2= new Scanner(System.in);
			int num2 = input2.nextInt();
			
		
			
			
			outputStream.writeObject(num1);
			outputStream.flush();
			outputStream.writeObject(num2);
			outputStream.flush();
			outputStream.writeObject(operation);
			outputStream.flush();
			
			
			try {
				Integer result = (Integer) inputStream.readObject();
				System.out.println("Answer is:" +result );
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}
	
	public static void main(String args[]){
		
		new Client();
	}
	
}
