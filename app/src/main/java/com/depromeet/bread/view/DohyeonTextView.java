package com.depromeet.bread.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class DohyeonTextView extends TextView {

    public DohyeonTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), "BMDOHYEON.ttf"));
    }
}