package com.example.cornjobdemo;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Scheduler {

//    public static void main(String args[]){
//        ArrayList<String> list=new ArrayList<String>();//Creating arraylist
//        list.add("Mango");//Adding object in arraylist
//        list.add("Apple");
//        list.add("Banana");
//        list.add("Grapes");
//        //Traversing list through for-each loop
//        for(String fruit:list)
//            System.out.println(fruit);
//
//    }


    @Scheduled(cron = "0 0/1 * 1/1 * *")
    public void cronJobSch() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        String strDate = sdf.format(now);
        System.out.println("Java cron job expression:: " + strDate);
    }

    @Scheduled(cron = "0 0/1 * 1/1 * *")
    public void cronJobSch2() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        Date now = new Date();
//        String strDate = sdf.format(now);

            // System.out.println("Java cron job expression:: " );
        }
    }


