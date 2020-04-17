package com.example.repository;

import com.example.domain.DelRecord;

import java.util.List;

public interface DelRecordRepository {
    int insert(DelRecord record);
    List<DelRecord> findAll();
}
