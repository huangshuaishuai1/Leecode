package base;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class time {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        Date date = Date.from(now.atStartOfDay(ZoneId.systemDefault()).toInstant());
        System.out.println(date);
    }
}
