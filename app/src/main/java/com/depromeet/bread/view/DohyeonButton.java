package com.depromeet.bread.view;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.TextView;

public class DohyeonButton extends Button {

    public DohyeonButton(Context context) {
        super(context);
        init();
    }
    public DohyeonButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public DohyeonButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void init() {
        setTypeface(Typeface.createFromAsset(getContext().getAssets(), "BMDOHYEON.ttf"));
    }
}