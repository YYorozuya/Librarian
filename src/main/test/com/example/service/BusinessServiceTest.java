package com.example.service;

import com.example.entity.FineRecord;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

class BusinessServiceTest {
    @Test
    void test() {
        int test;
        //test = BusinessService.borrow("97875386929900003","465");
        //test = BusinessService.borrow("97814082743230002","465");
        //test = BusinessService.returnb(3);
        //test = BusinessService.payFine(1);
        //System.out.println(test);

        //BusinessService.payFine(1);
        //LocalDateTime nowtime = LocalDateTime.now();
        //long l1 = nowtime.atZone(ZoneId.systemDefault()).toEpochSecond();

        //long l2 = Instant.now().getEpochSecond();

        //test = BusinessService.postNews("dadfsgfd","dsfdgfd");
        test = BusinessService.lend("97802419504250001","123");
        //test = BusinessService.deleteNews(0);
        System.out.println(test);

        //System.out.println(test);
        //System.out.println(l2);
        /*List<Double> list = BusinessService.totalFine();
        for (double f: list)
            System.out.println(f);*/


        File file = new File("classpath:/");
        /*LocalDateTime now = LocalDateTime.now();
        LocalDateTime m = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime m1 = now.withMonth(1);
        LocalDateTime m2 = now.withDayOfMonth(20);
        long l1 = now.atZone(ZoneId.systemDefault()).toEpochSecond();
        long l2 = m1.atZone(ZoneId.systemDefault()).toEpochSecond();
        long l3 = m2.atZone(ZoneId.systemDefault()).toEpochSecond();
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);*/
    }

}