package com.example.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FineRecord {
    private LendReturnRecord record; //违规的记录
    private double amount; //罚款金额
    private long time; //缴纳时间
}
