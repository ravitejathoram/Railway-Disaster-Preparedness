package com.example.teju.disasterpreparedness;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ProgressBar;

/**
 * Created by teju on 12/25/2015.
 */
public class Splash extends Activity {
    private ProgressBar mProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        mProgress=(ProgressBar)findViewById(R.id.progressBar);
        mProgress.getIndeterminateDrawable().setColorFilter(Color.parseColor("#800000"), android.graphics.PorterDuff.Mode.SRC_ATOP);
        Thread time=new Thread(){
            public void run(){try {
               // sleep(5000);
                doWork();
                startApp();
                finish();
            } finally
            {
                Intent openApp=new Intent(Splash.this,DisasterPreparedness.class);
                startActivity(openApp);
            }
            }};
        time.start();

    }
    private void doWork() {
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(1000);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(Splash.this, DisasterPreparedness.class);
        startActivity(intent);
    }
    /*protected  void onPause()
    {
        super.onPause();
        finish();
    }*/
}
