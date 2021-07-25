package com.example.notes;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;
    private final LiveData<List<Note>> allNote;
    public NoteViewModel(Application application) {
        super(application);

        NoteDao dao=NoteDataBase.getDatabase(application).getNodeDao();
        noteRepository=new NoteRepository(application);
        allNote=noteRepository.getAllNotes();
    }
    LiveData<List<Note>> getallNote(){
        return allNote;
    }
public  void deleteNote(Note note){
        noteRepository.delete(note);
}
public  void addNote(Note note){
        noteRepository.insert(note);
}
}
