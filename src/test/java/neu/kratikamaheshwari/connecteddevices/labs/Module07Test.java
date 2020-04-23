/**
 * 
 */
package neu.kratikamaheshwari.connecteddevices.labs;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.labbenchstudios.iot.common.PersistenceUtil;

import neu.kratikamaheshwari.connecteddevices.common.ActuatorData;
import neu.kratikamaheshwari.connecteddevices.common.SensorData;
import neu.kratikamaheshwari.connecteddevices.labs.module05.DataUtil;

/**
 * Test class for all requisite Module07 functionality.
 * 
 * Instructions:
 * 1) Rename 'testSomething()' method such that 'Something' is specific to your needs; add others as needed, beginning each method with 'test...()'.
 * 2) Add the '@Test' annotation to each new 'test...()' method you add.
 * 3) Import the relevant modules and classes to support your tests.
 * 4) Run this class as unit test app.
 * 5) Include a screen shot of the report when you submit your assignment.
 * 
 * Please note: While some example test cases may be provided, you must write your own for the class.
 */
public class Module07Test
{
	SensorData sd=new SensorData();
	DataUtil du=new DataUtil();
	
	String temp=du.toJsonFromSensorData(sd);
	
	
	
	@Test
	public void testJsonFromSensorData()
	{

		Assert.assertTrue(this.temp instanceof String);
	}
	
	@Test
	public void testActToDbms()
	
	{
		ActuatorData ad=new ActuatorData();
		PersistenceUtil pu=new PersistenceUtil();
		Boolean b=pu.writeActuatorDataToDbms(ad);
		Assert.assertTrue(b instanceof Boolean);
	}
	
	
	
}
