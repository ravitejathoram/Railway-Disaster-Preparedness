package com.example.teju.disasterpreparedness;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teju.disasterpreparedness.mData.MyPost;
import com.example.teju.disasterpreparedness.mFB.Login;
import com.example.teju.disasterpreparedness.mFB.MyConfiguration;
import com.facebook.FacebookSdk;
import com.sromku.simple.fb.SimpleFacebook;


public class MainActivity extends AppCompatActivity {

    SimpleFacebook fb; //an object to create a simple facebook instance
    Button post; //post button
    EditText et1,et2,et3; //subject and description editexts
    Toolbar tb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.initializeFB(); //intializes all elements in the activity_main.xml
        FacebookSdk.sdkInitialize(getApplicationContext());//intializing fb sdk
        setContentView(R.layout.activity_main);
        post=(Button)findViewById(R.id.button);
        et1=(EditText)findViewById(R.id.editText);
        et2=(EditText)findViewById(R.id.editText2);
        //et3=(EditText)findViewById(R.id.editText3);
        tb=(Toolbar)findViewById(R.id.toll);
        setSupportActionBar(tb);
        getSupportActionBar().setTitle("Social Share");
        tb.setTitleTextColor(Color.WHITE);
        tb.setLogo(R.mipmap.fb);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // login();
                MyPost myPost =new MyPost();
                myPost.setName(et1.getText().toString());
                myPost.setDescrip(et2.getText().toString());
                new Login(fb,MainActivity.this,myPost).login();

            }
        });

    }

    private void initializeFB() {
        SimpleFacebook.setConfiguration(new MyConfiguration().getMyConfig());
        fb= SimpleFacebook.getInstance(this);

    }


    @Override
    protected void onResume() {
        super.onResume();
        fb= SimpleFacebook.getInstance(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        fb.onActivityResult(requestCode,resultCode,data);
    }
}
