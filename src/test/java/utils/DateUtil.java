package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDate getNextDay(int dateToAdd) {
        return LocalDate.now().plusDays(dateToAdd);
    }

    public static String getNextDayNumber(int dateToAdd) {
        return String.valueOf(getNextDay(dateToAdd).getDayOfMonth());
    }

}
