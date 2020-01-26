package com.example.oriental;

import androidx.appcompat.app.AppCompatActivity;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         textView = findViewById(R.id.textHeader);

         Button button1 = findViewById(R.id.button1);
         button1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
            textView.setText(getScreenOrientation());

             }
         });
    }
    private String getScreenOrientation(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return "Portrait orientation";
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return "Landscape orientation";
        else
            return "";
    }
}
