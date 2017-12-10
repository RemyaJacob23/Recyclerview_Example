package com.example.reshmi.myrecyclerview.Activity.Classesssss;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Reshmi on 10-12-2017.
 */
@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;
    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "number")
    private int number;

    @ColumnInfo(name = "age")
    private int age;


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}
