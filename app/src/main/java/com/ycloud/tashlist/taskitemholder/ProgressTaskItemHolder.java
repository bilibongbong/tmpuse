package com.ycloud.tashlist.taskitemholder;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ycloud.tashlist.R;
import com.ycloud.tashlist.bean.ProgressTaskData;
import com.ycloud.tashlist.bean.TaskData;

import java.util.Locale;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class ProgressTaskItemHolder extends TaskItemHolder {
    private final static String TAG = "ProgressTaskItemHolder";
    private ProgressBar progressBar;
    private TextView progressText;

    public ProgressTaskItemHolder(View itemView, ICompleteTaskLister completeTaskLister) {
        super(itemView, completeTaskLister);
        progressBar  = (ProgressBar) itemView.findViewById(R.id.progress_box);
        progressText = (TextView) itemView.findViewById(R.id.progress_text);
    }

    @Override
    public void bindData(TaskData data) {
        super.bindData(data);

        if ( null == data || !(data instanceof ProgressTaskData) ){
            return;
        }

        ProgressTaskData progressTaskData = (ProgressTaskData) data;
        
        progressText.setText(String.format(Locale.getDefault(),"%d/%d"
                ,progressTaskData.getProgess(), progressTaskData.getTotal()));
        progressBar.setMax(progressTaskData.getTotal());
        progressBar.setProgress(progressTaskData.getProgess());
    }
}
