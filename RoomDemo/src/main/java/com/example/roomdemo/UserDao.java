package com.example.roomdemo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @CreateDate: 2021-3-23 19:21
 * @UpdateDate: 2021-3-23 19:21
 * @Description:
 */
@Dao //Database access object的缩写，访问数据库操作接口
public interface UserDao {

    @Insert
    void insertUser(User... users);

    @Update
    void updateUser(User... users);

    @Delete
    void deleteUser(User... users);

    @Query("DELETE FROM USER")
    void deleteAllUser();

    @Query("SELECT * FROM USER ORDER BY ID DESC")
    List<User> getAllUser();

}
