package neu.kratikamaheshwari.connecteddevices.labs.module01;

public class GatewayHandlerApp {
	/*
	 * This class initializes SystemPerformaceAdaptor. 
	 * Here, object of SystemPerformanceAdaptor class is created and util() function is called.
	 * 
	 */
	public static void main(String[] args) {
		SystemPerformanceAdaptor sysAdaptor=new SystemPerformanceAdaptor();
		try {
		sysAdaptor.util();			//util() function is called by the object of class SystemPerformanceAdaptor
	}
		catch (Exception e) {
		}
	}
}