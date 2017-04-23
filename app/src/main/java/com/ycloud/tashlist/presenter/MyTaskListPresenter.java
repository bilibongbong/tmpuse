package com.ycloud.tashlist.presenter;

import com.ycloud.tashlist.bean.TaskData;

import java.util.ArrayList;

/**
 * Created by wangshuhe on 2017/4/22.
 */
public class MyTaskListPresenter {
    private final static String TAG = "MyTaskListPresenter";
    private TaskListTestData testData = new TaskListTestData();
    private IMyTaskListView view;

    public MyTaskListPresenter(IMyTaskListView view){
        this.view = view;
    }

    public ArrayList<TaskData> getMyTaskListFromCache(){
        return testData.getTaskDatas();
    }

    public void getMyTaskList(){

    }

    public int getMyCoins(){
        return 700;
    }

    public void completeTask(int taskId) {
        testData.completeTask(taskId);
        view.onTaskCompleteSuccess(taskId);
    }
}
