package com.example.service;

import com.example.entity.BRrecord;
import com.example.entity.FineRecord;
import com.example.entity.News;
import com.example.repository.BRrecordRepository;
import com.example.repository.FineRepository;
import com.example.repository.NewsRepository;
import com.example.repository.ReaderRepository;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
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
            fr.insert(id,1);
        }

        int result = brr.returnb(id,nowLong);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    //获得借还书的记录
    public List<BRrecord> BRlist() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BRrecordRepository brr = sqlSession.getMapper(BRrecordRepository.class);
        List<BRrecord> list = brr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    //按照id查找借还书记录
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
        int result = fr.pay(id, now,1);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
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

    //发送公告
    public static int postNews(String title, String content) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        NewsRepository nr = sqlSession.getMapper(NewsRepository.class);
        long now = Instant.now().getEpochSecond(); //获得当前以秒为单位的时间戳
        News news = new News(0,title,content,now);
        int result = nr.insert(news);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    //删除公告
    public static int deleteNews(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        NewsRepository nr = sqlSession.getMapper(NewsRepository.class);
        int result = nr.delete(id);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    public static int editNews(int id, String title, String content) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        NewsRepository nr = sqlSession.getMapper(NewsRepository.class);
        News news = new News(id,title,content,0);
        int result = nr.edit(news);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

}
