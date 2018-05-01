package com.company;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LocalDateTimeDemo {

    public static void main(String[] args) {

        LocalDate date = LocalDate.of(2000, 1, 1);
        LocalTime time = LocalTime.of(23, 59, 59);

        LocalDateTime january2000 = LocalDateTime.of(date, time);
        System.out.println(january2000);

        LocalDateTime august2018 = LocalDateTime.of(
                2018,
                Month.AUGUST,
                8,
                11,
                22,
                1);

        System.out.println(august2018);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getLong(ChronoField.DAY_OF_YEAR));

        LocalDateTime plus = now.plus(2, ChronoUnit.CENTURIES);
        System.out.println(plus);

        String stringDateTime = "Nov 3, 2015 $$ 11:45";

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter
                .ofPattern("MMM d, yyyy $$ HH:mm");

        LocalDateTime dateTimeFromString = LocalDateTime.parse(stringDateTime, dateTimeFormatter);
        System.out.println(dateTimeFromString);

        //Date -> Instant -> LocalDateTime
        //Date <- Instant <- ZonedDateTime <- LocalDateTime
        Date originalDate = new Date();
        LocalDateTime localDateTimeFromDate = LocalDateTime.ofInstant(originalDate.toInstant(), ZoneId.systemDefault());
        System.out.printf("LocalDateTime form java.util.Date: %s%n", localDateTimeFromDate);
        now = LocalDateTime.now();

        ZonedDateTime zonedDateTime = now.atZone(ZoneId.systemDefault());
        Instant instant = zonedDateTime.toInstant(); /*  now.toInstant(ZoneOffset.of("+02:00"));  */
        Date fromLocalTimeZone = Date.from(instant);

        System.out.printf("java.util.Date: %s %n", fromLocalTimeZone);
        now.plus(Period.ofDays(1));
        now.plus(Duration.ofSeconds(11));


        int days = Period.between(LocalDate.now(), LocalDate.now().plus(Period.ofWeeks(1))).getDays();
        System.out.println(days);
        long seconds = Duration.between(LocalTime.now(), LocalTime.now().plus(Duration.ofHours(10))).getSeconds();
        System.out.println(seconds);
    }
}
