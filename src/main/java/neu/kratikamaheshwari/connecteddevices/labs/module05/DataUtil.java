package neu.kratikamaheshwari.connecteddevices.labs.module05;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import neu.kratikamaheshwari.connecteddevices.common.ActuatorData;
import neu.kratikamaheshwari.connecteddevices.common.SensorData;
import redis.clients.jedis.Jedis;
public class DataUtil {
	private  String name;
	private  String timestamp;
	private  String currentVal;
	private  String averageVal;
	private  String minVal;
	private  String maxVal;
	private  String count;
	
	public SensorData toSensorDataFromJson(String j) {
		SensorData sd=new SensorData();
		String[] l={};
		l=j.replace("{", "").replace("}", "").replace("':", " @").replace("'", "").split(",");
		
	
		sd.setName(l[0].split("@")[1].trim());
		sd.setCurrentValue(Float.parseFloat(l[2].split("@")[1].trim()));
	//	System.out.println(l[5].split("@")[1].trim());
		sd.setMaxValue(Float.parseFloat(l[5].split("@")[1].trim()));
		sd.setAverageValue(Float.parseFloat(l[3].split("@")[1].trim()));
		sd.setMinValue(Float.parseFloat(l[4].split("@")[1].trim()));
		sd.setCount(Float.parseFloat(l[6].split("@")[1].trim()));
		//System.out.println(Timestamp.valueOf(l[1].split("@")[1].trim()));
		sd.setTimestamp(Timestamp.valueOf(l[1].split("@")[1].trim()));
		return sd;
		
	}
	public String toJsonFromSensorData(SensorData sd) {
		Gson gson=new Gson();
		String Json=gson.toJson(sd);
	//	System.out.println("this is json");
		//System.out.println(Json);
		return Json;
		
	}
	
	public ActuatorData toActuatorDataFromJson(String json) {
		ActuatorData ad=new ActuatorData();
		String[] a= {};
		a=json.replace("{","").replace("}","").replace("\"", "").split(",");
		ad.setCommand(a[0].split(":")[1]);
		ad.setName(a[1].split(":")[1]);
		ad.setCurrentVal(Float.parseFloat(a[2].split(":")[1]));
		
		return ad;		
	}
	public String toJsonFromActuatorData(ActuatorData ad) {
		Gson gson=new Gson();
		String Json=gson.toJson(ad);
		//System.out.println("this is json");
		//System.out.println(Json);
		return Json;
	}
}
