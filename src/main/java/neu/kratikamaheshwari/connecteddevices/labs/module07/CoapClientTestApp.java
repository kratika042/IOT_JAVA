package neu.kratikamaheshwari.connecteddevices.labs.module07;

import java.io.IOException;

import neu.kratikamaheshwari.connecteddevices.labs.module05.DataUtil;
import neu.kratikamaheshwari.connecteddevices.common.SensorData;

public class CoapClientTestApp {
	//public static void main(String[] args) throws IOException
	//{		
		//runTests();
	//}
	
	//This method runs test with get, post, put, delete methods
	
	public static void runTests(SensorData data) throws IOException
	{
		System.out.println("Starting client...");
		CoapClientConnector coapClient = new CoapClientConnector("coap://127.0.0.1:5683");
				
	//	SensorData data = new SensorData();
		DataUtil dat = new DataUtil();
		System.out.println(data);
		
		//Ping the server
		coapClient.ping();
		
		//Post to the server to initialize data, then get the data back as JSON
		coapClient.get();
		coapClient.post(dat.toJsonFromSensorData(data));
		coapClient.get();
		
		//put data
		coapClient.put(dat.toJsonFromSensorData(data));
		coapClient.get();
		
		//Delete data
		coapClient.delete();
		coapClient.get();
	}
}
