package com.example.myviewbase;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyRelativeLayout extends RelativeLayout {

    private TextView textView;
    private ImageView imageView;
    private Button button;

    public MyRelativeLayout(Context context) {
        this(context,null);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intiView(context);
    }
    public void intiView(Context context){

        textView = new TextView(context);
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textView.setId(R.id.biaoti);
        textView.setText("标题");
        textView.setTextColor(Color.WHITE);
        addView(textView,layoutParams);
        imageView = new ImageView(context);
        imageView.setId(R.id.zuotu);
        imageView.setImageResource(R.drawable.djufgz);
        LayoutParams layoutParams1 = new LayoutParams(100, 100);
        layoutParams1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        layoutParams1.leftMargin=20;
        addView(imageView,layoutParams1);
        button = new Button(context);
        button.setText("提交");
        LayoutParams layoutParams2 = new LayoutParams(100, 100);
        button.setId(R.id.youtu);
        layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        layoutParams2.rightMargin=20;
        addView(button,layoutParams2);

    }
    public ImageView getImageView(){

        return imageView;
    }

    public TextView getTextView() {
        return textView;
    }

    public Button getButton() {
        return button;
    }
}
