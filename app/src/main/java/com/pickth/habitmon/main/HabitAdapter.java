package com.pickth.habitmon.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.pickth.habitmon.R;
import com.pickth.habitmon.util.FontUtil;

import java.util.ArrayList;

/**
 * Created by Kim on 2017-02-11.
 */

public class HabitAdapter extends RecyclerView.Adapter<HabitAdapter.HabitViewHolder> {
    ArrayList<HabitListItem> arrList;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    public HabitAdapter(ArrayList arrList) {
        this.arrList = arrList;
    }

    @Override
    public HabitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext())
                .inflate(R.layout.row_main_habit, parent, false);

        FontUtil.setGlobalFont(parent.getContext(), itemView);
        return new HabitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HabitViewHolder holder, int position) {
        HabitListItem item = arrList.get(position);
//        holder.tvHabitTitle.setText(item.getTitle());
//        holder.tvHabitExplanation.setText(item.getExplanation());
    }

    public void onItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private void onItemHolderClick(HabitViewHolder itemHolder) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(null, itemHolder.itemView,
                    itemHolder.getAdapterPosition(), itemHolder.getItemId());
        }
    }

    @Override
    public int getItemCount() {
        return arrList.size();
    }

    public class HabitViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvHabitTitle;
        TextView tvHabitExplanation;

        public HabitViewHolder(View itemView) {
            super(itemView);
            tvHabitTitle = (TextView) itemView.findViewById(R.id.tv_habit_title);
            tvHabitExplanation = (TextView)itemView.findViewById(R.id.tv_habit_explanation);
        }

        @Override
        public void onClick(View view) {
            onItemHolderClick(this);
        }
    }
}
