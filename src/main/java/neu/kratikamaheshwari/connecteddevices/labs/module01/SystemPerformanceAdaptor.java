package neu.kratikamaheshwari.connecteddevices.labs.module01;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SystemPerformanceAdaptor {
	/*
	 * util() function of SystemPerformanceAdaptor class manages the calling of CPU and Memory Utilization.
	 * this function is calling getDataFromSensor function of SystemCpuUtilTask and SystemMemUtilTask 10 times to get the 10 records 
	 * of the CPU and Memory Utilization with the interval of 2 seconds.
	 * Logger is set with the level=Level.INFO
	 */
	public  void util() throws Exception{
	for(int i=0;i<10;i++) { 				//loop for calling function 10 times to 10 the 10 log outputs.
		Thread.sleep(2000);
		Logger logger=Logger.getLogger("default");		//object of Logger is created
		double dataCpu,dataMem;
		System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$-4s %5$s %n");		//output format is set.
	
		SystemCpuUtilTask sysCpuUtil=new SystemCpuUtilTask(); 		//object of SystemCpuUtilTask is created
		SystemMemUtilTask sysMemUtil=new SystemMemUtilTask(); 		//object of SystemMemUtilTask is created
		dataCpu=sysCpuUtil.getDataFromSensor();						//getDataFromSensor function is called for CPU Utilization
		dataMem=sysMemUtil.getDataFromSensor(); 					//getDataFromSensor function is called for Memory Utilization
		 
		logger.log(Level.INFO,"CPU Utilization="+dataCpu);			//log is set for CPU Utilization
		logger.log(Level.INFO,"Memory Utilization="+dataMem);		//log is set for Memory Utilization
		
	}
	}
}
