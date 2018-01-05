package com.rohan.roomdatabase;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by rohan on 05/01/18.
 */

public class AppController extends Application {

    private static final String DB_NAME = "App-Database";
    private static AppDatabase database;

    public static synchronized AppDatabase getInstance(Context context){
        if(database == null)
            database = createDatabase(context);

        return database;
    }

    private static AppDatabase createDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DB_NAME).build();
    }

}
