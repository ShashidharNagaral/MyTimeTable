package com.example.shashidhar.mytimetable;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<demo> demoList;

    public RecyclerViewAdapter(Context context, ArrayList<demo> demoList) {
        this.context = context;
        this.demoList = demoList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_table, viewGroup, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        demo demolist = demoList.get(i);
        myViewHolder.classroom.setText(demolist.getClassroom());
        myViewHolder.teacher.setText(demolist.getTeacher());
        myViewHolder.subject.setText(demolist.getSubject());
        myViewHolder.stime.setText(demolist.getStart());
        myViewHolder.etime.setText(demolist.getEnd());

    }

    @Override
    public int getItemCount() {
        return demoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView classroom;
        private TextView teacher;
        private TextView subject;
        private TextView etime;
        private TextView stime;

        public MyViewHolder(@NonNull View view) {
            super(view);
            classroom = view.findViewById(R.id.classroomID);
            teacher = view.findViewById(R.id.teacherID);
            subject = view.findViewById(R.id.subjectID);
            stime = view.findViewById(R.id.starttimeID);
            etime = view.findViewById(R.id.endtimeID);
        }
    }
}
