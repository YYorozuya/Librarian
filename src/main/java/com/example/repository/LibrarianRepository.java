package com.example.repository;

import org.apache.ibatis.annotations.Param;

public interface LibrarianRepository {
    String check(@Param("account")String account);
}
