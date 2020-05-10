package com.example.domain;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LendingRecord {
    private int id; //记录的id
    private String bkid; //书籍id
    private String rid; //读者id
    private long btime; //借书时间
    private long rtime; //还书时间
}
