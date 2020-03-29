package com.example.service;

import com.example.entity.BRrecord;
import com.example.entity.FineRecord;
import com.example.repository.BRrecordRepository;
import com.example.repository.FineRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class BusinessService {
    /**
     * @param bid 书籍id
     * @param rid 读者id
     * @return 0:读者已经借够3本或数据库错误  -1：该书已被借走 1：借书成功
     */
    public static int borrow(String bid, String rid) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BRrecordRepository brr = sqlSession.getMapper(BRrecordRepository.class);
        int result = 0;
        int borrowNum = brr.getBNum(rid); //检查读者是否借满三本书
        if (borrowNum < 3) {
            Long check = brr.check(bid); //检查该书是否已被借走
            if (check == null || check != 0) {
                long now = Instant.now().getEpochSecond(); //获得当前以秒为单位的时间戳
                BRrecord record = new BRrecord(0,bid,rid,now,0);
                result = brr.borrow(record);
            }
            else
                result = -1;
        }
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    /**
     * @param id 需要归还的记录id
     * @return 1：还书成功  0：失败
     */
    public static int returnb(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BRrecordRepository brr = sqlSession.getMapper(BRrecordRepository.class);
        Instant now = Instant.now();
        long nowLong = now.getEpochSecond();//获得当前以秒为单位的时间戳
        LocalDateTime nowTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        LocalDateTime pastTime = nowTime.minusDays(90);
        long pastLong = pastTime.atZone(ZoneId.systemDefault()).toEpochSecond();//获得90天前以秒为单位的时间戳

        long borrowTime = brr.getBTime(id);
        if (borrowTime < pastLong) { //超过90天加入罚款记录
            FineRepository fr = sqlSession.getMapper(FineRepository.class);
            fr.insert(new FineRecord(id,0L));
        }

        int result = brr.returnb(id,nowLong);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }


    public List<BRrecord> BRlist() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BRrecordRepository brr = sqlSession.getMapper(BRrecordRepository.class);
        List<BRrecord> list = brr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }


    public BRrecord findById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BRrecordRepository brr = sqlSession.getMapper(BRrecordRepository.class);
        BRrecord record = brr.findById(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return record;
    }

    //缴纳记录为id的罚款
    public static int payFine(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FineRepository fr = sqlSession.getMapper(FineRepository.class);
        long now = Instant.now().getEpochSecond();
        int result = fr.pay(id, now);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }


    public static List<FineRecord> fineList() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FineRepository fr = sqlSession.getMapper(FineRepository.class);
        List<FineRecord> list = fr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

}