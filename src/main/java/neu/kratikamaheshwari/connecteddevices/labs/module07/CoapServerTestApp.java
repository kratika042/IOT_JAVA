package neu.kratikamaheshwari.connecteddevices.labs.module07;


import java.net.SocketException;
import neu.kratikamaheshwari.connecteddevices.common.ConfigUtil;


public class CoapServerTestApp {
	public void coapTest()
	{
		System.out.println("Server is Running!!");
		
		ConfigUtil config = ConfigUtil.getInstance(); //instance of config is created
		
		
		try {
			CoapServerConnector coapServer = new CoapServerConnector(config);  //CoapServerConnector object is created
			coapServer.start();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
