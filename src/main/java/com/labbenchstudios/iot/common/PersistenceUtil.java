package com.labbenchstudios.iot.common;

import neu.kratikamaheshwari.connecteddevices.common.ActuatorData;
import neu.kratikamaheshwari.connecteddevices.labs.module05.DataUtil;
import redis.clients.jedis.Jedis;
public class PersistenceUtil {
	Jedis jed=new Jedis("localhost");
	public boolean writeActuatorDataToDbms(ActuatorData ad) {
		DataUtil du=new DataUtil();
		String json=du.toJsonFromActuatorData(ad);
		jed.set("Actuator_Data", json);
		System.out.println(jed.get("Actuator_Data"));
		return true;
	}
	
	public ActuatorData getActuatorDataFromDbms() {
		String ad=jed.get("Actuator_Data");
		if(ad!=null) {
		DataUtil du=new DataUtil();
		
		return(du.toActuatorDataFromJson(ad));
	}
		return null;
	}
}
