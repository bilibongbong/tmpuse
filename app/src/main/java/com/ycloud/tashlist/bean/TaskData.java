package com.ycloud.tashlist.bean;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class TaskData {
    private final static String TAG = "TaskData";
    public final static int TASK_DONE = 0;
    public final static int TASK_DOING = 1;
    public final static int TASK_COMPLETE = 2;

    @TaskState
    private int state;
    private int taskId;
    private int coins = 0;
    private String title;

    @TaskState
    public int getState() {
        return state;
    }

    public void setState(@TaskState int state) {
        this.state = state;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }


    @IntDef({TASK_DOING, TASK_DONE, TASK_COMPLETE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TaskState {
    }
}
