package neu.kratikamaheshwari.connecteddevices.common;
import java.io.File;
import java.io.IOException;

import java.util.*;

import org.ini4j.Ini;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;
import org.ini4j.Profile.Section;

public class ConfigUtil
{
	private String filePath="";
	private Map<String,String> map=new HashMap<String, String>();
	private static ConfigUtil instance;
	
	/*
	 * filepath is set and loadConfig method is called.
    
	 */
	public ConfigUtil() throws InvalidFileFormatException, IOException {
		this.filePath="C:/workspace/iot-gateway/config/ConnectedDevicesConfig.props";
		this.loadConfig(filePath);
	}
	/*
	 * This function checks for the existence of the file.
	 */
	public boolean hasConfig() {
		File file=new File(this.filePath);
		if(file.exists()) {
			return true;
		}
		return false;
	}
	
	/*
	 * This function loads the value of all the required variables of config file and store in a Hashmap.
	 */
	public boolean loadConfig(String path) throws InvalidFileFormatException, IOException {
		if(this.hasConfig()) {
			Ini ini=new Wini();
			ini.getConfig().setMultiSection(true);
			ini.load(new File(path));
			List<Section> sec=ini.getAll("smtp.cloud");
			  String host="";
			  String port="";
			  String token="";
			  String fromAddr="";
			  String toAddr="";
			  for (Section section : sec) {
					host=section.fetch("host");
					port=section.fetch("port");
					fromAddr=section.fetch("fromAddr");
					toAddr=section.fetch("toAddr");
					token=section.fetch("authToken");
				}
			  map.put("host", host);
			  map.put("port", port);
			  map.put("token", token);
			  map.put("fromAddr", fromAddr);
			  map.put("toAddr", toAddr);
			  return true;
		}
		else {
			System.out.println("File not found!!");
			return false;
		}
	}
	/*
	 * getter function for the Map.
	 */
	public Map<String,String> getSMTP(){
		return map;
		
	}
	public static ConfigUtil getInstance() {
		if(instance==null) {
			try {
				instance= new ConfigUtil();
			} catch (InvalidFileFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
}

