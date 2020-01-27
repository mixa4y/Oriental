package com.example.oriental;

import androidx.appcompat.app.AppCompatActivity;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ButtonOrientActivity extends AppCompatActivity {

    private Button mButton;
    private static final String ORIENTATION_PORTRAIT = "To set the Portrait mode";
    private static final String ORIENTATION_LANDSCAPE = "To set Landscape mode";


    private boolean mState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_orient);

        mButton = findViewById(R.id.buttonChange);

        // ***установим текст по умолчанию***
        mButton.setText(ORIENTATION_LANDSCAPE);

    }

    public void onClick(View view) {
// state FALSE: переключаемся на LANDSCAPE
        if (!mState) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            mButton.setText(ORIENTATION_PORTRAIT);
        }
        // state TRUE: переключаемся на PORTRAIT
        else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            mButton.setText(ORIENTATION_LANDSCAPE);
        }
        // обновляем state на противоположное значение
        mState = !mState;
       }

}
