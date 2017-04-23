package com.ycloud.tashlist.taskitemholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ycloud.tashlist.R;
import com.ycloud.tashlist.bean.TaskData;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class TaskItemHolder extends TaskHolder<TaskData> {
    private TextView tvCoins;
    private TextView tvContent;
    private ImageView ivState;
    private int taskId;

    public TaskItemHolder(View itemView, final ICompleteTaskLister completeTaskLister) {
        super(itemView, completeTaskLister);
        tvCoins = (TextView) itemView.findViewById(R.id.tv_coins);
        tvContent = (TextView) itemView.findViewById(R.id.tv_content);
        ivState = (ImageView) itemView.findViewById(R.id.iv_state);
        ivState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( null != completeTaskLister ){
                    completeTaskLister.onCompleteTask(taskId);
                }
            }
        });
    }

    @Override
    public void bindData(TaskData data) {
        if ( null != data ){
            taskId = data.getTaskId();
            tvCoins.setText(Integer.toString(data.getCoins()));
            tvContent.setText(data.getTitle());
            setState(data);
        }
    }

    private void setState(TaskData data){
        if ( data.getState() == TaskData.TASK_COMPLETE ){
            ivState.setImageResource(R.drawable.icon_task_complete);
            ivState.setEnabled(false);
        }
        else if ( data.getState() == TaskData.TASK_DONE ){
            ivState.setImageResource(R.drawable.icon_task_done);
            ivState.setEnabled(true);
        }
        else {
            ivState.setImageResource(R.drawable.icon_task_doing);
            ivState.setEnabled(false);
        }
    }
}
