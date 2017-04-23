package com.ycloud.tashlist.presenter;

/**
 * Created by wangshuhe on 2017/4/22.
 */

public interface IMyTaskListView {
    void onTaskCompleteSuccess(int taskId);
    void onTaskCompleteFailed(int taskId, String errorMessage);
}
