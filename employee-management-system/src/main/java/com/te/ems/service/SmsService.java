package com.te.ems.service;

import com.te.ems.dto.SmsDTO;

public interface SmsService {

	boolean sendSms(SmsDTO smsDTO);

}
