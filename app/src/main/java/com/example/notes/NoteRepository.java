package com.example.notes;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {

    private NoteDao noteDao;

    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDataBase database = NoteDataBase.getDatabase(application);
        noteDao = database.getNodeDao();
        allNotes = noteDao.getAllNotes();
    }
    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }
    void insert(Note note){
        noteDao.insert(note);
    }

    void  delete(Note note){
        noteDao.delete(note);
    }

}
