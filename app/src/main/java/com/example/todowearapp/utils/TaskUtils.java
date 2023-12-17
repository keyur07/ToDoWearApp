package com.example.todowearapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.todowearapp.model.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskUtils {
    public static void saveTask(Task task, Context context){
        if(task!=null){
            SharedPreferences sharedPref=context.getSharedPreferences("task_details",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPref.edit();
            editor.putString(task.getId(),task.getTaskDetails());
            editor.commit();
        }
    }

    public static List<Task> getAllTasks(Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences ("task_details", Context.MODE_PRIVATE);
                List<Task> taskList = new ArrayList<>();
        Map<String, ?> map = sharedPref.getAll();
        Set set = map.entrySet();
        Iterator itr= set.iterator();

        while(itr.hasNext()) {
            Map.Entry entry = (Map.Entry)itr.next();
            String savedTask = (String) entry.getValue();
            if (savedTask != null) {
                Task task = new Task(entry.getKey().toString(), savedTask);
                taskList.add(task);

            }
        }
        return taskList;
    }

    public static void deleteTask(String id, Context context){
        if(id!=null)
        {
            SharedPreferences sharedPref = context.getSharedPreferences("task_details", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.remove(id);
            editor.commit();
        }
    }
}
