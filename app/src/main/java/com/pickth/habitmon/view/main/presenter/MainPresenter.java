package com.pickth.habitmon.view.main.presenter;


import com.pickth.habitmon.dto.HabitListItem;
import com.pickth.habitmon.util.OnItemClickListener;
import com.pickth.habitmon.view.main.adapter.contract.HabitAdapterContract;

import java.util.ArrayList;

/**
 * Created by Kim on 2017-02-20.
 */

public class MainPresenter implements MainContract.Presenter, OnItemClickListener {
    private MainContract.View view;
    private HabitAdapterContract.Model adapterModel;
    private HabitAdapterContract.View adapterView;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void setHabitAdapterModel(HabitAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setHabitAdapterView(HabitAdapterContract.View adapterView) {
        this.adapterView = adapterView;

        this.adapterView.setOnClickListener(this);
    }

    @Override
    public void loadItems(boolean isClear) {
        ArrayList<HabitListItem> arrList = new ArrayList<>();
        if(isClear) {
            adapterModel.clearItem();
        }
        for(int i=0; i<3; i++) {
            arrList.add(new HabitListItem("시간"+i,"내용"+i));
        }
        adapterModel.addItems(arrList);
    }

    @Override
    public void onItemClick(int position) {
        HabitListItem item = adapterModel.getItem(position);
        this.view.startHabitInfoActivity(position);
    }
}
