/**
 * 
 */
package neu.kratikamaheshwari.connecteddevices.labs;
//import org.junit.After;
//import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;
import neu.kratikamaheshwari.connecteddevices.labs.module01.SystemCpuUtilTask;
import neu.kratikamaheshwari.connecteddevices.labs.module01.SystemMemUtilTask;

 //This is testing module having 2 functions which will test the cases for CPU and Memory Utilization outputs. 
public class Module01Test
{
	
	/*
	 * This function tests the outcomes of Memory Utilization.
	 * 1. Case 1 is that it will check for the output to be of data type double.
	 * 2. Case 2 is that it will check for the output should be within the range 0.0 to 100.0
	 * test case will pass if the condition is true.
	 */
	
	@Test
	public void testMemUtil() throws Exception
	{

		try {
		SystemMemUtilTask sysmem=new SystemMemUtilTask();
		String s=String.valueOf(sysmem.getDataFromSensor());
		Assert.assertTrue(checkDouble(s));
	
		Assert.assertTrue(sysmem.getDataFromSensor()>=0 && sysmem.getDataFromSensor()<=100);
	}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	/*
	 * This function tests the outcomes of CPU Utilization.
	 * 1. Case 1 is that it will check for the output to be of data type double.
	 * 2. Case 2 is that it will check for the output should be within the range 0.0 to 100.0
	 * test case will pass if the condition is true.
	 */
	
	@Test
	public void testCpuUtil()
	{

		SystemCpuUtilTask syscpu=new SystemCpuUtilTask();
		String s=String.valueOf(syscpu.getDataFromSensor());
		Assert.assertTrue(checkDouble(s));
		Assert.assertTrue(syscpu.getDataFromSensor()>=0 && syscpu.getDataFromSensor()<=100);
	}
	
	// This function is called to convert the String value into type double.
	
	boolean checkDouble(String str) {
		try {
		Double.parseDouble(str);
		return true;
	}
		catch (Exception e) {
			return false;
		}
}
}