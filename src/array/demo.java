package array;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Integer chargeTime = getChargeTime(new Date());

        System.out.println(chargeTime);

    }


    public static Integer getChargeTime(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,3);
        Date time = calendar.getTime();
        return getDateInt(time);
    }

    public static Integer getDateInt(Date date) {
        String format = format(date, "yyyyMMdd");
        return Integer.valueOf(format);
    }

    public static String format(Date date, String pattern) {
        return format(date, pattern, ZoneId.systemDefault());
    }
    public static String format(Date date, String pattern, ZoneId zoneId) {
        if (date == null) {
            return "";
        }
        return DateTimeFormatter.ofPattern(pattern).format(LocalDateTime.ofInstant(date.toInstant(), zoneId));
    }
}

