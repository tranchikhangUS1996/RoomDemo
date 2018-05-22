package com.example.lap60020_local.roomdemo;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;

@Database(entities = {User.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public abstract userDao getUserDao();

    public static AppDatabase getAppDatabase(Context context) {
        if(INSTANCE==null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext()
                    ,AppDatabase.class
                    ,"User-database").addMigrations(Migration_1_2)
                    .build();
        }
        return INSTANCE;
    }

    static final Migration Migration_1_2 = new Migration(1,2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {

        }
    };

    public static void destroyInstance() {
        INSTANCE = null;
    }
}
