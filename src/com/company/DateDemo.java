package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class DateDemo {

    public static void main(String[] args) {

        //Local     Time, Date, DateTime
        //Zone

        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tomorrow = yesterday.plusDays(2);

        System.out.println(today);
        System.out.println(yesterday);
        System.out.println(tomorrow);

        LocalDate israeliIndependenceDay = LocalDate.now()
                .withMonth(4)
                .withDayOfMonth(19);

        System.out.println(israeliIndependenceDay);


//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter your birthday date");
//        String bdate = scanner.nextLine();
//        System.out.println("Enter your birthday month");
//        String bmonth = scanner.nextLine();
//
//
//        LocalDate birthday = LocalDate.now()
//                .withMonth(Integer.parseInt(bmonth))
//                .withDayOfMonth(Integer.parseInt(bdate));
//        System.out.println(birthday);

        String stringDate = "2018-05-01";
        System.out.println(LocalDate.parse(stringDate).getDayOfWeek());


        System.out.println("---Non Standard Date---");
        String nonStandardDate = "1999/12/31";
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyy/MM/dd");
        LocalDate newYear = LocalDate.parse(nonStandardDate, formatter);
        System.out.println(newYear);
        System.out.println(newYear.getDayOfWeek());

        System.out.println("--- Date comparison---");

        LocalDate date1 = LocalDate.of(2018, 4, 30);
        LocalDate date2 = LocalDate.of(2018, 5, 1);

        System.out.printf("Is Equal: %s%n", date1.isEqual(date2));
        System.out.printf("Is Before: %s%n", date1.isBefore(date2));
        System.out.printf("Is After: %s%n", date1.isAfter(date2));

        System.out.println("---Discount calculation---");
        LocalDate discountStart = LocalDate.of(2018, 4, 1);
        LocalDate discountEnd = discountStart.plusMonths(2).minusDays(1);

        LocalDate now = /*LocalDate.now();*/
                        LocalDate.now().plusMonths(1).minusDays(1);
        System.out.printf("Now it is %s%n", now);
        if (now.isBefore(discountEnd) || now.isEqual(discountEnd)) {
            System.out.println("Greetings! Discount applies!");
        } else {
            System.out.println("Sorry, discount does not apply");
        }

        System.out.println("---Month start---");
        LocalDate aprilStart = LocalDate.now().withMonth(2).withDayOfMonth(15);
        System.out.printf("Month start: %s, Month end: %s%n",
                aprilStart.withDayOfMonth(1),
                aprilStart.withDayOfMonth(1).plusMonths(1).minusDays(1));

        System.out.println("---Is Leap year---");
        LocalDate currentYear = LocalDate.now();
        System.out.println(currentYear.isLeapYear());

        LocalDate leapYear = currentYear.minusYears(2);
        System.out.println(leapYear.isLeapYear());

        int yearsCount = 20;
        System.out.println("--- Leap year through last 20 years ---");
        for (int i = 0; i < yearsCount; i++) {
            currentYear = LocalDate.now().minusYears(i);
            if (currentYear.isLeapYear()) {
                System.out.printf("%s is a leap year!%n", currentYear.getYear());
                System.out.printf("Month start: %s, Month end: %s%n",
                        currentYear.withMonth(2).withDayOfMonth(1),

                        currentYear.withMonth(2)
                                .withDayOfMonth(1)
                                .plusMonths(1)
                                .minusDays(1));
            }
        }

    }






}
