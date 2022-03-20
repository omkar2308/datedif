package com.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


//@Scheduled(cron = "0 * 9 * * ?")
class Main {

    static long purg= 7;
     static String createdDate= "2022-02-11T12:09:04.374";



    public static void main(String[] args) throws ParseException {
        String date1 = "2018-05-26";
        String date2 = "2018-05-28";

        long result = getDiff(date2, date1);
        System.out.println("result"+" "+ result);

        String result2 = getCurrentDate();
        System.out.println("result2 :"+ result2);

        int result3=remainingDaysToDelete("23-February-2022");
        System.out.println("difference "+result3);

        String today=getCurrentDate();
        System.out.println("today "+today);
        String mailsenddate="09-March-2022";
        int remaining=1;
        if (remaining ==1&&!(mailsenddate.equalsIgnoreCase(today))){
            System.out.println("mail send");
        }
        /*int result3 = remainingDaysToDelete(createdDate);
        System.out.println(result3);*/

        //String createdDate=
//
//        remainingDaysToDelete()
//        if(result3<=0){
//            System.out.println("Delete");
//        }

    }

    private static long getDiff(String p1, String p2) {
       // LocalDate d1 = LocalDate.parse("2018-05-26", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d1 = LocalDate.parse("2022-05-26", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse("2022-05-28", DateTimeFormatter.ISO_LOCAL_DATE);
        // LocalDate d1 = DateTimeFormatter.ofPattern("2018-05-26", Locale.ENGLISH);
        //LocalDate d2 = DateTimeFormatter.ofPattern("2018-05-28", Locale.ENGLISH);

        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
        long diffDays = diff.toDays();
        //System.out.println(diffDays);
        String s1 = String.valueOf(diffDays);
        return diffDays;
    }

    public static String convertDateWithTimezone(String dateWithTimezone) {
        //String inputPattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        String inputPattern = "yyyy-MM-dd";
        String outputPattern = "dd-MMMM-yyyy";
//        String inputPattern = "yyyy-MM-dd";
//        String outputPattern =  "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        //String outputPattern = "yyyy-MM-dd";

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputPattern, Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputPattern, Locale.ENGLISH);

        LocalDateTime inputDate = LocalDateTime.parse(dateWithTimezone, inputFormatter);
        String outputDate = outputFormatter.format(inputDate);

        return outputDate;
    }

    private static int remainingDaysToDelete(String createdDate) throws ParseException {
        int daysDifference = 0;

            String today = getCurrentDate();
            System.out.println("today: "+today);
            //String formattedCreatedDate = convertDateWithTimezone(createdDate);
            String formattedCreatedDate = createdDate;

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH);
            Date currentDate = simpleDateFormat.parse(today);
            Date dateOnCreation = simpleDateFormat.parse(formattedCreatedDate);

            long diffInMillis = Math.abs(currentDate.getTime() - dateOnCreation.getTime());
            daysDifference = (int) TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
            System.out.println("daysDifference: "+daysDifference);

        return (int) (purg - daysDifference);
        //return (int) ( daysDifference);
    }

    private static String getCurrentDate() {

            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
            LocalDateTime CurrentDate = LocalDateTime.now();
            String formattedCurrentDate = CurrentDate.format(format);
             System.out.println(formattedCurrentDate);
            return formattedCurrentDate;

    }
}