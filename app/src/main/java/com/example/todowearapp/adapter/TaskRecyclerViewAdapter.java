package com.example.todowearapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todowearapp.activity.DeletetaskActivity;
import com.example.todowearapp.databinding.TaskRowBinding;
import com.example.todowearapp.model.Task;

import java.util.List;

public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    TaskRowBinding rowBinding;
    private List<Task> mTasks;
    Context context;

    public TaskRecyclerViewAdapter(List<Task> taskList, Context objContext)
    {
        super();
        this.mTasks = taskList;
        this.context = objContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        rowBinding=TaskRowBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(rowBinding);
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {
        TaskRowBinding recyclerRowBinding;
        public ViewHolder(TaskRowBinding taskRowBinding){
            super(taskRowBinding.getRoot());
            this.recyclerRowBinding = taskRowBinding;
        }
        void bindView(final String taskDetails, final int position){
            recyclerRowBinding.txtTask.setText(taskDetails);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DeletetaskActivity.class);
                    intent.putExtra("TASK_ID", mTasks.get(position).getId());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder) holder).bindView(mTasks.get(position).getTaskDetails(),position);
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }
}