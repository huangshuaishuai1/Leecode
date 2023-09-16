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
        try{
            Scanner scanner = new Scanner(System.in);
            int num = scanner.nextInt();
            System.out.println("A");
        }catch (NullPointerException e){
            System.out.println("B");
        }finally {
            System.out.println("C");
        }
    }
}

