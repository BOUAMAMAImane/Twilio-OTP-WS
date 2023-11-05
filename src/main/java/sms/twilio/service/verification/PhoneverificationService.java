package sms.twilio.service.verification;

import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;
@Service
public class PhoneverificationService {
    private final Map<String, String> otpStorage;

    public PhoneverificationService() {
        this.otpStorage = new HashMap<>();
    }

    public VerificationResult startVerification(String phone) {
        String otp = generateRandomOTP();
        otpStorage.put(phone, otp);
        return new VerificationResult("OTP Sent: " + otp);
    }

    public VerificationResult checkVerification(String phone, String code) {
        String storedOTP = otpStorage.get(phone);
        if (storedOTP != null && storedOTP.equals(code)) {
            otpStorage.remove(phone);
            return new VerificationResult("OTP Verified");
        } else {
            return new VerificationResult("Invalid OTP");
        }
    }

    public String getGeneratedOTP(String phone) {
        return otpStorage.get(phone);
    }

    private String generateRandomOTP() {
        int otpLength = 5;
        StringBuilder otpBuilder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < otpLength; i++) {
            int digit = random.nextInt(10);
            otpBuilder.append(digit);
        }

        return otpBuilder.toString();
    }
}