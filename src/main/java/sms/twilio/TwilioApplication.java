
package sms.twilio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwilioApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwilioApplication.class, args);
	}
}
/*
package sms.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sms.twilio.Request.SmsRequest;
import sms.twilio.configuration.TwilioConfig;
import sms.twilio.service.SmsSender;

@SpringBootApplication
public class TwilioApplication implements CommandLineRunner {
	private final SmsSender smsSender;
	private final TwilioConfig twilioConfig;

	@Autowired
	public TwilioApplication(SmsSender smsSender, TwilioConfig twilioConfig) {
		this.smsSender = smsSender;
		this.twilioConfig = twilioConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(TwilioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		SmsRequest smsRequest = new SmsRequest("123456789", "123456"); // Remplacez "123456789" par le numéro de téléphone et "123456" par le code OTP réel
		smsSender.sendSms(smsRequest);
	}
}

*/
