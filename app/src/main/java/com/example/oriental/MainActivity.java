package com.example.oriental;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView textView;
    MediaPlayer mediaPlayerButton1, mediaPlayerButton2, mediaPlayerButton3, mediaPlayerButton4, mediaPlayerButton5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView = findViewById(R.id.textHeader);

        mediaPlayerButton1 = MediaPlayer.create(this, R.raw.cartoon_drum_pounding_bass);
        mediaPlayerButton2 = MediaPlayer.create(this, R.raw.okey_dokey);
        mediaPlayerButton3 = MediaPlayer.create(this, R.raw.cartoon_crow_dogs);
        mediaPlayerButton4 = MediaPlayer.create(this, R.raw.cat_meow);
        mediaPlayerButton5 = MediaPlayer.create(this, R.raw.tromb);

        final Button button1 = findViewById(R.id.button1);
        final Button button2 = findViewById(R.id.button2);
        final Button button3 = findViewById(R.id.button3);
        final Button button4 = findViewById(R.id.button4);
        final Button button5 = findViewById(R.id.button5);
        final Button button6 = findViewById(R.id.button6);


         button1.setOnClickListener(this);
         button2.setOnClickListener(this);
         button6.setOnClickListener(this);

         button3.setOnClickListener(this);
         button4.setOnClickListener(this);
         button5.setOnClickListener(this);
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
                textView.setText(getScreenOrientation());
                mediaPlayerButton1.start(); break;
            case R.id.button2:
                textView.setText(getRotateOrientation());
                mediaPlayerButton2.start(); break;
            case R.id.button6:
                Intent intent = new Intent(MainActivity.this, ButtonOrientActivity.class);
                startActivity(intent); break;
            case R.id.button3:
                mediaPlayerButton3.start(); break;
            case R.id.button4:
                mediaPlayerButton4.start(); break;
            case R.id.button5:
                mediaPlayerButton5.start(); break;

        }

    }
}
