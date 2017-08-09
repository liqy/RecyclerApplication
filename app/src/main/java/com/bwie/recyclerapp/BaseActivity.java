package com.bwie.recyclerapp;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    protected Unbinder unbinder;
    @NonNull
    @BindView(R.id.toolbar_layout_root)
    protected Toolbar toolbar;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        unbinder=ButterKnife.bind(BaseActivity.this);
        BaseActivity.this.bindToolbar();
    }

    private void bindToolbar() {
        BaseActivity.this.setSupportActionBar(toolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) toolbar.setElevation(0.0f);
        BaseActivity.this.setupToolbar();
    }

    protected void setNavigationIcon(@NonNull Toolbar toolbar, @DrawableRes int drawableId) {
        SomeCompat.setNavigationIcon(toolbar, BaseActivity.this, drawableId);
    }

    protected void polishDrawable(@NonNull Drawable drawable, @ColorRes int color) {
        SomeCompat.polishDrawable(BaseActivity.this, drawable, color);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                BaseActivity.this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }

    public abstract void setupToolbar();


}
