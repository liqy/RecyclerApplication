package com.bwie.recyclerapp.activity.linear;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.bwie.recyclerapp.BaseActivity;
import com.bwie.recyclerapp.IconsHelper;
import com.bwie.recyclerapp.R;
import com.bwie.recyclerapp.adapter.DrawableAdapter;
import com.bwie.recyclerapp.adapter.MyAdapter;
import com.bwie.recyclerapp.decoration.MarginDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindString;
import butterknife.BindView;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class LinearVerticalActivity extends BaseActivity {

    @NonNull
    @BindString(R.string.linear_recyclerView_vertical)
    protected String title;

    @NonNull
    @BindView(R.id.main_recycler_layout_rv)
    protected RecyclerView recyclerView;

    public static void navigateToVerticalActivity(BaseActivity startingActivity) {
        startingActivity.startActivity(new Intent(startingActivity, LinearVerticalActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_main_layout);
        LinearVerticalActivity.this.initView();
    }

    /**
     * UI 初始化
     */
    private void initView() {

        //布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(LinearVerticalActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.setSmoothScrollbarEnabled(true);

        //分割先装饰器
        recyclerView.addItemDecoration(new MarginDecoration(LinearVerticalActivity.this));
        recyclerView.setHasFixedSize(true);

        //布局管理器一定要在setAdapter之前
        recyclerView.setLayoutManager(layoutManager);

//        recyclerView.setAdapter(
//                DrawableAdapter.created(LinearVerticalActivity.this, IconsHelper.ICONS, DrawableAdapter.ORANGE));

        List<String> list=new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add("第"+i+"条");
        }

        recyclerView.setAdapter(new MyAdapter(list));


    }

    /**
     * 标题栏
     */
    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(title);
        LinearVerticalActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
        LinearVerticalActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
    }
}
