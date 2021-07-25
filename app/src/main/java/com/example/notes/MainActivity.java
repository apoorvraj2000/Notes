package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements clicked {
    private NoteViewModel noteViewModel;
    RecyclerView recyclerView;
    MyApapter myApapter;
    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        recyclerView=(RecyclerView)findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myApapter=new MyApapter(this,this);
        recyclerView.setAdapter(myApapter);

        noteViewModel=new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.
                getInstance(this.getApplication())).get(NoteViewModel.class);

        noteViewModel.getallNote().observe(this,note -> {

            myApapter.updateList((ArrayList<Note>) note);

        });


    }

    @Override
    public void onItemClicked(Note note) {
      noteViewModel.deleteNote(note);
        Toast.makeText(this,"Note Deleted",Toast.LENGTH_LONG).show();
    }

    public void addNote(View view) {
        EditText input=(EditText)findViewById(R.id.input);
        String noteText= input.getText().toString();
        double value=0;
        if(!noteText.isEmpty()){
            noteViewModel.addNote(new Note(noteText));
            Toast.makeText(this,"New Note added",Toast.LENGTH_LONG).show();
        }
    }
}