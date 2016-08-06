package com.depromeet.bread.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class HyperTextView extends TextView implements View.OnTouchListener {

    public HyperTextView(Context context) {
        super(context);
        setOnTouchListener(this);
    }
    public HyperTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnTouchListener(this);
    }
    public HyperTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                view.setPressed(true);
                break;
            case MotionEvent.ACTION_UP:
                view.setPressed(false);
                break;
        }
        return true;
    }
}