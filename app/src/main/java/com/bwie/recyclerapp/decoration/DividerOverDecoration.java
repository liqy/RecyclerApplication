package com.bwie.recyclerapp.decoration;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.bwie.recyclerapp.R;


/**
 * 感谢http://stackoverflow.com/questions/24618829/how-to-add-dividers-and-spaces-
 * between-items-in-recyclerview/27037230#27037230
 */
//继承RecyclerView.ItemDecoration
public class DividerOverDecoration extends RecyclerView.ItemDecoration {

    private Context context;
    private Drawable mDivider;

    public DividerOverDecoration(Context context) {
        this.context = context;

        TypedValue typedValue = new TypedValue();
        if (context.getTheme()
                .resolveAttribute(android.R.attr.listDivider, typedValue, true) && typedValue.data != 0) {
            this.mDivider = context.getResources()
                    .getDrawable(typedValue.resourceId);
        }
    }

    public DividerOverDecoration(Context context, int resId) {
        this.context = context;
        mDivider = ContextCompat.getDrawable(context, resId);
    }

    /**
     * 绘制边距
     * @param outRect
     * @param view
     * @param parent
     * @param state
     */
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
    }




    /**
     * 绘制分割线
     * @param c
     * @param parent
     * @param state
     */
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {

        int left = parent.getPaddingLeft() + context.getResources()
                .getDimensionPixelOffset(R.dimen.material_24dp);
        int right = parent.getWidth() - parent.getPaddingRight() - context.getResources()
                .getDimensionPixelOffset(R.dimen.material_24dp);

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            if (i % 2 == 0) {
                View child = parent.getChildAt(i);

                RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getBottom() + params.bottomMargin;
                int bottom = top + mDivider.getIntrinsicHeight();

                mDivider.setBounds(left, top, right, bottom);
                mDivider.draw(c);
            }
        }
    }
}