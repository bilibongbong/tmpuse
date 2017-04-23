package com.ycloud.tashlist.taskitemholder;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.ycloud.tashlist.R;

import java.util.Locale;

/**
 * Created by wangshuhe on 2017/4/23.
 * circle progress bar
 */
public class CircleProgressBar extends View {

    private final static int DEFAULT_BACKGROUND_COLOR = 0xFF000000;
    private final static int DEFAULT_PERCENT_COLOR = 0xFFFFFFFF;
    private final static int DEFAULT_SIZE = 40;//40dp
    private final static int DEFAULT_TEXT_SIZE = 15;//15sp
    private final static int DEFAULT_TEXT_COLOR = 0xFFFFFFFF;
    private final static int DEFAULT_MAX = 100;


    //圆的半径
    private float radius;

    //色带的宽度
    private float stripeWidth;

    private int progressHeight;
    private int progressWidth;


    //进度信息
    private int progress;
    private int max;

    //圆心坐标
    private float x;
    private float y;

    //要画的弧度
    private int endAngle;

    //小圆的颜色
    private int progressColor;
    //大圆颜色
    private int backgroundColor;

    //进度方案信息
    private float percentTextSize;
    private int   percentTextColor;
    private String progressFormat;

    private RectF rect;

    public CircleProgressBar(Context context) {
        this(context, null);
    }

    public CircleProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressBar, defStyleAttr, 0);
        stripeWidth = a.getDimension(R.styleable.CircleProgressBar_stripeWidth, 0);
        progressColor = a.getColor(R.styleable.CircleProgressBar_progressColor,DEFAULT_PERCENT_COLOR);
        backgroundColor = a.getColor(R.styleable.CircleProgressBar_backgroundColor,DEFAULT_BACKGROUND_COLOR);
        percentTextSize = a.getDimensionPixelSize(R.styleable.CircleProgressBar_progressTextSize,PixUtil.spToPx(DEFAULT_TEXT_SIZE,context));
        radius = a.getDimensionPixelSize(R.styleable.CircleProgressBar_radius,PixUtil.dpToPx(DEFAULT_SIZE,context));
        progressFormat = a.getString(R.styleable.CircleProgressBar_format);
        percentTextColor = a.getInteger(R.styleable.CircleProgressBar_progressTextColor, DEFAULT_TEXT_COLOR);
        max = a.getInteger(R.styleable.CircleProgressBar_max, DEFAULT_MAX);
        progress = a.getInteger(R.styleable.CircleProgressBar_progress, 0);
        a.recycle();
        rect = new RectF(0,0,0,0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int w = widthSize;
        if ( widthMode == MeasureSpec.AT_MOST || w < 0){
            w = (int)radius * 2;
        }
        else if (widthMode == MeasureSpec.EXACTLY){
            w = widthSize;
        }
        else {
            w = 0xFFFFFF;
        }

        int h = heightSize;
        if ( heightMode == MeasureSpec.AT_MOST || h < 0 ){
            h = (int)radius*2;
        }
        else if (heightMode == MeasureSpec.EXACTLY){
            h = heightSize;
        }
        else {
            h = 0xFFFFFF;
        }

        progressWidth = Math.min(w, h);
        if ( progressWidth == 0xFFFFFF ){
            progressWidth = (int)radius * 2;
        }
        progressHeight = progressWidth;

        x = widthSize / 2;
        y = x;
        radius = x;

        setMeasuredDimension(progressWidth, progressHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if( progress > max || max == 0 ){
            return;
        }

        endAngle = (int) ((progress*1.0f/max) * 360.0f);
        //背景
        Paint bigCirclePaint = new Paint();
        bigCirclePaint.setAntiAlias(true);
        bigCirclePaint.setColor(backgroundColor);


        canvas.drawCircle(x, y, radius, bigCirclePaint);


        //饼状图
        Paint sectorPaint = new Paint();
        sectorPaint.setColor(progressColor);
        sectorPaint.setAntiAlias(true);
        rect.right = progressWidth;
        rect.bottom = progressHeight;

        canvas.drawArc(rect, 270, endAngle, true, sectorPaint);


        float stripe = stripeWidth;
        if ((int)stripe == 0){
            stripe = radius;
        }
        //绘制小圆,颜色透明
        Paint smallCirclePaint = new Paint();
        smallCirclePaint.setAntiAlias(true);
        smallCirclePaint.setColor(backgroundColor);
        canvas.drawCircle(x, y, radius - stripe, smallCirclePaint);

        if (progressFormat != null){
            //绘制文本
            Paint textPaint = new Paint();
            String text = String.format(Locale.getDefault(), progressFormat, progress*100/max);

            textPaint.setTextSize(percentTextSize);
            float textLength = textPaint.measureText(text);

            textPaint.setColor(percentTextColor);
            canvas.drawText(text, x - textLength/2, y, textPaint);
        }
    }

    public void setMax(int max){
        this.max = max;
    }

    //外部设置百分比数
    public void setProgress(int progress) {
        this.progress = progress;
        postInvalidate();
    }

}