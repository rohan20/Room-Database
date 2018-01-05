package com.rohan.roomdatabase;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by rohan on 05/01/18.
 */

public class AppController extends Application {

    private static Context mAppContext;
    private static RoomDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this.getApplicationContext();
        database = Room.databaseBuilder(this, AppDatabase.class, "App-Database").build();
    }

    public static Context getApp() {
        return mAppContext;
    }

    public RoomDatabase getDb() {
        return database;
    }
}
