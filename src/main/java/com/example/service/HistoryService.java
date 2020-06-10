package com.example.service;

import com.example.domain.DelRecord;
import com.example.domain.FineRecord;
import com.example.domain.LendingRecord;
import com.example.repository.DelRecordRepository;
import com.example.repository.FineRepository;
import com.example.repository.LendingRepository;
import com.example.repository.ReaderRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class HistoryService {
    //获得借还书的记录
    public static List<LendingRecord> lendingList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        LendingRepository brr = sqlSession.getMapper(LendingRepository.class);
        List<LendingRecord> list = brr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    //按照Reader查找借还书记录
    public static List<LendingRecord> readerLending(String rid) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        LendingRepository brr = sqlSession.getMapper(LendingRepository.class);
        List<LendingRecord> list = brr.findByReader(rid);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    //获得书籍删除记录
    public static List<DelRecord> delList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        DelRecordRepository dr = sqlSession.getMapper(DelRecordRepository.class);
        List<DelRecord> list = dr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    //获得罚款记录
    public static List<FineRecord> fineList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FineRepository fr = sqlSession.getMapper(FineRepository.class);
        List<FineRecord> list = fr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    //获得读者罚款记录
    public static List<FineRecord> readerFine(String rid) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FineRepository fr = sqlSession.getMapper(FineRepository.class);
        List<FineRecord> list = fr.findByReader(rid);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    //返回一个List，前三项分别为保证金本年收入，本月收入，本日收入
    public static List<Double> totalDeposit() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime year = now.withDayOfYear(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime month = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime day = now.withHour(0).withMinute(0).withSecond(0);
        Double sumY = rr.sumBy(year.atZone(ZoneId.systemDefault()).toEpochSecond());
        Double sumM = rr.sumBy(month.atZone(ZoneId.systemDefault()).toEpochSecond());
        Double sumD = rr.sumBy(day.atZone(ZoneId.systemDefault()).toEpochSecond());
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        if(sumY == null)
            sumY = 0.0;
        if(sumM == null)
            sumM = 0.0;
        if(sumD == null)
            sumD = 0.0;
        List<Double> list = new ArrayList<>();
        list.add(sumY);
        list.add(sumM);
        list.add(sumD);
        return list;
    }

    //返回一个List，前三项分别为罚金本年收入，本月收入，本日收入
    public static List<Double> totalFine() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FineRepository fr = sqlSession.getMapper(FineRepository.class);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime year = now.withDayOfYear(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime month = now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        LocalDateTime day = now.withHour(0).withMinute(0).withSecond(0);
        Double sumY = fr.sumBy(year.atZone(ZoneId.systemDefault()).toEpochSecond());
        Double sumM = fr.sumBy(month.atZone(ZoneId.systemDefault()).toEpochSecond());
        Double sumD = fr.sumBy(day.atZone(ZoneId.systemDefault()).toEpochSecond());
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        if(sumY == null)
            sumY = 0.0;
        if(sumM == null)
            sumM = 0.0;
        if(sumD == null)
            sumD = 0.0;
        List<Double> list = new ArrayList<>();
        list.add(sumY);
        list.add(sumM);
        list.add(sumD);
        return list;
    }
}
