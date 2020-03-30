package com.example.service;

import com.example.entity.FineRecord;
import org.junit.jupiter.api.Test;

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
        test = BusinessService.returnb(3);
        //test = BusinessService.payFine(1);
        System.out.println(test);
        //LocalDateTime nowtime = LocalDateTime.now();
        //long l1 = nowtime.atZone(ZoneId.systemDefault()).toEpochSecond();

        //long l2 = Instant.now().getEpochSecond();

        //System.out.println(test);
        //System.out.println(l2);
        /*List<FineRecord> list = BusinessService.fineList();
        for (FineRecord f: list)
            System.out.println(f);*/

        /*LocalDateTime now = LocalDateTime.now();
        LocalDateTime m = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        System.out.println(m);*/
    }

}