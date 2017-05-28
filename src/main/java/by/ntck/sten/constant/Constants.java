package by.ntck.sten.constant;

import java.text.SimpleDateFormat;

import by.ntck.sten.model.Kladovshik;

public class Constants {
	public static final Kladovshik EMPTY_KLADOVSHIK = new Kladovshik();
	public static final String EMPTY_ROLE = "GUEST";
	public static final String ROLE_KLADOVSHIK = "KLADOVSHIK";
	public static final String ROLE_ADMINISTRATOR = "ADMINISTRATOR";
	
	public static final int ADMINISTRATOR = 1;
	public static final int KLADOVSHIK = 2;
	
	
	public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd");
     

}
