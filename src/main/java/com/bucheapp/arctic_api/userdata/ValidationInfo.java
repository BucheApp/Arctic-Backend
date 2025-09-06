package com.bucheapp.arctic_api.userdata;

public class ValidationInfo {
	public static final int USERNAME_MIN = 1;
	public static final int USERNAME_MAX = 30;
	public static final String USERNAME_REGEX = "^[!'()\\-=~`*:?\\p{L}\\p{M}\\p{N}]*$";
	
	public static final int EMAIL_MIN = 1;
	public static final int EMAIL_MAX = 255;
	public static final String EMAIL_REGEX = "^[a-zA-Z0-9@]*$";
	
	public static final int PASSWORD_MIN = 8;
	public static final int PASSWORD_MAX = 18;
	public static final String PASSWORD_REGEX = "^[a-zA-Z0-9_]*$";
}
