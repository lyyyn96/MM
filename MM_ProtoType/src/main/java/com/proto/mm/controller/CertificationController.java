package com.proto.mm.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.proto.mm.service.CertificationService;

@Controller
public class CertificationController {
	
	@Autowired
	private CertificationService certificationService;
	
	@GetMapping("sendSMS")
	@ResponseBody
	public String sendSMS(Model model,HttpServletRequest request,
			HttpServletResponse response) {

		String phoneNumber = (String) request.getAttribute("phoneNumber");
		Random rand = new Random();
		String numStr = "";
		for (int i = 0; i < 4; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}

		System.out.println("수신자 번호 : " + phoneNumber);
		System.out.println("인증번호 : " + numStr);
		certificationService.certifiedPhoneNumber(phoneNumber, numStr);
		return numStr;
	}
}
