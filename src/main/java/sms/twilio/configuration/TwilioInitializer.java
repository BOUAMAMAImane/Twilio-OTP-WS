package sms.twilio.configuration;

import org.slf4j.Logger;
import com.twilio.rest.verify.v2.Service;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import com.twilio.Twilio;

@Configuration
public class TwilioInitializer {
	private final static Logger  LOGGER =  LoggerFactory.getLogger(TwilioInitializer.class);
	private final TwilioConfig twilioConfig;

	@Autowired
	public TwilioInitializer(TwilioConfig twilioConfig) {
		this.twilioConfig = twilioConfig;
		Twilio.init(twilioConfig.getAccountSid(), twilioConfig.getAuthToken());
		LOGGER.info("Twilio has been initialized with account sid {}",twilioConfig.getAccountSid());
	}
}
