package neu.kratikamaheshwari.connecteddevices.labs.module05;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.labbenchstudios.iot.common.PersistenceUtil;

import neu.kratikamaheshwari.connecteddevices.common.ActuatorData;
import neu.kratikamaheshwari.connecteddevices.common.SensorData;

import neu.kratikamaheshwari.connecteddevices.labs.module07.CoapClientTestApp;
import neu.kratikamaheshwari.connecteddevices.labs.module07.CoapServerTestApp;
import redis.clients.jedis.Jedis;
public class GatewayDataManager implements Runnable {
	PersistenceUtil pu=new PersistenceUtil();
	private  String name;
	private  String timestamp;
	private  String currentVal;
	private  String AverageVal;
	private  String minVal;
	private  String maxVal;
	private  String count;
	private float nomTemp=15;
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
		Jedis jed=new Jedis("localhost");
	//	System.out.println("ok");
		String s="";
		String sd_j="";
		ActuatorData ad1;
		SensorDataManager sdm = new SensorDataManager();
		SensorData sd;
		ActuatorData ad=new ActuatorData();
		String[] l= {};
		s=jed.get("Temperature");
		
		DataUtil du=new DataUtil();
		
		sd=du.toSensorDataFromJson(s);
		
		System.out.println(sd);
		CoapServerTestApp c=new CoapServerTestApp();
		
	//	c.coapTest();;
		sd_j=du.toJsonFromSensorData(sd);
		System.out.println("CoAP Server...");
		System.out.println("Sensor Data from DBMS:");
		System.out.println(sd_j);
		System.out.println("************");
		ad1=pu.getActuatorDataFromDbms();
		//System.out.println(sd.getAverageValue());
		if(Math.abs(sd.getCurrentValue()-ad1.getCurrentVal())>5) {
		ad=sdm.handleSensorData(sd);
		
		ad=du.toActuatorDataFromJson(du.toJsonFromActuatorData(ad));
		System.out.println("Writing Actuation to DBMS");
		System.out.println("************");
		pu.writeActuatorDataToDbms(ad);
		System.out.println("************");
		}
		//else {
			//System.out.println("No need of actuation");
	//	}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}

}
