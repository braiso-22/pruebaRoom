package com.example.pruebaroom.model.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pruebaroom.model.dao.WordDao;
import com.example.pruebaroom.model.vo.Word;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordDB extends RoomDatabase {
    public abstract WordDao wordDao();

    private static volatile WordDB INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static WordDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordDB.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
