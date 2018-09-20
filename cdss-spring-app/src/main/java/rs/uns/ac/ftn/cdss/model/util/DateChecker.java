package rs.uns.ac.ftn.cdss.model.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateChecker {

	public DateChecker() {
	}

	public Date last14Days() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_MONTH, -14);
		Date res = cal.getTime();

		return res;
	}

	public Date last21Days() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_MONTH, -21);
		Date res = cal.getTime();

		return res;
	}

	public Date last60Days() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.DAY_OF_MONTH, -60);
		Date res = cal.getTime();

		return res;
	}

	public Date last6Months() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.MONTH, -6);
		Date res = cal.getTime();

		return res;
	}

	public Date last12Months() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.YEAR, -1);
		Date res = cal.getTime();

		return res;
	}

	public Date moreThan6Months() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.MONTH, -6);
		Date res = cal.getTime();

		return res;
	}

	public Date last2Years() {
		Date now = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(now);
		cal.add(Calendar.YEAR, -2);
		Date res = cal.getTime();

		return res;
	}

}
