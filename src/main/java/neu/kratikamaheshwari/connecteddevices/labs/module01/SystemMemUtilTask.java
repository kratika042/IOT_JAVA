package neu.kratikamaheshwari.connecteddevices.labs.module01;

import java.lang.management.ManagementFactory;
import com.sun.management.OperatingSystemMXBean;

public class SystemMemUtilTask {
	/*
	 * getDataFromSensor() function of SystemMemUtilTask class returns the average Physical Memory Utilization of the system.
	 */
	
	public double getDataFromSensor() {
		OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);	
		return(osBean.getTotalPhysicalMemorySize()-osBean.getFreePhysicalMemorySize())*100/osBean.getTotalPhysicalMemorySize();
		//Memory Utilization is calculated using OperatingSystemMXBean package .
		
	}

}
