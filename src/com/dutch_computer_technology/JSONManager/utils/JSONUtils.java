package com.dutch_computer_technology.JSONManager.utils;

/**
 * Utils
 */
public class JSONUtils {
	
	/**
	 * Returns the current version of the JSONManager
	 * 
	 * @return Version of the JSONManager
	 */
	public static String version() {
		
		return "3.1.0";
		
	};
	
	/**
	 * Returns ammount of tabs
	 * 
	 * @param tabs The ammount needed.
	 * @return The ammount of tabs needed.
	 */
	public static String tabs(int tabs) {
		
		if (tabs <= 0) return "";
		
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < tabs; i++) str.append("\t");
		return str.toString();
		
	};
	
	/**
	 * Remove special characters before parsing,<br>
	 * Tabs Spaces Newlines
	 * 
	 * @param str String to be sanitized
	 * @return Sanitized String ready to parse
	 */
	public static String sanitize(String str) {
		
		str = str.replaceAll("[\n|\b|\f|\r|\t]", "");
		StringBuilder sanitized = new StringBuilder();
		char quot = 0;
		for (char chr : str.toCharArray()) {
			
			if (chr == ' ' && quot == 0) continue;
			if (chr == '"' || chr == '\'') {
				
				if (quot == 0) {
					
					quot = chr;
					
				} else {
					
					quot = 0;
					
				};
				chr = '"';
				
			};
			sanitized.append(chr);
			
		};
		return sanitized.toString();
		
	};
	
	/**
	 * Escapes special characters for use in JSON
	 * 
	 * @param str String to be escaped
	 * @return Escaped String
	 */
	public static String escape(String str) {
		
		str = str.replace("\\", "\\\\");
		str = str.replace("/", "\\/");
		str = str.replace("\"", "\\\"");
		str = str.replace("\n", "\\n");
		str = str.replace("\b", "\\b");
		str = str.replace("\f", "\\f");
		str = str.replace("\r", "\\r");
		str = str.replace("\t", "\\t");
		return str;
		
	};
	
	/**
	 * Unescapes special characters after loaded from JSON
	 * 
	 * @param str String to be unescaped
	 * @return Unescaped String
	 */
	public static String unescape(String str) {
		
		str = str.replace("\\\\", "\\");
		str = str.replace("\\/", "/");
		str = str.replace("\\\"", "\"");
		str = str.replace("\\n", "\n");
		str = str.replace("\\b", "\b");
		str = str.replace("\\f", "\f");
		str = str.replace("\\r", "\r");
		str = str.replace("\\t", "\t");
		return str;
		
	};
	
};