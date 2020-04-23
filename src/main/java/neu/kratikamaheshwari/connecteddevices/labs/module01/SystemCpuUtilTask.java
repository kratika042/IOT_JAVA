package neu.kratikamaheshwari.connecteddevices.labs.module01;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
public class SystemCpuUtilTask {
	/*
	 * getDataFromSensor() function of SystemCpuUtilTask class returns the average CPU Utilization of the system.
	 */
	public  double getDataFromSensor() {
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);	
		return(Math.round(osBean.getSystemCpuLoad()*100));		//CPU utilization is calculated using OperatingSystemMXBean package
	}
}
