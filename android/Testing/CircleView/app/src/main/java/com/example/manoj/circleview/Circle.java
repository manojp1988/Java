package com.example.manoj.circleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by manoj on 2/1/17.
 */

public class Circle extends View {

    private int mCircleColor;
    private Paint circlePaint;
    private float radius;

    public Circle(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.Circle,
                0, 0);

        try {
            mCircleColor = a.getColor(R.styleable.Circle_color, Color.BLACK);
        } finally {
            a.recycle();
        }

        init();
    }

    public int getCircleColor() {
        return mCircleColor;
    }

    public void setCircleColor(int mCircleColor) {
        this.mCircleColor = mCircleColor;

        invalidate();
        requestLayout();
    }

    private void init(){

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setColor(mCircleColor);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // Account for padding
        float xpad = (float)(getPaddingLeft() + getPaddingRight());
        float ypad = (float)(getPaddingTop() + getPaddingBottom());

        float ww = (float)w - xpad;
        float hh = (float)h - ypad;

        // Figure out how big we can make the pie.
        radius = Math.min(ww, hh) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        circlePaint.setColor(mCircleColor);
        canvas.drawCircle(getMeasuredWidth()/2,getMeasuredHeight()/2,radius,circlePaint);

    }
}
