package neu.kratikamaheshwari.connecteddevices.labs.module02;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.ini4j.InvalidFileFormatException;

import neu.kratikamaheshwari.connecteddevices.common.ConfigUtil;

public class SmtpClientConnector {
	private Map<String, String> map=new HashMap<String,String>();
	private String host="";
	private String port="";
	private String token="";
	private String toAddr="";
	private String fromAddr="";
	final String username = "kratikacd@gmail.com";
    final String password = "xmonzwchpachvvql";
    /*
     * This function is called if the trigger value reaches, all the required values for connection
     are fetched from ConfigUtil class, and email format is created and sent to the receiver.
    
     */
	public void connector() throws InvalidFileFormatException, IOException {
		ConfigUtil confU=new ConfigUtil();
		this.map=confU.getSMTP();
		this.host=map.get("host");
		this.port=map.get("port");
		this.token=map.get("token");
		this.toAddr=map.get("toAddr");
		this.fromAddr=map.get("fromAddr");
		
		Properties p = new Properties();
		p.put("mail.smtp.host", host);
        p.put("mail.smtp.port", port);
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true"); 
        Session session = Session.getInstance(p,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromAddr));
           
            msg.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toAddr+","+fromAddr)
            );
            msg.setSubject("Temperature Alert");
            msg.setText("Current temperature value exceeds the average temperature value.");
           
            Transport.send(msg);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	}
