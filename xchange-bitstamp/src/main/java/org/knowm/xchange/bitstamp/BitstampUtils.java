package org.knowm.xchange.bitstamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.knowm.xchange.exceptions.ExchangeException;

/**
 * A central place for shared Bitstamp properties
 */
public final class BitstampUtils {

  public static final int MAX_TRANSACTIONS_PER_QUERY = 1000;
  private static final SimpleDateFormat DATE_FORMAT;

  static {
    DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    DATE_FORMAT.setTimeZone(TimeZone.getTimeZone("UTC"));
  }

  /**
   * private Constructor
   */
  private BitstampUtils() {

  }

  /**
   * Format a date String for Bitstamp
   *
   * @param dateString A {@code String} whose beginning should be parsed.
   * @return A {@link Date}
   */
  public static Date parseDate(String dateString) {

    try {
      return dateString == null ? null : DATE_FORMAT.parse(dateString);
    } catch (ParseException e) {
      throw new ExchangeException("Illegal date/time format", e);
    }
  }

}
