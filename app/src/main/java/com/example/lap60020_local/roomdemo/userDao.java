package com.example.lap60020_local.roomdemo;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface userDao {
    @Query("select * from User")
    Flowable<User> getAll();
    @Query("select * from User where first_name like:firstName and last_name like:lastName")
    User findByName(String firstName, String lastName);
    @Query("select count(*) from User")
    int countUser();
    @Insert
    void insertAll(User...users);
    @Delete
    void delete(User user);
}
