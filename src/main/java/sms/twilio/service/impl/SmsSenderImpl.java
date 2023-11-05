package sms.twilio.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

import sms.twilio.Request.SmsRequest;
import sms.twilio.configuration.TwilioConfig;
import sms.twilio.configuration.TwilioInitializer;
import sms.twilio.service.SmsSender;

import java.util.Random;

@Service
public class SmsSenderImpl implements SmsSender {
	private String otp;
	private final static Logger LOGGER = LoggerFactory.getLogger(SmsSenderImpl.class);

	@Override
	public ResponseEntity<Object> sendSms(SmsRequest smsRequest) {
		return new ResponseEntity<>("OTP Not Sent. SMS sending is not supported.", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> generateOtp() {
		otp = generateRandomOTP();
		LOGGER.info("OTP Generated: {}", otp);
		return new ResponseEntity<>("OTP Generated: " + otp, HttpStatus.OK);
	}

	private String generateRandomOTP() {
		int otpLength = 6; // Length of the OTP

		// Generate a random OTP using random digits
		StringBuilder otpBuilder = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < otpLength; i++) {
			int digit = random.nextInt(10); // Generate a random digit between 0 and 9
			otpBuilder.append(digit);
		}

		return otpBuilder.toString();
	}

	public String getOtp() {
		if (otp != null) {
			return otp;
		} else {
			return "No OTP available";
		}
	}
}

