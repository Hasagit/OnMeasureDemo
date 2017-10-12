package com.measuredemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DengJf on 2017/10/12.
 */

public class MyView extends View{
    private int mhight,mwidth;
    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        //自定义属性
        mhight = array.getDimensionPixelSize(R.styleable.MyView_default_hight, 100);
        mwidth = array.getDimensionPixelSize(R.styleable.MyView_default_width, 100);
        array.recycle();  //释放资源
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getMyViewDefaultSize(mwidth, widthMeasureSpec),
                getMyViewDefaultSize(mhight, heightMeasureSpec));
    }

    //重写getDefaultSize
    public int getMyViewDefaultSize(int size, int measureSpec) {
        int result = size;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.UNSPECIFIED:
                result = size;
                break;
            case MeasureSpec.AT_MOST:
                result=size;
                break;
            case MeasureSpec.EXACTLY:
                result = specSize;
                break;
        }
        return result;
    }
}
