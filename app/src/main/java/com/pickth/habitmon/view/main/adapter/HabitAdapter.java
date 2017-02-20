package com.pickth.habitmon.view.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.pickth.habitmon.dto.HabitListItem;
import com.pickth.habitmon.util.OnItemClickListener;
import com.pickth.habitmon.view.main.adapter.contract.HabitAdapterContract;
import com.pickth.habitmon.view.main.adapter.holder.HabitViewHolder;

import java.util.ArrayList;

/**
 * Created by Kim on 2017-02-11.
 */

public class HabitAdapter extends RecyclerView.Adapter<HabitViewHolder> implements HabitAdapterContract.View, HabitAdapterContract.Model{
    ArrayList<HabitListItem> arrList;
    private OnItemClickListener onItemClickListener;

    public HabitAdapter(ArrayList arrList) {
        this.arrList = arrList;
    }

    @Override
    public HabitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HabitViewHolder(parent, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(HabitViewHolder holder, int position) {
        holder.onBind(getItem(position), position);
    }

    @Override
    public int getItemCount() {
        return arrList.size();
    }

    @Override
    public void addItems(ArrayList<HabitListItem> arrList) {
        this.arrList = arrList;
        notifyDataSetChanged();
    }

    @Override
    public void clearItem() {
        if(arrList != null) {
            arrList.clear();
        }
    }

    @Override
    public HabitListItem getItem(int position) {
        return arrList.get(position);
    }

    @Override
    public void setOnClickListener(OnItemClickListener clickListener) {
        onItemClickListener = clickListener;
    }
}
