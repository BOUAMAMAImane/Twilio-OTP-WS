package sms.twilio.service;

import org.springframework.http.ResponseEntity;

import sms.twilio.Request.SmsRequest;

public interface SmsSender {

	ResponseEntity<Object> sendSms(SmsRequest smsRequest);

}
