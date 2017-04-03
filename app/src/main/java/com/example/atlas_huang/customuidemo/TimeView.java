package com.example.atlas_huang.customuidemo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;


/**
 * Created by atlas_huang on 2017/4/3.
 */

public class TimeView extends TextView {

    private static final String TAG = TimeView.class.getSimpleName();
    private String titleText;
    private boolean color;
    private String title;

    public TimeView(Context context) {
        super(context);
    }

    public TimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // retrieved values correspond to the positions of the attributes
        TypedArray typedArray = context.obtainStyledAttributes(attrs,
                R.styleable.TimeView);

        setTimeViewAttributes(typedArray);

        // the recycle() will be executed obligatorily for reuse
        typedArray.recycle();
    }

    private void setTimeViewAttributes(TypedArray typedArray) {
        int count = typedArray.getIndexCount();
        try{
            for (int i = 0; i < count; ++i) {
                int attr = typedArray.getIndex(i);

                // Handle xml user defined attributes
                if (attr == R.styleable.TimeView_title) {
                    titleText = typedArray.getString(attr);
                    setText("["+ time() +"]" + " Get custom title from xml:" + titleText);

                } else if(attr == R.styleable.TimeView_setColor) {
                    color = typedArray.getBoolean(attr, false);
                    setColor(color);
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "setTimeViewAttributes e=" + e);
        }
    }

    public TimeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @TargetApi(Build.VERSION_CODES.N)
    private String time() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        return simpleDateFormat.format(Calendar.getInstance().getTime());
    }

    private void setColor(boolean set) {
        if(set == true){
            // set the characteristics and the color of the shadow
            setBackgroundColor(Color.DKGRAY);
        } else {
            setBackgroundColor(Color.RED);
        }
    }

    public void setTitle(String title) {
        this.title = title;
        setText(this.title + " " + time());
    }
}
