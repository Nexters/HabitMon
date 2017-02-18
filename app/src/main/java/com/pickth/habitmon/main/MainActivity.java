package com.pickth.habitmon.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.pickth.habitmon.R;
import com.pickth.habitmon.habit.add.AddHabitAcitivity;
import com.pickth.habitmon.habit.info.HabitInfoActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_ADD = 1;
    ArrayList<HabitListItem> arrList = new ArrayList<>();

    // bind view
    @BindView(R.id.rv_main)
    RecyclerView rvMain;

    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;

    @BindView(R.id.main_draw_layout)
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // actionbar
        {
            setSupportActionBar(mainToolbar);
            final ActionBar actionBar = getSupportActionBar();
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setDisplayShowHomeEnabled(true); // show or hide the default home button
            actionBar.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
            actionBar.setDisplayShowTitleEnabled(false); // disable the default title element here (for centered title)
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        HabitAdapter adapter = new HabitAdapter(arrList);

        rvMain.setLayoutManager(layoutManager);
        rvMain.setAdapter(adapter);
        adapter.onItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getApplicationContext(), HabitInfoActivity.class));
                overridePendingTransition(0,0);
            }
        });

        {
            for(int i=0; i<3; i++) {
                arrList.add(new HabitListItem("",""));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.menu_add:
                startActivityForResult(new Intent(this, AddHabitAcitivity.class), REQUEST_CODE_ADD);
                overridePendingTransition(0,0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_ADD) {

        }
    }


    // 취소버튼 눌렀을 때
    @Override
    public void onBackPressed() {
        // 네비게이션이 열려있으면
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
    }
}
