package com.navi.java8;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Java8DateTest Class
 *
 * @author navi
 * @date 2019-03-27
 * @since 1.0.0
 */
public class Java8DateTest {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("LocalDate.now ： " + now);

        int year = now.getYear();
        int monthValue = now.getMonthValue();
        int dayOfMonth = now.getDayOfMonth();
        System.out.println(year + "-" + monthValue + "-" + dayOfMonth);

        LocalDate localDate = LocalDate.of(2019, 3, 27);
        System.out.println("LocalDate.of(2019, 3, 27): " + localDate);

        System.out.println("今天是2019-3-27吗？ " + localDate.equals(now));
        System.out.println("今天是2019-3-27吗？ " + localDate.compareTo(now));


        LocalDate y2016 = LocalDate.of(2016, 8, 8);
        System.out.println("2016年是闰年吗？" + y2016.isLeapYear());

        System.out.println("2016年是在现在之前？" + y2016.isBefore(now));
        System.out.println("现在是在2016年之后？" + now.isAfter(y2016));


        LocalDate born = LocalDate.of(1990, 12, 7);

        MonthDay birthday = MonthDay.of(born.getMonth(), born.getDayOfMonth());
        LocalDate thisYearBirth = birthday.atYear(2019);
        System.out.println("距离生日还有 " + (thisYearBirth.getDayOfYear() - now.getDayOfYear()) + " 天");

        LocalDate loveMemorialDay = LocalDate.of(2009, 8, 21);

        System.out.println("已经恋爱："+loveMemorialDay.until(now, ChronoUnit.DAYS) + " 天");

        LocalTime nowTime = LocalTime.now();
        System.out.println("现在时间:" + now + " " + nowTime);

        System.out.println("现在是 " + nowTime.getHour() + "点");
        System.out.println("2小时后是 " + nowTime.plusHours(2) + "点");
        System.out.println("2小时前是 " + nowTime.minusHours(2) + "点");

        System.out.println("一个星期后 " + now.plusWeeks(1));
        System.out.println("一年前 " + now.minusYears(1));
        System.out.println("一年后 " + now.plusYears(1));


        Clock clock = Clock.systemUTC();
        System.out.println(clock);
    }
}
