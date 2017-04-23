package com.ycloud.tashlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.ycloud.tashlist.taskitemholder.ICompleteTaskLister;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class TreasureBoxSeller extends RelativeLayout{
    private final static String TAG = "TreasureBoxSeller";
    private ImageView imageViewBox;
    private ICompleteTaskLister completeTaskLister;

    public TreasureBoxSeller(Context context) {
        this(context, null);
    }

    public TreasureBoxSeller(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TreasureBoxSeller(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_treasurebox_seller, this);
        imageViewBox = (ImageView) findViewById(R.id.iv_box);
        imageViewBox.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( null != completeTaskLister ){
                    completeTaskLister.onCompleteTask(0);
                }
            }
        });
    }

    public void setImageResource(int res){
        imageViewBox.setImageResource(res);
    }

    public void setCompleteTaskLister(ICompleteTaskLister completeTaskLister) {
        this.completeTaskLister = completeTaskLister;
    }
}
