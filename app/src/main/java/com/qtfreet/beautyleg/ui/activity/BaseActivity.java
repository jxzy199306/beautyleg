package com.qtfreet.beautyleg.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by qtfreet00 on 2016/6/16.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        getToolbar();
        AddActivityToList();
    }


    protected void initView(){

    }

    protected void getToolbar(){


    }

    protected void AddActivityToList(){

    }
}
