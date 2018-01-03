package com.rohan.roomdatabase;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by rohan on 03/01/18.
 */

@Entity(tableName = "users")
public class User {

    @PrimaryKey
    private int userId;

    @ColumnInfo(name = "user_name")
    private String userName;

    @ColumnInfo(name = "user_image")
    private int userImage;

    //If an entity has fields that you don't want to persist, you can annotate them using @Ignore
    @Ignore
    private String userFullName;


    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserImage() {
        return userImage;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }
}
