# [Android] Custom UI
This project provide for android developer to know the easier way to understand customize UI. 
Please let me know if any suggestion or if you have better idea to let people know custom android UI.  
Thanks




## Why upload this example
This example is modified base on https://www.tutorialspoint.com/android/android_custom_components.htm  

Since there is no formal information about android custom simple ui, I put the sample as simple as it can be.  
Hope this example can help other people to understand custom ui on android.

## Implementation



1. Create attrs.xml under (ws)\res\values if it does not exist.  
Code:

	```
		<?xml version="1.0" encoding="utf-8"?>
		<resources>
		    <declare-styleable name="TimeView">
		        <attr name="title" format="string" />
		        <attr name="setColor" format="boolean"/>
		    </declare-styleable>
		
		</resources>
	```

1. Create your self-defined class example: *TimeView.class* 

	```
    public TimeView(Context context) {
        super(context);
    }

    public TimeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
	```

	* context.obtainStyledAttributes(attrs,
                R.styleable.TimeView); used to get the user defined attributes
	* You can check setTimeViewAttributes below. We get the typed attary first and go through to get each defined class we defined in attrs.xml

	```
    private void setTimeViewAttributes(TypedArray typedArray) {
        int count = typedArray.getIndexCount();
        try{
            for (int i = 0; i < count; ++i) {
                int attr = typedArray.getIndex(i);

                // Handle xml user defined attributes
                if (attr == R.styleable.TimeView_title) {
                    title = typedArray.getString(attr);
                    setText("["+ time() +"]" + " Get custom title from xml:" + title);

                } else if(attr == R.styleable.TimeView_setColor) {
                    color = typedArray.getBoolean(attr, false);
                    setColor(color);
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "setTimeViewAttributes e=" + e);
        }
    }
	```

	* You can skip other classes in TimeView class
1. Just add user defined UI component inside activity_main.xml

	```
    <com.example.atlas_huang.customuidemo.TimeView
    	...
        android:id="@+id/timeView"
        android:textSize="20sp"
        custom:title="(TimeView custom title from xml)"
        custom:setColor="true"/>
	```

	Rember to add 
	
	```
	<android.support.constraint.ConstraintLayout
	...
    xmlns:custom="http://schemas.android.com/apk/res-auto"
   ```
1. You can run your application finally

![Screenshot](https://raw.githubusercontent.com/Atlas0904/Project_Android_CustomUi/master/screenshot_20170403_171545.png)


# Postscript
1. 2017/04/03 add the 1st version