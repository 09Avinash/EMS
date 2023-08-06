package com.te.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.dto.SmsDTO;
import com.te.ems.exception.MessageNotSentException;
import com.te.ems.response.SuccessResponse;
import com.te.ems.service.SmsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/sms")
@RestController
public class SmsController {

	private final SmsService smsService;

	@PostMapping("/send")
	public ResponseEntity<SuccessResponse<String>> sendSms(@RequestBody SmsDTO smsDTO) {
		if (smsService.sendSms(smsDTO)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(SuccessResponse.<String>builder()
					.data("Message Sent Successfully").message("FAST2SMS DONE").build());
		}
		throw new MessageNotSentException("Message Not Sent");

	}

}
