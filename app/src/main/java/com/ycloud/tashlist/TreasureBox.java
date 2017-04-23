package com.ycloud.tashlist;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.ycloud.tashlist.taskitemholder.ICompleteTaskLister;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class TreasureBox extends RelativeLayout{
    private final static String TAG = "TreasureBox";
    private ImageView imageViewBox;
    private View  openButton;
    private ProgressBar progressBar;
    private ICompleteTaskLister completeTaskLister;

    public TreasureBox(Context context) {
        this(context, null);
    }

    public TreasureBox(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TreasureBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_treasure_box, this);
        imageViewBox = (ImageView) findViewById(R.id.iv_box);
        progressBar = (ProgressBar) findViewById(R.id.progress_box);
        openButton = findViewById(R.id.open_box);
        openButton.setOnClickListener(new OnClickListener() {
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

    public void setOpenButtonVisibility(int visibility){
        openButton.setVisibility(visibility);
    }

    public void setProgessVisiblity(int visiblity){
        progressBar.setVisibility(visiblity);
    }

    public void setProgess(int total, int progress){
        progressBar.setMax(total);
        progressBar.setProgress(progress);
    }

    public void setCompleteTaskLister(ICompleteTaskLister completeTaskLister) {
        this.completeTaskLister = completeTaskLister;
    }
}
