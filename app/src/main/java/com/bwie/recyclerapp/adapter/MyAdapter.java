package com.bwie.recyclerapp.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.recyclerapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by liqy on 2017/8/9.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<String> list;


    public MyAdapter(List<String> list) {
        this.list = list;
    }

    /**
     * 初始化视图
     *
     * @param parent
     * @param viewType 多条目加载需要判断
     * @return
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my, parent, false);
        return new MyViewHolder(view);
    }

    /**
     * 将数据展示绑定到View
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String str = list.get(position);
        holder.hello.setText(str);

    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.hello)
        TextView hello;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
