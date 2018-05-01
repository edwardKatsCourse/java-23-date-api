package com.company;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class TimeDemo {

    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        System.out.println(now);


//        for (String zone : ZoneId.getAvailableZoneIds()) {
//            if (zone.startsWith("America/New_York")) {
//                System.out.println(zone);
//            }
//        }

        ZoneId newYorkZone = ZoneId.of("America/New_York");
        LocalTime newYorkTime = LocalTime.now(newYorkZone);
        System.out.printf("New York Time is: %s%n ", newYorkTime);

        ZoneId israelZoneId = ZoneId.of("Asia/Jerusalem");
        LocalTime israeliTime = LocalTime.now(israelZoneId);
        System.out.println(israeliTime);

        LocalTime someTime = LocalTime.of(23, 59, 59);
        System.out.println(someTime);

        String time = "22 54 41";
        DateTimeFormatter timeFormatter = DateTimeFormatter
                .ofPattern("HH mm ss");

        System.out.println(LocalTime.parse(time, timeFormatter));

        ZoneId losAngelesZoneId = ZoneId.of("America/Los_Angeles");
        ZoneId telAvivZoneId = ZoneId.of("Asia/Tel_Aviv");

        LocalTime losAngelesTime = LocalTime.now(losAngelesZoneId);
        LocalTime telAvivTime = LocalTime.now(telAvivZoneId);

        long between = ChronoUnit.HOURS.between(losAngelesTime, telAvivTime);
        System.out.printf("Time difference between LA and TA is %s hours %n", between);


    }
}
