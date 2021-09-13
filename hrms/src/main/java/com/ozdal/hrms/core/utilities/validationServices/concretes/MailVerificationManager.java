package com.ozdal.hrms.core.utilities.validationServices.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ozdal.hrms.core.utilities.validationServices.abstracts.MailVarificationService;

public class MailVerificationManager implements MailVarificationService{

	@Override
	public boolean isRealEMail(String mail) {
		String regex="^(.+)@(.+)$";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=pattern.matcher(mail);
		
		if(matcher.matches()) {
			return true;
		}
		
		return false;
	}

}
