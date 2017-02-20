package com.pickth.habitmon.view.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.pickth.habitmon.R;
import com.pickth.habitmon.databinding.ActivityMainBinding;
import com.pickth.habitmon.dto.HabitListItem;
import com.pickth.habitmon.view.habit.AddHabitActivity;
import com.pickth.habitmon.view.habit.HabitInfoActivity;
import com.pickth.habitmon.view.main.adapter.HabitAdapter;
import com.pickth.habitmon.view.main.presenter.MainContract;
import com.pickth.habitmon.view.main.presenter.MainPresenter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    private static final int REQUEST_CODE_ADD = 1;

    HabitAdapter adapter;
    ArrayList<HabitListItem> arrList = new ArrayList<>();

    // view
    private MainContract.Presenter presenter;
    private ActivityMainBinding binding;
    private DrawerLayout mDrawerLayout;
    private RecyclerView rvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // actionbar
        {
            setSupportActionBar(binding.mainContent.mainToolbar);
            final ActionBar actionBar = getSupportActionBar();
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
            actionBar.setDisplayHomeAsUpEnabled(true);

            actionBar.setDisplayShowHomeEnabled(true); // show or hide the default home button
            actionBar.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
            actionBar.setDisplayShowTitleEnabled(false); // disable the default title element here (for centered title)
        }

        mDrawerLayout = binding.mainDrawLayout;
        rvMain = binding.mainContent.rvMain;

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        adapter = new HabitAdapter(arrList);
        rvMain.setLayoutManager(layoutManager);
        rvMain.setAdapter(adapter);

        presenter = new MainPresenter();
        presenter.attachView(this);
        presenter.setHabitAdapterModel(adapter);
        presenter.setHabitAdapterView(adapter);
        presenter.loadItems(true);
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
                startActivityForResult(new Intent(this, AddHabitActivity.class), REQUEST_CODE_ADD);
                overridePendingTransition(0,0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    // 취소버튼 눌렀을 때
    @Override
    public void onBackPressed() {
        // 네비게이션이 열려있으면
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void startHabitInfoActivity(int position) {
        startActivity(new Intent(getApplicationContext(), HabitInfoActivity.class));
        overridePendingTransition(0,0);
    }
}
