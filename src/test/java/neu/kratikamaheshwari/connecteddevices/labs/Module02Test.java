/**
 * 
 */
package neu.kratikamaheshwari.connecteddevices.labs;

import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import neu.kratikamaheshwari.connecteddevices.common.ConfigUtil;
import neu.kratikamaheshwari.connecteddevices.common.SensorData;
import neu.kratikamaheshwari.connecteddevices.labs.module01.SystemMemUtilTask;
import neu.kratikamaheshwari.connecteddevices.labs.module02.TempSensorEmulatorTask;


public class Module02Test
{
/*
 * class scoped variables and objects are created
 */
	
	private ConfigUtil confU;
	private SensorData sensorD;
	private boolean hasConf;
	private float count;
	private float avg;
	private TempSensorEmulatorTask tempSensor;
	private SensorData data;
	/**
	 * values are setup into the variables
	 */
	@Before
	public void setUp() throws Exception
	{
		try {
			this.confU=new ConfigUtil();
			this.sensorD=new SensorData();
			this.hasConf=this.confU.hasConfig();
			this.count=this.sensorD.getCount();
			this.avg=this.sensorD.getAverageValue();
			this.tempSensor=new TempSensorEmulatorTask();
			this.data=tempSensor.getSensorData();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		System.out.println("DONE!!");
	}
	
	/*
	 * it checks for the datatype of hasConf to be boolean, If true test case is passed.
	 */
	
	@Test
	public void testConfigUtil() throws Exception
	{

		try {
		//ConfigUtil confU=new ConfigUtil();
		
		String s=String.valueOf(this.hasConf);
		Assert.assertTrue(Boolean.parseBoolean(s));
	
	}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	/*
	 * it checks for the datatype of curVal to be float, If true test case is passed. 
		Second checks for the avgVal to be within the specified range.If true test case is passed. 
	 */
	
	@Test
	public void testSensorData() throws Exception{
		try {
			
			String s=String.valueOf(this.count);
			Assert.assertTrue(checkF(s));
			Assert.assertTrue(this.avg>=0.0 && this.avg<=30.0);
		} 
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/*
	 * It checks for the datatype of data to be of class type SensorData, If true test case is passed.
	 */
	
	@Test
	public void testTemperatureSensorEmulatorTask() throws Exception {
		try {
			Assert.assertTrue(this.data instanceof SensorData);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public boolean checkF(String s) {
		try {
			Float.parseFloat(s);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
