package com.rohan.roomdatabase;

import android.arch.persistence.room.Entity;

/**
 * Created by rohan on 03/01/18.
 */

public class User {

    private int userId;
    private String userName;
    private int userImage;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserImage() {
        return userImage;
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
}
