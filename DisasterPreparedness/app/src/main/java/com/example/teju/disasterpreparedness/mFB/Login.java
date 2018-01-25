package com.example.teju.disasterpreparedness.mFB;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.teju.disasterpreparedness.mData.MyPost;
import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.listeners.OnLoginListener;

import java.util.List;

/**
 * Created by teju on 3/5/2017.
 */
public class Login {

    SimpleFacebook fb;
    Context c;
    MyPost myPost;

    public Login(SimpleFacebook fb, Context c, MyPost myPost) {
        this.fb = fb;
        this.c = c;
        this.myPost = myPost;
    }

    OnLoginListener loginListener=new OnLoginListener() {
        @Override
        public void onLogin(String accessToken, List<Permission> acceptedPermissions, List<Permission> declinedPermissions) {
            Toast.makeText(c, "logged IN", Toast.LENGTH_SHORT).show();

            new PostPublisher(c,fb).publishFeed(myPost);
        }

        @Override
        public void onCancel() {
            Toast.makeText(c,"Cancelled IN",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onException(Throwable throwable) {
            Log.e("Exception1", throwable.getMessage());
        }

        @Override
        public void onFail(String reason) {
            Log.e("onFail",reason);
        }
    };

    public void login()
    {
        fb.login(loginListener);
    }

}
