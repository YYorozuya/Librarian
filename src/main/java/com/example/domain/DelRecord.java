package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DelRecord {
    private int id;
    private String bkid; //书籍id
    private String libid; //图书馆员id
    private String reason; //删除原因
    private Long time; //删除时间
}
