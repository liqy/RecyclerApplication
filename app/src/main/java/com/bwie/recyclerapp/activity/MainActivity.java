package com.bwie.recyclerapp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.bwie.recyclerapp.BaseActivity;
import com.bwie.recyclerapp.R;
import com.bwie.recyclerapp.activity.ItemAnimator.ItemAnimatorActivity;
import com.bwie.recyclerapp.activity.decoration.DecorationActivity;
import com.bwie.recyclerapp.activity.grid.GridActivity;
import com.bwie.recyclerapp.activity.linear.LinearActivity;
import com.bwie.recyclerapp.activity.staggered.StaggeredActivity;
import com.bwie.recyclerapp.activity.swipe.SwipeRefreshActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by SmartDengg on 2016/1/28.
 */
public class MainActivity extends BaseActivity {

    @BindString(R.string.app_name)
    protected String title;
    @BindString(R.string.linear_recyclerView)
    protected String linearString;
    @BindString(R.string.grid_recyclerView)
    protected String gridString;
    @BindString(R.string.staggered_recyclerView)
    protected String staggeredString;
    @BindString(R.string.decoration_recyclerView)
    protected String decorationString;
    @BindString(R.string.item_animator)
    protected String animatorString;
    @BindString(R.string.swipe_recyclerView)
    protected String swipeString;

    @NonNull
    @BindView(R.id.main_layout_linear_btn)
    protected Button linearButton;
    @NonNull
    @BindView(R.id.main_layout_grid_btn)
    protected Button gridButton;
    @NonNull
    @BindView(R.id.main_layout_staggered_btn)
    protected Button staggeredButton;
    @NonNull
    @BindView(R.id.main_layout_decoration_btn)
    protected Button decorationButton;
    @NonNull
    @BindView(R.id.main_layout_animator_btn)
    protected Button animatorButton;
    @NonNull
    @BindView(R.id.main_layout_swipe_btn)
    protected Button swipeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigate_main_layout);

        this.linearButton.setText(linearString);
        this.gridButton.setText(gridString);
        this.staggeredButton.setText(staggeredString);
        this.decorationButton.setText(decorationString);
        this.decorationButton.setText(decorationString);
        this.animatorButton.setText(animatorString);
        this.swipeButton.setText(swipeString);
    }

    @NonNull
    @OnClick(R.id.main_layout_linear_btn)
    void onLinearClick() {
        LinearActivity.navigateToLinearActivity(MainActivity.this);
    }

    @NonNull
    @OnClick(R.id.main_layout_grid_btn)
    void onGridClick() {
        GridActivity.navigateToGridActivity(MainActivity.this);
    }

    @NonNull
    @OnClick(R.id.main_layout_staggered_btn)
    void onStaggeredClick() {
        StaggeredActivity.navigateToStaggeredActivity(MainActivity.this);
    }

    @NonNull
    @OnClick(R.id.main_layout_decoration_btn)
    void onDecorationClick() {
        DecorationActivity.navigateToDecorationActivity(MainActivity.this);
    }

    @NonNull
    @OnClick(R.id.main_layout_animator_btn)
    void onAnimatorClick() {
        ItemAnimatorActivity.navigateToItemAnimatorActivity(MainActivity.this);
    }

    @NonNull
    @OnClick(R.id.main_layout_swipe_btn)
    void onSwipClick() {
        SwipeRefreshActivity.navigateToSwipeRefreshActivity(MainActivity.this);
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(title);
    }
}
