package com.qtfreet.beautyleg.ui.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.TextView;

import com.pgyersdk.update.PgyUpdateManager;
import com.qtfreet.beautyleg.R;
import com.qtfreet.beautyleg.ui.App;
import com.qtfreet.beautyleg.ui.adapter.FragmentAdapter;
import com.qtfreet.beautyleg.ui.fragment.GirlFragment;
import com.qtfreet.beautyleg.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbar1)
    Toolbar toolbar;
    @BindView(R.id.title_name)
    TextView toolbarTitle;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab)
    TabLayout tabLayout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        PgyUpdateManager.register(this);
    }

    @Override
    protected void AddActivityToList() {
        super.AddActivityToList();
        App.getInstance().addActivity(MainActivity.this);
    }

    private void initData() {

        List<String> titles = new ArrayList<>();
        titles.add("秀人网");
        titles.add("BeautyLeg");
        titles.add("ROSI");
        titles.add("AISS");
        titles.add("BOLUOLI");
        titles.add("丝宝");
        titles.add("丝间");
        titles.add("推女郎");
        titles.add("尤果");
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(GirlFragment.newFragment(GirlFragment.XIUREN));
        fragments.add(GirlFragment.newFragment(GirlFragment.BL));
        fragments.add(GirlFragment.newFragment(GirlFragment.ROSI));
        fragments.add(GirlFragment.newFragment(GirlFragment.AISS));
        fragments.add(GirlFragment.newFragment(GirlFragment.BOLUOLI));
        fragments.add(GirlFragment.newFragment(GirlFragment.SIBAO));
        fragments.add(GirlFragment.newFragment(GirlFragment.SIJIAN));
        fragments.add(GirlFragment.newFragment(GirlFragment.TUI));
        fragments.add(GirlFragment.newFragment(GirlFragment.YOUGUO));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(3)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(4)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(5)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(6)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(7)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(8)));
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragments, titles));
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    protected void initView() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            if (toolbarTitle != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
                toolbarTitle.setText(R.string.main_title);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //捕获返回键按下的事件
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Utils.showDialog(this, "确定要退出了吗?");
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
