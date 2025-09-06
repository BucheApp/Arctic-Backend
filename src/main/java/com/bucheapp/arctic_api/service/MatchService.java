package com.bucheapp.arctic_api.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class MatchService {	
	public String match(String s,int min,int max,String regex) {
		String message = "";
		
		if(s.isEmpty()) {
			message = "入力してください";
		} else if(s.length() < min) {
			message = min + "文字以上にしてください";
		} else if(s.length() > max) {
			message = max + "文字以下にしてください";
		} else if(!Pattern.matches(regex, s)) {
			message = "指定の表記にマッチしませんでした";
		} else {
			message = "OK!";
		}
		
		return message;
	}
}
