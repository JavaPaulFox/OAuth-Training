package com.samsung.training.oauth2.utility;

public class TryParseHelper {

	public  static boolean tryParseLong(String value) {
		try {
			Long.parseUnsignedLong(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
