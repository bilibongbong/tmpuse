package com.ycloud.tashlist.taskitemholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public abstract class TaskHolder<T> extends RecyclerView.ViewHolder {
    protected ICompleteTaskLister completeTaskLister;
    public TaskHolder(View itemView, ICompleteTaskLister completeTaskLister) {
        super(itemView);
        this.completeTaskLister = completeTaskLister;
    }


    public abstract void bindData(T data);
}
