package com.bwie.recyclerapp.activity.grid;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;


import com.bwie.recyclerapp.BaseActivity;
import com.bwie.recyclerapp.IconsHelper;
import com.bwie.recyclerapp.R;
import com.bwie.recyclerapp.adapter.DrawableAdapter;
import com.bwie.recyclerapp.decoration.MarginDecoration;

import butterknife.BindString;
import butterknife.BindView;

/**
 * Created by SmartDengg on 2016/1/29.
 */
public class GridAutoFixActivity extends BaseActivity {

    @NonNull
    @BindString(R.string.grid_recyclerView_auto_fix)
    protected String title;

    @NonNull
    @BindView(R.id.autofix_recycler_layout_rv)
    protected RecyclerView recyclerView;

    public static void navigateToGridAutoFixActivity(BaseActivity startingActivity) {
        startingActivity.startActivity(new Intent(startingActivity, GridAutoFixActivity.class));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_autofix_layout);
        GridAutoFixActivity.this.initView();
    }

    private void initView() {

        recyclerView.addItemDecoration(new MarginDecoration(GridAutoFixActivity.this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(
                DrawableAdapter.created(GridAutoFixActivity.this, IconsHelper.CAT_ICONS, DrawableAdapter.BLUE));
    }

    @Override
    public void setupToolbar() {
        getSupportActionBar().setTitle(title);

        GridAutoFixActivity.this.setNavigationIcon(toolbar, R.drawable.ic_arrow_back);
        GridAutoFixActivity.this.polishDrawable(toolbar.getNavigationIcon(), android.R.color.white);
    }
}
