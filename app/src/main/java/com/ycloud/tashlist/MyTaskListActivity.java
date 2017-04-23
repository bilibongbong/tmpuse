package com.ycloud.tashlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ycloud.tashlist.presenter.IMyTaskListView;
import com.ycloud.tashlist.presenter.MyTaskListPresenter;
import com.ycloud.tashlist.taskitemholder.ICompleteTaskLister;

import java.util.Locale;

public class MyTaskListActivity extends AppCompatActivity implements IMyTaskListView {
    private final static String TAG = "MyTaskListActivity";
    private RecyclerView recyclerViewTaskList;
    private MyTaskListPresenter presenter;
    private TextView myCoinsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_task_list);
        myCoinsView = (TextView) findViewById(R.id.iv_coins);
        recyclerViewTaskList = (RecyclerView) findViewById(R.id.recycleview_task_list);
        recyclerViewTaskList.setLayoutManager(new LinearLayoutManager(this));
        TaskListAdapter adapter = new TaskListAdapter();
        recyclerViewTaskList.setAdapter(adapter);

        presenter = new MyTaskListPresenter(this);
        adapter.setTasklist(presenter.getMyTaskListFromCache());

        adapter.setCompleteTaskLister(new ICompleteTaskLister() {
            @Override
            public void onCompleteTask(int taskId) {
                Log.v(TAG, "taskId:" + taskId);
                presenter.completeTask(taskId);
            }
        });
        myCoinsView.setText(String.format(Locale.getDefault(), "%d", presenter.getMyCoins()));

        findViewById(R.id.tv_to_my_rewords_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2017/4/23 我的奖励页面
            }
        });
    }

    @Override
    public void onTaskCompleteSuccess(int taskId) {
        recyclerViewTaskList.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onTaskCompleteFailed(int taskId, String errorMessage) {

    }
}
