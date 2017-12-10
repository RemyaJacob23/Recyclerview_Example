package com.example.reshmi.myrecyclerview.Activity.Interface;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.reshmi.myrecyclerview.Activity.Classesssss.User;

import java.util.List;

/**
 * Created by Reshmi on 10-12-2017.
 */
@Dao
public interface UserDao {
        // make all required query here

        // this is for all users
        @Query("SELECT * FROM user")
        List<User> getAll();

        //this is a single user by find using name
        @Query("SELECT * FROM user where first_name LIKE  :firstName AND number LIKE :number")
        User findByName(String firstName, int number);

        @Query("SELECT COUNT(*) from user")
        int countUsers();

        @Insert
        void insertAll(User... users);

        @Delete
        void delete(User user);
}
