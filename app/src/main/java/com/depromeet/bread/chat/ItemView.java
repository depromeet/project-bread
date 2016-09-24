package com.depromeet.bread.chat;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.depromeet.bread.R;

/**
 * Created by 권윤환 on 2016-09-14.
 */
public class ItemView extends FrameLayout {

    public ItemView(Context context) {
        super(context);
        init();
    }

    public ItemView(Context context, AttributeSet attrs ){
        super( context, attrs);
        init();
    }

    ImageView message_img;
    TextView  message_text;
    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.chat_message,this);
        message_img = (ImageView)findViewById(R.id.message_img);
        message_text = (TextView)findViewById(R.id.message_text);
    }

    ItemData mData;
    public void setItemData( ItemData data ) {
        mData = data;
        message_img.setImageResource(data.imgId);
        message_text.setText(data.message);
    }

}

class ItemData {
    public int imgId;
    public String message;

    public ItemData (String text){
        this.message = text;
    }
}
