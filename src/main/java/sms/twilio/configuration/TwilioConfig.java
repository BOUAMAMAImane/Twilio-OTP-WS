package sms.twilio.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
@Configuration @ConfigurationProperties("twilio")
public class TwilioConfig {
	private  String accountSid ;
	private  String authToken ;
	private  String serviceId ;
	private  String trialNumber ;
	
	
	
}
