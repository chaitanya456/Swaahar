package com.example.swaahar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    ProgressBar pb;
    TextView tv;
    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        tv=(TextView)findViewById(R.id.calorie_text);
        pb=(ProgressBar)findViewById(R.id.progress_bar);
        final Handler hd=new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (i <= 100) {
                    tv.setText(Integer.toString(i));
                    pb.setProgress(i);
                    i++;
                    hd.postDelayed(this,100);
                }
                else
                {
                    hd.removeCallbacks(this);
                }
            }
        },100);
        //Here i value is based on calorie , if calorie intake(Retrieval) is n much, Based on his consumption, we will set Progress bar
//        i=55;
//        if(i==57)
//            pb.setProgress(75);
//        else pb.setProgress(90);

  }

}