package com.example.service;

import com.example.domain.Book;
import com.example.domain.LendReturnRecord;
import com.example.domain.FineRecord;
import com.example.domain.News;
import com.example.repository.*;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class BusinessService {
    /**
     * @param bkid 书籍id
     * @param rid 读者id
     * @return 0:书籍或者读者不存在。 -1：书籍已被预定或数据库错误  -2：该读者借书已达3本。 -3：该书已被借走。 1：借书成功
     */
    public static int lend(String bkid, String rid) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        BookRepository br = sqlSession.getMapper(BookRepository.class);
        ReaderRepository rr = sqlSession.getMapper(ReaderRepository.class);
        LendReturnRepository lrr = sqlSession.getMapper(LendReturnRepository.class);
        int result;

        if (br.findById(bkid)==null || rr.findById(rid) == null)
            result = 0;
        else {
            String reservedId = lrr.resvdBy(bkid);
            if (reservedId == null || reservedId.equals(rid)) { //检查书籍是否被该读者预定
                int borrowNum = lrr.getBNum(rid); //检查读者是否借满三本书
                if (borrowNum < 3) {
                    Long lent = lrr.isLent(bkid); //检查该书是否已被借走
                    if (lent == null || lent != 0) { //未被借走
                        long now = Instant.now().getEpochSecond(); //获得当前以秒为单位的时间戳
                        LendReturnRecord record = new LendReturnRecord(0,bkid,rid,now,0);
                        result = lrr.lend(record);
                    }
                    else
                        result = -3; //书已经被借走
                }
                else
                    result = -2; //读者借书已达3本
            }
            else
                result = -1; //书籍已经被预定
        }

        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    /**
     * @param id 需要归还的记录id
     * @return 1：还书成功  2：还书成功但逾期
     */
    public static int reTurn(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        LendReturnRepository lrr = sqlSession.getMapper(LendReturnRepository.class);
        Instant now = Instant.now();
        long nowLong = now.getEpochSecond();//获得当前以秒为单位的时间戳
        LocalDateTime nowTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        LocalDateTime pastTime = nowTime.minusDays(90);
        long pastLong = pastTime.atZone(ZoneId.systemDefault()).toEpochSecond();//获得90天前以秒为单位的时间戳

        int result = lrr.reTurn(id,nowLong);
        Long borrowTime = lrr.getBTime(id);
        if (borrowTime != null && borrowTime < pastLong) { //超过90天加入罚款记录
            FineRepository fr = sqlSession.getMapper(FineRepository.class);
            fr.insert(id,1);
            result++;
        }

        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    //获得借还书的记录
    public List<LendReturnRecord> BRlist() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        LendReturnRepository brr = sqlSession.getMapper(LendReturnRepository.class);
        List<LendReturnRecord> list = brr.findAll();
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return list;
    }

    //按照id查找借还书记录
    public LendReturnRecord findById(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        LendReturnRepository brr = sqlSession.getMapper(LendReturnRepository.class);
        LendReturnRecord record = brr.findById(id);
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

    //编辑公告
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
