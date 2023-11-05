package sms.twilio.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sms.twilio.Request.SmsRequest;
import sms.twilio.service.SmsSender;
import sms.twilio.service.impl.SmsSenderImpl;
import sms.twilio.service.verification.PhoneverificationService;
import sms.twilio.service.verification.VerificationResult;
@RestController
@RequestMapping("/lo")
public class SmsController {
	@Autowired
	private SmsSender smsSender; // Utilisez l'interface SmsSender au lieu de SmsSenderImpl
	@Autowired
	private PhoneverificationService phoneVerificationService;

	@PostMapping("/sendSms")
	public ResponseEntity<Object> sendSms(@RequestBody SmsRequest request) {
		return smsSender.sendSms(request);
	}

	@PostMapping("/sendotp")
	public ResponseEntity<String> sendOtp(@RequestBody SmsRequest phone) {
		System.out.println(phone.getPhoneNumber());
		VerificationResult result = phoneVerificationService.startVerification(phone.getPhoneNumber());
		System.out.println(result.toString());
		if (result.isValid()) {
			return new ResponseEntity<>("OTP Sent..", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("OTP failed to send..", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getotp")
	public ResponseEntity<String> getOtp(@RequestParam("phone") String phoneNumber) {
		String otp = phoneVerificationService.getGeneratedOTP(phoneNumber);
		if (otp != null) {
			return new ResponseEntity<>(otp, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("No OTP available", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/verifyotp")
	public ResponseEntity<String> verifyOtp(@RequestBody SmsRequest phone, @RequestParam("otp") String otp) {
		VerificationResult result = phoneVerificationService.checkVerification(phone.getPhoneNumber(), otp);
		if (result.isValid()) {
			return new ResponseEntity<>("Your number is verified", HttpStatus.OK);
		}
		return new ResponseEntity<>("Something went wrong/OTP incorrect", HttpStatus.BAD_REQUEST);
	}
}
