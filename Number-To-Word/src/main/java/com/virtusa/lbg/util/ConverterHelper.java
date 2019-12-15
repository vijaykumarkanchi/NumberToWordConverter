package com.virtusa.lbg.util;

public class ConverterHelper {

	public static final String units[] = { "", " one", " two", " three", " four", " five", " six", " seven", " eight",
			" nine", " ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " fifteen", " sixteen", " seventeen",
			" eighteen", " nineteen" };

	public static final String tens[] = { "", "", " twenty", " thirty", " forty", " fifty", " sixty", " seventy",
			" eighty", " ninety" };

	public static final String higherPlace[] = { " million", " thousand", " hundred", "" };

	public static String appendAND(int n, StringBuilder sb1, StringBuilder sb2) {

		if ((sb1.length() > 0 || sb2.length() > 0) && n > 0) {
			return " and";
		} else {
			return "";
		}

	}

}
