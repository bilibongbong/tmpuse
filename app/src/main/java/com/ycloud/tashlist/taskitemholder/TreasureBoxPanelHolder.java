package com.ycloud.tashlist.taskitemholder;

import android.view.View;

import com.ycloud.tashlist.TreasureBoxPanel;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class TreasureBoxPanelHolder extends TaskHolder<Object> {
    public TreasureBoxPanelHolder(View itemView, ICompleteTaskLister completeTaskLister) {
        super(itemView, completeTaskLister);
        TreasureBoxPanel panel = (TreasureBoxPanel) itemView;
        panel.setCompleteTaskLister(completeTaskLister);
    }

    @Override
    public void bindData(Object data) {

    }
}
