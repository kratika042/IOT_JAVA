package neu.kratikamaheshwari.connecteddevices.common;

public class ActuatorData {
	private String command;
	private String name;
	private float currentVal;
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getCurrentVal() {
		return currentVal;
	}
	public void setCurrentVal(float currentVal) {
		this.currentVal = currentVal;
	}
	public static byte[] getBytes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
