package com.pickth.habitmon.view.main.presenter;

import com.pickth.habitmon.view.main.adapter.contract.HabitAdapterContract;

/**
 * Created by Kim on 2017-02-20.
 */

public interface MainContract {
    interface View {
        void startHabitInfoActivity(int position);
    }

    interface Presenter {
        void attachView(View view);

        void setHabitAdapterModel(HabitAdapterContract.Model adapterModel);

        void setHabitAdapterView(HabitAdapterContract.View adapterView);

        void loadItems(boolean isClear);
    }
}
