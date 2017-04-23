package com.ycloud.tashlist.taskitemholder;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class TaskTitleHolder extends TaskHolder<Object> {
    private final static String TAG = "TaskTitleHolder";

    public TaskTitleHolder(View itemView) {
        super(itemView, null);
        LinearLayout layout = (LinearLayout) itemView;
        layout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setGravity(Gravity.CENTER);
    }

    @Override
    public void bindData(Object data) {

    }
}
