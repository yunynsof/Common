package hn.com.tigo.josm.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class SafeSimpleDateFormat {

	private static final ThreadLocal<SimpleDateFormat> FORMATTER = new ThreadLocal<SimpleDateFormat>() {
		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		}
	};

	public static Date parse(final String date) throws ParseException {
		return FORMATTER.get().parse(date);
	}

}
