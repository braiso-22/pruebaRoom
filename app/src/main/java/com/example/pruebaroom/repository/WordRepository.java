package com.example.pruebaroom.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.pruebaroom.model.DB.WordDB;
import com.example.pruebaroom.model.dao.WordDao;
import com.example.pruebaroom.model.vo.Word;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordDB db = WordDB.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAlphabetizedWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        WordDB.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
}
