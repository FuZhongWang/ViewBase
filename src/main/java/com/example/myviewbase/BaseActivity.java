package com.example.myviewbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {

    private MyRelativeLayout myRelativeLayout;
    private TextView textView;
    private ImageView imageView;
    private Button button;
    private int aThis;
    private FrameLayout fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);
        int i = getThis();
        View main = LayoutInflater.from(this).inflate(i, null);
        initParentView();
        fragment.addView(main);

    }
    public MyRelativeLayout getTitleBar(){

        return myRelativeLayout;
    }
    public abstract void intiView();
    public abstract void intiData();
    public abstract int getThis();
    public abstract int setChildContentView();
    public void initParentView(){
        fragment = findViewById(R.id.fragment);
        myRelativeLayout = findViewById(R.id.MyRelative);
        textView = myRelativeLayout.getTextView();
        imageView = myRelativeLayout.getImageView();
        button = myRelativeLayout.getButton();
        aThis = getThis();
        View inflate = LayoutInflater.from(this).inflate(aThis, null);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(BaseActivity.this,"此处没有什么功能",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
