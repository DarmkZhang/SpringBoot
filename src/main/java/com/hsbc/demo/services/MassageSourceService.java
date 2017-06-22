package com.hsbc.demo.services;

import java.util.Locale;
import java.util.StringTokenizer;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

@Service
public class MassageSourceService {
	private ResourceBundleMessageSource msgSource;
	
	public MassageSourceService(){
		this.msgSource = new ResourceBundleMessageSource();
		this.msgSource.setBasename("i18n/message/message");
	}
	
	public String getMessage(String msgId,Object[] Params,String localeCode){
		StringTokenizer st =  new StringTokenizer(localeCode,"_");
		
		String countryCode = null;
		String languageCode = null;
		if(st.countTokens() >= 2){
			languageCode = st.nextToken();
			countryCode = st.nextToken();
		}else{
			languageCode = "en";
			countryCode = "us";
		}
		Locale curLocale = new Locale(languageCode,countryCode);
		return this.msgSource.getMessage(msgId,Params,curLocale);
	}

}
