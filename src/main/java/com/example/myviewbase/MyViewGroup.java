package com.example.myviewbase;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyViewGroup extends ViewGroup {
    private int mMarginTop = 10;
    int mTop =50;
    public MyViewGroup(Context context) {
        this(context,null);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int viewHeight = 0;
        int viewWidth = 0 ;
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        switch (heightMode){
            case MeasureSpec.AT_MOST:
                for (int i = 0; i <getChildCount() ; i++) {
                    View childAt = getChildAt(i);
                    int measuredHeight = childAt.getMeasuredHeight();
                    viewHeight+=measuredHeight+mMarginTop;
                }


                viewHeight +=mTop * 2 - mMarginTop;
                ;break;
            case MeasureSpec.EXACTLY:
                viewHeight=heightSize;
                ;break;
            case MeasureSpec.UNSPECIFIED:

                ;break;



        }
        switch (widthMode){
            case MeasureSpec.AT_MOST:
                View childAt = getChildAt(0);
                int measuredWidth = childAt.getMeasuredWidth();
                viewWidth=  measuredWidth;


                ;break;
            case MeasureSpec.EXACTLY:
                viewWidth=widthSize;
                ;break;
            case MeasureSpec.UNSPECIFIED:

                ;break;



        }
        setMeasuredDimension(viewWidth,viewHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        int ftop = mTop;
        int marginTop = mMarginTop;
        int marginLeft = 50;
        for (int i = 0; i < getChildCount(); i++) {

            View childAt = getChildAt(i);

            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();

            childAt.layout(marginLeft, ftop, marginLeft + measuredWidth, ftop + measuredHeight);
            ftop += measuredHeight + marginTop;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }
}
