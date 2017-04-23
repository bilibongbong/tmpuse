package com.ycloud.tashlist.bean;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class ProgressTaskData extends TaskData {
    private final static String TAG = "ProgressTaskData";

    private int progess = 0;
    private int total = 0;

    public int getProgess() {
        return progess;
    }

    public void setProgess(int progess) {
        this.progess = progess;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
