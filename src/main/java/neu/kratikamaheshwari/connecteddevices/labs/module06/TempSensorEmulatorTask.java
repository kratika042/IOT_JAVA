package neu.kratikamaheshwari.connecteddevices.labs.module06;

import org.eclipse.paho.client.mqttv3.MqttException;

import redis.clients.jedis.Jedis;

public class TempSensorEmulatorTask implements Runnable{

	Jedis jedis=new Jedis("127.0.0.1");
	MqttClientConnector mqc=new MqttClientConnector();

	public void run() {
		// TODO Auto-generated method stub
		try {
			mqc.subscribe_sensor_data("Sensor Data");
		}
		catch(MqttException e) {
			e.printStackTrace();
		}
	}
	
}
