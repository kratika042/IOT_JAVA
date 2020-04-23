package neu.kratikamaheshwari.connecteddevices.labs.module05;

import com.labbenchstudios.iot.common.PersistenceUtil;

import neu.kratikamaheshwari.connecteddevices.common.ActuatorData;
import neu.kratikamaheshwari.connecteddevices.common.SensorData;
public class SensorDataManager {
	private ActuatorData actDataNew=new ActuatorData();
	private ActuatorData actDataOld=new ActuatorData();
	private PersistenceUtil pu=new PersistenceUtil();
	private float nomTemp=15;
	public ActuatorData handleSensorData(SensorData sensorData) {
	
		actDataOld=pu.getActuatorDataFromDbms();
		
        //System.out.println(sensorData.getAverageValue());    
        this.actDataNew.setName(sensorData.getName());
      //  System.out.println(this.actData.getName());
        this.actDataNew.setCurrentVal(sensorData.getCurrentValue());
        if((this.actDataOld.getCurrentVal()-5.0)<sensorData.getCurrentValue() && sensorData.getCurrentValue()<(this.actDataOld.getCurrentVal()+5.0)) {
        	this.actDataNew.setCommand("NEUTRAL");
        }
        else if(sensorData.getCurrentValue()<(this.actDataOld.getCurrentVal()+6.0)) {
        	this.actDataNew.setCommand("TEMP DEC");
        }
        else if(sensorData.getCurrentValue()>(this.actDataOld.getCurrentVal()+6.0)) {
        	this.actDataNew.setCommand("TEMP INC");
        }
        return this.actDataNew;
	}
	
}
