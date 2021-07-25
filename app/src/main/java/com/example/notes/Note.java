package com.example.notes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Creating Table
@Entity(tableName = "notes_table")
public class Note {
    @PrimaryKey(autoGenerate = true) int id=0;
    String text;
    public Note(String text) {
        this.text = text;
    }


}
