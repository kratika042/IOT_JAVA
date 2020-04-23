package neu.kratikamaheshwari.connecteddevices.labs.module02;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.ini4j.InvalidFileFormatException;

import neu.kratikamaheshwari.connecteddevices.common.SensorData;

public class TempSensorEmulatorTask {
		SensorData sensorData=new SensorData();
		private float currentValue=0;
		private float total=0;
		private float count=0;
		private float minValue=0;
		private float maxValue=0;
		private float avgValue=0;
		private float threshold=5;
		private Timestamp timestamp=null;
		
		/*
		 * Email will be sent according to the difference in current and average temperature values
        logging info is also generated.
		 */
		public void sendNotification() throws InvalidFileFormatException, IOException {
			Logger logger=Logger.getLogger("default");
			System.setProperty("java.util.logging.SimpleFormatter.format", "%4$-4s %5$s %n");
			if(Math.abs(this.currentValue-this.avgValue)>this.threshold) {
				logger.log(Level.INFO,"\nCurrent temperature exceeds average by " + Math.round(Math.abs(this.currentValue-this.avgValue))+"\nSENDING EMAIL...");
				SmtpClientConnector smtp=new SmtpClientConnector();
				smtp.connector();
				}
			
			String data="Temperature:\nTime:    "+this.timestamp+"\nCurrent:    "+this.currentValue+"\nAverage:    "+this.avgValue+"\nSamples:    "+this.count+"\nMin:    "+this.minValue+"\nMax:    "+this.maxValue  ;  
            logger.log(Level.INFO,data);
			System.out.println("********************");
			
			}
		
		/*
		 * fetch data from SensorData class, hence create an object of that class and fetch the variables using 
        getter functions.
		 */
		
		public SensorData getSensorData() {
			this.avgValue=this.sensorData.getAverageValue();
			this.count=this.sensorData.getCount();
			this.currentValue=this.sensorData.getCurrentValue();
			this.maxValue=this.sensorData.getMaxValue();
			this.minValue=this.sensorData.getMinValue();
			this.total=this.sensorData.getTotal();
			this.timestamp=this.sensorData.getTimestamp();
			return this.sensorData;
		}
		
		/*
		 * Random temperature value is generated and it is passed in the addValue function of SensorData class.
    	After getting all the values sendNotification function is called and thread is sleep for 2 seconds.
    
		 */
		public void temperatureGenerator() throws InvalidFileFormatException, IOException {
			for (int i=0;i<10;i++) {
				Random r=new Random();
				float val=r.nextInt(30);
				this.sensorData.addValue(val);
				this.getSensorData();
				this.sendNotification();
				
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
}
