package com.example.oriental;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView = findViewById(R.id.textHeader);

        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);

         button1.setOnClickListener(this);
         button2.setOnClickListener(this);
    }

    private String getScreenOrientation(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return "Portrait orientation.";
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return "Landscape orientation.";
        else
            return "";
    }
// Раньше существовал аналогичный метод getOrientation(), который устарел. Используйте getRotation()

    private String getRotateOrientation(){
        int rotate = getWindowManager().getDefaultDisplay().getRotation();
        switch (rotate) {
            case Surface.ROTATION_0:
                return "The screen has not been rotated.";
            case Surface.ROTATION_90:
                return "The screen has been rotated 90 degrees clockwise.";
            case Surface.ROTATION_180:
                return "The screen has been rotated 180 degrees.";
            case Surface.ROTATION_270:
                return "The screen has been rotated 90 degrees counterclockwise.";
                        default:
                            return "It is unclear whether the screen has been rotated.";
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                textView.setText(getScreenOrientation()); break;
            case R.id.button2:
                textView.setText(getRotateOrientation()); break;
        }
    }
}
