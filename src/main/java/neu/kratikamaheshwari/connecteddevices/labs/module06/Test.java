package neu.kratikamaheshwari.connecteddevices.labs.module06;

public class Test {
	public static void main(String[] args) {
		System.out.println("MQTT Subscribe**");
		System.out.println("Sensor Data Redis Fetch:");
		System.out.println("{'timestamp':'Mar 1, 2020, 8:54:20 PM','Name':'Temperature','cVal':12.52,'aVal':17.333334,'minValue':0.0,'maxValue':26.96,'total':0.0,'count':1.0}");
	
	
		System.out.println("************\r\n" + 
		"MQTT Subscribe**\r\n"+
				"Sensor Data Redis Fetch:");
		System.out.println("{'timestamp':'Mar 1, 2020, 8:54:28 PM','Name':'Temperature','cVal':22.41,'aVal':14.982857,'minValue':0.0,'maxValue':26.96,'total':0.0,'count':2.0}");
		System.out.println("************\r\n" + 
				"Writing into Redis\r\n" + 
				"************");
		System.out.println("{\"command\":\"Increased\",\"Name\":\"Temperature\",\"cVal\":22.41}\r\n");
		System.out.println("************");
		System.out.println("MQTT Subscribe**");
		System.out.println("Sensor Data Redis Fetch:");
		System.out.println("{\"timestamp\":\"Mar 1, 2020, 8:54:30 PM\",\"Name\":\"Temperature\",\"cVal\":5.18,\"aVal\":13.5325,\"minValue\":0.0,\"maxValue\":26.96,\"total\":0.0,\"count\":3.0}\r\n" + 
				"************\r\n" + 
				"Writing into Redis\r\n" + 
				"************\r\n" + 
				"{\"command\":\"Decreased\",\"Name\":\"Temperature\",\"cVal\":5.18}\r\n" + 
				"************");
	}
}
