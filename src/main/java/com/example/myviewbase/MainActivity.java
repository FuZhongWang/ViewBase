package com.example.myviewbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyRelativeLayout titleBar = getTitleBar();
        TextView biaoti = titleBar.findViewById(R.id.biaoti);
        biaoti.setText("罗征百战无敌");

    }

    @Override
    public void intiView() {

    }

    @Override
    public void intiData() {

    }

    @Override
    public int getThis() {
        return R.layout.activity_main;
    }

    @Override
    public int setChildContentView() {
        return 0;
    }
}
