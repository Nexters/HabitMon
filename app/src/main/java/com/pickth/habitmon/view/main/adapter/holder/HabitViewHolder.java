package com.pickth.habitmon.view.main.adapter.holder;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pickth.habitmon.R;
import com.pickth.habitmon.databinding.RowMainHabitBinding;
import com.pickth.habitmon.dto.HabitListItem;
import com.pickth.habitmon.util.FontUtil;
import com.pickth.habitmon.util.OnItemClickListener;


/**
 * Created by Kim on 2017-02-20.
 */

public class HabitViewHolder extends RecyclerView.ViewHolder {
    private OnItemClickListener onItemClickListener;
    RowMainHabitBinding binding;

    public HabitViewHolder(ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.row_main_habit, parent, false));
        binding = DataBindingUtil.bind(itemView);

        this.onItemClickListener = onItemClickListener;

        FontUtil.setGlobalFont(parent.getContext(), itemView);
    }

    public void onBind(HabitListItem item, final int position) {
        binding.setHabit(item);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });
    }
}