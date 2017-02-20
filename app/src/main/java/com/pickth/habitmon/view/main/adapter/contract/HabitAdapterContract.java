package com.pickth.habitmon.view.main.adapter.contract;


import com.pickth.habitmon.dto.HabitListItem;
import com.pickth.habitmon.util.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by Kim on 2017-02-20.
 */

public interface HabitAdapterContract {
    interface View {
        void setOnClickListener(OnItemClickListener clickListener);
    }

    interface Model {
        void addItems(ArrayList<HabitListItem> items);

        void clearItem();

        HabitListItem getItem(int position);
    }
}
