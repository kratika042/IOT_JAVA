package neu.kratikamaheshwari.connecteddevices.labs.module05;

import java.io.IOException;
import py4j.*;
public class GatewayHandlerApp extends Thread {

	public static void main(String[] args){
		
		// TODO Auto-generated method stub
		//System.out.println("hey");
		Thread t1=new Thread(new GatewayDataManager());
		t1.start();
		
	
	}

}
