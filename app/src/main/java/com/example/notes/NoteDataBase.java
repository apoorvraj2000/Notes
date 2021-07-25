package com.example.notes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//MAIN DATABASE

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract  class NoteDataBase extends RoomDatabase {

   public abstract NoteDao getNodeDao();

    private static volatile NoteDataBase INSTANCE;

   public static NoteDataBase getDatabase(Context context) {
        if (INSTANCE == null) {

                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDataBase.class, "word_database")
                            .allowMainThreadQueries()
                            .build();
                }

        }
        return INSTANCE;
    }
}
