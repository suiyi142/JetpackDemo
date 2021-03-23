package com.example.roomdemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * @CreateDate: 2021-3-23 19:18
 * @UpdateDate: 2021-3-23 19:18
 * @Description:
 */
@Database(entities = {User.class}, version = 1, exportSchema = false)//三个参数分别为数据库中的表、数据库版本号和导出模式
public abstract class UserDb extends RoomDatabase {

    public abstract UserDao getUserDao(); //只需写一个函数原型即可

}
