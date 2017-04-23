package com.ycloud.tashlist.presenter;

import com.ycloud.tashlist.bean.ProgressTaskData;
import com.ycloud.tashlist.bean.TaskData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wangshuhe on 2017/4/22.
 */
public class TaskListTestData {
    private final static String TAG = "TaskListTestData";
    ArrayList<TaskData> taskDatas = new ArrayList<>();

    public TaskListTestData(){
        int id = 10;
        TaskData data = new TaskData();
        data.setCoins(20);
        data.setTaskId(++id);
        data.setState(TaskData.TASK_DOING);
        data.setTitle("正在完成任务...");
        taskDatas.add(data);

        data = new TaskData();
        data.setCoins(30);
        data.setTaskId(++id);
        data.setState(TaskData.TASK_DONE);
        data.setTitle("等待领取的任务...");
        taskDatas.add(data);

        data = new TaskData();
        data.setCoins(30);
        data.setTaskId(++id);
        data.setState(TaskData.TASK_COMPLETE);
        data.setTitle("已经领取的任务...");
        taskDatas.add(data);

        ProgressTaskData data1 = new ProgressTaskData();
        data1.setCoins(20);
        data1.setTaskId(++id);
        data1.setState(TaskData.TASK_DOING);
        data1.setTitle("正在完成任务...");
        data1.setTotal(20);
        data1.setProgess(8);
        taskDatas.add(data1);

        data1 = new ProgressTaskData();
        data1.setCoins(30);
        data1.setTaskId(++id);
        data1.setState(TaskData.TASK_DONE);
        data1.setTitle("等待领取的任务...");
        data1.setTotal(9);
        data1.setProgess(9);
        taskDatas.add(data1);

        data1 = new ProgressTaskData();
        data1.setCoins(30);
        data1.setTaskId(++id);
        data1.setTotal(15);
        data1.setProgess(15);
        data1.setState(TaskData.TASK_COMPLETE);
        data1.setTitle("已经领取的任务...");
        taskDatas.add(data1);

        data = new TaskData();
        data.setCoins(20);
        data.setTaskId(++id);
        data.setState(TaskData.TASK_DOING);
        data.setTitle("正在完成任务...");
        taskDatas.add(data);

        data = new TaskData();
        data.setCoins(30);
        data.setTaskId(++id);
        data.setState(TaskData.TASK_DONE);
        data.setTitle("等待领取的任务...");
        taskDatas.add(data);

        data = new TaskData();
        data.setCoins(30);
        data.setTaskId(++id);
        data.setState(TaskData.TASK_COMPLETE);
        data.setTitle("已经领取的任务...");
        taskDatas.add(data);

        data1 = new ProgressTaskData();
        data1.setCoins(20);
        data1.setState(TaskData.TASK_DOING);
        data1.setTitle("正在完成任务...");
        data1.setTotal(20);
        data1.setTaskId(++id);
        data1.setProgess(8);
        taskDatas.add(data1);

        data1 = new ProgressTaskData();
        data1.setCoins(30);
        data1.setTaskId(++id);
        data1.setState(TaskData.TASK_DONE);
        data1.setTitle("等待领取的任务...");
        data1.setTotal(9);
        data1.setProgess(9);
        taskDatas.add(data1);

        data1 = new ProgressTaskData();
        data1.setCoins(30);
        data1.setTaskId(++id);
        data1.setTotal(15);
        data1.setProgess(15);
        data1.setState(TaskData.TASK_COMPLETE);
        data1.setTitle("已经领取的任务...");
        taskDatas.add(data1);
        sortByState(taskDatas);
    }

    public ArrayList<TaskData> getTaskDatas(){
        return taskDatas;
    }

    private void sortByState(ArrayList<TaskData> taskDatas){
        Collections.sort(taskDatas, new Comparator<TaskData>() {
            @Override
            public int compare(TaskData o1, TaskData o2) {
                return o1.getState() - o2.getState();
            }
        });
    }

    public void completeTask(int taskId) {
        for (TaskData data :
                taskDatas) {
            if (data.getTaskId() == taskId){
                data.setState(TaskData.TASK_COMPLETE);
                break;
            }
        }
        sortByState(taskDatas);
    }
}
