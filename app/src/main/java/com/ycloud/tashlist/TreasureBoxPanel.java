package com.ycloud.tashlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.ycloud.tashlist.taskitemholder.ICompleteTaskLister;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class TreasureBoxPanel extends RelativeLayout{
    private final static String TAG = "TreasureBoxPayItem";
    private TreasureBox dayTaskBox;
    private TreasureBox tenDayTaskBox;
    private TreasureBoxSeller woodSeller;
    private TreasureBoxSeller silverSeller;
    private TreasureBoxSeller metalSeller;

    public TreasureBoxPanel(Context context) {
        this(context, null);
    }

    public TreasureBoxPanel(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TreasureBoxPanel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_treasurebox_panel, this);
        dayTaskBox = (TreasureBox) findViewById(R.id.day_task_box);
        tenDayTaskBox = (TreasureBox) findViewById(R.id.ten_day_task_box);
        woodSeller = (TreasureBoxSeller) findViewById(R.id.seller_wood);
        silverSeller = (TreasureBoxSeller) findViewById(R.id.seller_silver);
        metalSeller = (TreasureBoxSeller) findViewById(R.id.seller_metal);

        dayTaskBox.setImageResource(R.drawable.icon_day_task_treasure_box);
        tenDayTaskBox.setImageResource(R.drawable.icon_ten_day_task_treasure_box);
        woodSeller.setImageResource(R.drawable.icon_treasure_box_wood);
        silverSeller.setImageResource(R.drawable.icon_treasure_box_silver);
        metalSeller.setImageResource(R.drawable.icon_treasure_box_metal);

        dayTaskBox.setProgessVisiblity(View.GONE);
    }

    public void setCompleteTaskLister(ICompleteTaskLister completeTaskLister) {
        dayTaskBox.setCompleteTaskLister(completeTaskLister);
        tenDayTaskBox.setCompleteTaskLister(completeTaskLister);
        woodSeller.setCompleteTaskLister(completeTaskLister);
        silverSeller.setCompleteTaskLister(completeTaskLister);
        metalSeller.setCompleteTaskLister(completeTaskLister);
    }
}
