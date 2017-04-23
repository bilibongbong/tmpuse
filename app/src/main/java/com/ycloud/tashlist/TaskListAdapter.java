package com.ycloud.tashlist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ycloud.tashlist.bean.ProgressTaskData;
import com.ycloud.tashlist.bean.TaskData;
import com.ycloud.tashlist.taskitemholder.ICompleteTaskLister;
import com.ycloud.tashlist.taskitemholder.ProgressTaskItemHolder;
import com.ycloud.tashlist.taskitemholder.TaskHolder;
import com.ycloud.tashlist.taskitemholder.TaskItemHolder;
import com.ycloud.tashlist.taskitemholder.TaskTitleHolder;
import com.ycloud.tashlist.taskitemholder.TreasureBoxPanelHolder;

import java.util.ArrayList;

/**
 * Created by wangshuhe on 2017/4/21.
 */
public class TaskListAdapter extends RecyclerView.Adapter<TaskHolder> {
    private final static String TAG = "TaskListAdapter";
    private final static int Item_Category_TreasureBoxPanel = 0;
    private final static int Item_Category_TaskTitle = 1;
    private final static int Item_Category_FixItemSize = 2;
    private final static int Item_Category_Progress_TaskItem = 3;
    private final static int Item_Category_TaskItem = 4;
    private final static int Item_Category_FootView = 5;

    private ArrayList<TaskData> tasklist;
    private ICompleteTaskLister completeTaskLister;

    public TaskListAdapter(){
        setHasStableIds(true);
    }

    public void setTasklist(ArrayList<TaskData> tasklist) {
        this.tasklist = tasklist;
        notifyDataSetChanged();
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TaskHolder holder = null;
        switch (viewType){
            case Item_Category_TreasureBoxPanel:
                holder = new TreasureBoxPanelHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tasklist_item_treasure_box_pannel,null)
                        ,completeTaskLister
                );
                break;
            case Item_Category_TaskTitle:
                holder = new TaskTitleHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tasklist_title_item,null));
                break;
            case Item_Category_TaskItem:
                holder = new TaskItemHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tasklist_item,null)
                        ,completeTaskLister);
                break;
            case Item_Category_Progress_TaskItem:
                holder = new ProgressTaskItemHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tasklist_progress_item,null)
                        ,completeTaskLister);
                break;
            default:
                holder = new TaskTitleHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_tasklist_footview,null));
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(TaskHolder holder, int position) {
        if ( null == holder ){
            return;
        }
        if ( holder instanceof ProgressTaskItemHolder ){
            ((ProgressTaskItemHolder) holder)
                    .bindData(getItem(position));
        }
        else if ( holder instanceof TaskItemHolder ){
            ((TaskItemHolder) holder).bindData(getItem(position));
        }

    }

    @Override
    public int getItemViewType(int position) {
        if ( position < Item_Category_FixItemSize){
            return position;
        }

        TaskData data = getItem(position);
        if ( null == data ){
            // TODO: 2017/4/23 throw error
            return Item_Category_FootView;
        }
        if (data instanceof ProgressTaskData){
            return Item_Category_Progress_TaskItem;
        }
        return Item_Category_TaskItem;
    }

    private TaskData getItem( int position ){
        int taskItemPosition = position - Item_Category_FixItemSize;
        if ( null == tasklist || taskItemPosition >= tasklist.size()){
            return null;
        }
        return tasklist.get(taskItemPosition);
    }

    @Override
    public long getItemId(int position) {
        if ( position < Item_Category_FixItemSize ){
            return position;
        }

        TaskData data = getItem(position);
        if ( data != null ){
            return data.getTaskId();
        }

        return -1;
    }

    @Override
    public int getItemCount() {
        //没有任务列表，任务title也不显示
        if(tasklist == null || tasklist.size() == 0){
            return 1;
        }

        int count = Item_Category_FixItemSize + tasklist.size();
        return count;
    }

    public void setCompleteTaskLister(ICompleteTaskLister completeTaskLister) {
        this.completeTaskLister = completeTaskLister;
    }
}
