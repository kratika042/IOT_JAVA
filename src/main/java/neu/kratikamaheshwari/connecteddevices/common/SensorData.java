package neu.kratikamaheshwari.connecteddevices.common;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class SensorData {
	private Timestamp timestamp=null;
	private String name="Name";
	private float currentValue=0;
	private float averageValue=0;
	private float minValue=0;
	private float maxValue=0;
	private float total=0;
	private float count=0;
	
	public SensorData() {
		LocalDateTime datetime=LocalDateTime.now();
		this.timestamp=Timestamp.valueOf(datetime);
	}
	
	/*
	 * Temperature value is passed to this function and all the variables are calculated.
	 */
    
	public void addValue(float value) {
		this.count+=1;
		this.total+=value;
		this.currentValue=value;
		if(this.maxValue<value) {
			this.maxValue=value;
		}
		if(this.minValue>value) {
			this.minValue=value;
		}
		if(this.count !=0 && this.total>0) {
			this.averageValue=this.total/this.count;
		}
	}

	/*
	 * Getter functions to fetch all the variables.
	 */
	
	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public String getName() {
		return this.name;
	}
	public float getCurrentValue() {
		return this.currentValue;
	}

	public float getAverageValue() {
		return this.averageValue;
	}

	public float getMinValue() {
		return this.minValue;
	}

	public float getMaxValue() {
		return this.maxValue;
	}

	public float getTotal() {
		return this.total;
	}

	public float getCount() {
		return this.count;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrentValue(float currentValue) {
		this.currentValue = currentValue;
	}

	public void setAverageValue(float averageValue) {
		this.averageValue = averageValue;
	}

	public void setMinValue(float minValue) {
		this.minValue = minValue;
	}

	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public void setCount(float count) {
		this.count = count;
	}
	
}
