package com.vaiuu.androidcrashlogger;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

public class MainActivity extends Activity {
    private String crashTEST;
    private ImageView crash_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this));
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main);

        crash_image = (ImageView) findViewById(R.id.crash_image);
        crash_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("CRASHLOG", crashTEST);
                Log.i("CRASHLOG", crashTEST);

            }
        });

    }


}
