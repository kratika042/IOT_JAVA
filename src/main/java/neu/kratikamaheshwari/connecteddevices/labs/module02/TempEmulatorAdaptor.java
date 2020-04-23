package neu.kratikamaheshwari.connecteddevices.labs.module02;

import java.io.IOException;

import org.ini4j.InvalidFileFormatException;

//In constructor, object of TempSensorEmulatorTask is created and temperatureGenerator function is called.

public class TempEmulatorAdaptor {

	public TempEmulatorAdaptor() throws InvalidFileFormatException, IOException {
		TempSensorEmulatorTask tempSensor=new TempSensorEmulatorTask();
		tempSensor.temperatureGenerator();
	}
}
