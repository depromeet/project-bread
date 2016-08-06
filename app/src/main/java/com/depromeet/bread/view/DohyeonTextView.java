package com.depromeet.bread.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class DohyeonTextView extends TextView {

    public DohyeonTextView(Context context) {
        super(context);
        init();
    }
    public DohyeonTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public DohyeonTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), "BMDOHYEON.ttf"));
    }
}