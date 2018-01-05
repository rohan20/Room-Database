package com.rohan.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by rohan on 04/01/18.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE user_name like :username")
    List<User> getAllUsers(String username);

    @Query("SELECT * FROM users WHERE userId like :userId")
    User getUser(int userId);

    @Insert
    long insert(User user); //return id of the user added
//    void insert(User user);

    @Insert
    void insertAll(List<User> users);

    @Update
    void update(User user);

    @Delete
    void delete(User user);
}
