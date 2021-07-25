package com.example.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyApapter extends RecyclerView.Adapter<MyApapter.MyViewholder> {

    ArrayList<Note>allNotes=new ArrayList<>();
    private final Context context;
    clicked listner;

    public MyApapter(Context context, clicked listner) {
        //this.allNotes = allNotes;
        this.context=context;
        this.listner = listner;
    }

    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note,parent,false);
        MyViewholder viewholder=new MyViewholder(view);

        viewholder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onItemClicked(allNotes.get(viewholder.getAdapterPosition()));
            }
        });
        return viewholder;
    }

    @Override
    public void onBindViewHolder(MyViewholder holder, int position) {
    Note currentNote=allNotes.get(position);
    holder.textView.setText(currentNote.text);
    }

    @Override
    public int getItemCount() {
        return allNotes.size();
    }

    //For update
    public  void updateList(ArrayList<Note>newList){
    allNotes.clear();

    allNotes.addAll(newList);

    notifyDataSetChanged();
    }

    //inner class
    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView textView;
        ImageView deleteButton;
        public MyViewholder(View itemView) {
            super(itemView);

            textView=(TextView)itemView.findViewById(R.id.textView);
            deleteButton=(ImageView)itemView.findViewById(R.id.deteButton);
        }
    }
}
interface clicked{
    void onItemClicked(Note note);
}