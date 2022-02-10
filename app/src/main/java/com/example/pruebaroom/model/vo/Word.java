package com.example.pruebaroom.model.vo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "word_table")
public class Word {

    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "word")
    private String word;

    public Word(@NotNull String word) {
        this.word = word;
    }
    public String getWord(){
        return this.word;
    }
}
