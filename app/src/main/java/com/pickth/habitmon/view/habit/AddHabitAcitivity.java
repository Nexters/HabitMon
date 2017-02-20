package com.pickth.habitmon.view.habit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.pickth.habitmon.R;
import com.pickth.habitmon.util.FontUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.pickth.habitmon.R.id.btn_add_day_0;

/**
 * Created by Kim on 2017-02-17.
 */

public class AddHabitAcitivity extends AppCompatActivity implements View.OnClickListener{
    private boolean[] selectedDay = new boolean[7];

    @BindView(R.id.tv_toolbar_text)
    TextView tvToolbarText;
    @BindView(R.id.base_toolbar)
    Toolbar baseToolbar;

    @BindView(btn_add_day_0)
    Button btnAddDay0;
    @BindView(R.id.btn_add_day_1)
    Button btnAddDay1;
    @BindView(R.id.btn_add_day_2)
    Button btnAddDay2;
    @BindView(R.id.btn_add_day_3)
    Button btnAddDay3;
    @BindView(R.id.btn_add_day_4)
    Button btnAddDay4;
    @BindView(R.id.btn_add_day_5)
    Button btnAddDay5;
    @BindView(R.id.btn_add_day_6)
    Button btnAddDay6;
    @BindView(R.id.btn_every_day)
    Button btnEveryDay;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
        ButterKnife.bind(this);

        // actionbar
        {
            setSupportActionBar(baseToolbar);
            final ActionBar actionBar = getSupportActionBar();
            actionBar.setHomeAsUpIndicator(R.drawable.ic_back);
            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setDisplayShowHomeEnabled(true); // show or hide the default home button
            actionBar.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
            actionBar.setDisplayShowTitleEnabled(false); // disable the default title element here (for centered title)

            tvToolbarText.setText("새로운 습관");
        }

        {
            FontUtil.setGlobalFont(this,getWindow().getDecorView());

            btnAddDay0.setOnClickListener(this);
            btnAddDay1.setOnClickListener(this);
            btnAddDay2.setOnClickListener(this);
            btnAddDay3.setOnClickListener(this);
            btnAddDay4.setOnClickListener(this);
            btnAddDay5.setOnClickListener(this);
            btnAddDay6.setOnClickListener(this);
            btnEveryDay.setOnClickListener(this);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,0);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        Button btn = (Button)view;
        int num = 0;
        switch (id) {
            case R.id.btn_add_day_0:
            case R.id.btn_add_day_1:
            case R.id.btn_add_day_2:
            case R.id.btn_add_day_3:
            case R.id.btn_add_day_4:
            case R.id.btn_add_day_5:
            case R.id.btn_add_day_6:
                break;
        }
        if(btn.isSelected()) {
            // 선택되어 있다면
            btn.setTextColor(getResources().getColor(R.color.colorMainGray));
            btn.setSelected(false);
        } else {
            btn.setTextColor(getResources().getColor(R.color.colorWhite));
            btn.setSelected(true);
        }
//        btn.setSelected(!btn.isSelected());
    }
}
