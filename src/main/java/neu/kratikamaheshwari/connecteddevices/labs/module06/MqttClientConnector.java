package neu.kratikamaheshwari.connecteddevices.labs.module06;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import neu.kratikamaheshwari.connecteddevices.common.ActuatorData;
import neu.kratikamaheshwari.connecteddevices.labs.module05.DataUtil;

public class MqttClientConnector implements MqttCallback{
	DataUtil t=new DataUtil();
	MqttClient  myClient;
	MqttConnectOptions connOpt;
	static final String BROKER_URL="tcp://127.0.0.1:1883";
	static final String M2MIO_THING="JAVA";
	public MqttClientConnector() {
		// TODO Auto-generated constructor stub
		String clientID=M2MIO_THING;
		connOpt=new MqttConnectOptions();
		connOpt.setCleanSession(true);
		connOpt.setKeepAliveInterval(30);
		try {
			myClient=new MqttClient(BROKER_URL, clientID);
			myClient.setCallback(this);
			myClient.connect(connOpt);
		}
		catch(MqttException e) {
			e.printStackTrace();
			System.exit(-1);
			
		}
		System.out.println("Connected to "+BROKER_URL);
	}
	
	public void publish_actuator_data(ActuatorData adata_input, String topic_name) {
		String myTopic=topic_name;
		String AData=t.toJsonFromActuatorData(adata_input);
		int pubQos=1;
		MqttMessage message=new MqttMessage(adata_input.getBytes());
		message.setQos(pubQos);
		message.setRetained(false);
		System.out.println("Pub to topic \""+ myTopic + "\" qos "+pubQos);
	}
	
	public void subscribe_sensor_data(String input_field) throws MqttException{
		int subQos=0;
		try {
			myClient.subscribe(input_field,subQos);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void connectionLost(Throwable cause) {
		System.out.println("conn lost");
		
	}

	public void messageArrived(String topic, MqttMessage message) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("---");
		
	}

	public void deliveryComplete(IMqttDeliveryToken token) {
		// TODO Auto-generated method stub
		
	}

}
