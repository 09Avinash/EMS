package com.te.ems.service;

import org.springframework.stereotype.Service;

import com.te.ems.dto.SmsDTO;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@Service
public class SmsServiceImpl implements SmsService {

	@Override
	public boolean sendSms(SmsDTO smsDTO) {
	

		HttpResponse<String> response = Unirest.post("https://www.fast2sms.com/dev/bulkV2")
				.header("authorization",
						"D1vh02YTbSOAxEwyBZsziNIRJ9VgWm5ljG8tqFQnXCkor63U4HJOqPeNifj62ZWT1RVElUB5XvDogMcs")
				.header("Content-Type", "application/x-www-form-urlencoded")
				.body("message=" + smsDTO.getMessage() + "&language=english&route=q&numbers=" + smsDTO.getNumbers())
				.asString();

		int status = response.getStatus();
		String body = response.getBody();
		System.out.println("Response Status: " + status);
		System.out.println("Response Body: " + body);
		return true;

	}

}
