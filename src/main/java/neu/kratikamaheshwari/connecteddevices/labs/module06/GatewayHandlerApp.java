package neu.kratikamaheshwari.connecteddevices.labs.module06;

public class GatewayHandlerApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread(new TempSensorEmulatorTask());
		thread1.start();
	}

}
