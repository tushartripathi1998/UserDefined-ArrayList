package com.example.livedatanew.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Message.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public abstract MessageDao message();

    private Context context;

    public static AppDatabase getInstance(Context context)
    {
        if(appDatabase == null){
            appDatabase = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "Message Database"
            )
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public static void destroyInstance()
    {
        appDatabase = null;
    }
}
