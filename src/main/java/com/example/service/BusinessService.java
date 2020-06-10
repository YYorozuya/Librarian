package com.example.service;

import com.example.domain.DelRecord;
import com.example.domain.LendingRecord;
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
        LendingRepository lrr = sqlSession.getMapper(LendingRepository.class);
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
                        LendingRecord record = new LendingRecord(0,bkid,rid,now,0);
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
        LendingRepository lrr = sqlSession.getMapper(LendingRepository.class);
        Instant now = Instant.now();
        long nowLong = now.getEpochSecond(); //获得当前以秒为单位的时间戳
        LocalDateTime nowTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        int period = lrr.period(); //获得数据库中的还书期限
        LocalDateTime pastTime = nowTime.minusDays(period);
        long pastLong = pastTime.atZone(ZoneId.systemDefault()).toEpochSecond(); //获得当前日期减去期限天数的以秒为单位的时间戳
        int result = lrr.reTurn(id,nowLong);
        Long borrowTime = lrr.getBTime(id);
        if (borrowTime != null && borrowTime < pastLong) { //超过期限加入罚款记录
            FineRepository fr = sqlSession.getMapper(FineRepository.class);
            fr.insert(id);
            result = 2;
        }
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    //缴纳记录为id的罚款
    public static int payFine(int id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FineRepository fr = sqlSession.getMapper(FineRepository.class);
        long now = Instant.now().getEpochSecond();
        int amount = fr.finevalue();
        int result = fr.pay(id, now, amount);
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }

    //管理员登陆，成功返回1失败返回0
    public static int libAuthCheck(String account, String pwd) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        LibrarianRepository lbr = sqlSession.getMapper(LibrarianRepository.class);
        String password = lbr.check(account);
        int result = 0;
        if (pwd.equals(password))
            result = 1;
        sqlSession.commit();
        MyBatisUtil.closeSqlSession(sqlSession);
        return result;
    }
}
