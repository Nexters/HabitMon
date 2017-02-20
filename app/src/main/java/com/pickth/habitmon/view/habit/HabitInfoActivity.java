package com.pickth.habitmon.view.habit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.pickth.habitmon.R;

import butterknife.ButterKnife;

/**
 * Created by Kim on 2017-02-11.
 */

public class HabitInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_info);
        ButterKnife.bind(this);

    }
}
