package com.example.teju.disasterpreparedness.mFB;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.teju.disasterpreparedness.mData.MyPost;
import com.sromku.simple.fb.SimpleFacebook;
import com.sromku.simple.fb.entities.Feed;
import com.sromku.simple.fb.listeners.OnPublishListener;

/**
 * Created by teju on 3/5/2017.
 */
public class PostPublisher {
    Context c;
    SimpleFacebook fb;

    public PostPublisher(Context c, SimpleFacebook fb) {
        this.c = c;
        this.fb = fb;
    }

    OnPublishListener onpub=new OnPublishListener() {
        @Override
        public void onComplete(String response) {
            super.onComplete(response);
            Toast.makeText(c, "Published", Toast.LENGTH_SHORT).show();

        }


        @Override
        public void onException(Throwable throwable) {
            super.onException(throwable);
            Log.e("Exception4", throwable.getMessage());
        }

        @Override
        public void onFail(String reason) {
            super.onFail(reason);
            Log.e("Exception3", reason);
        }

        @Override
        public void onThinking() {
            super.onThinking();
            Log.e("Exception2", "thinking");
        }
    };

    public void publishFeed(MyPost myPost)
    {
        final Feed feed= new Feed.Builder()
                .setMessage(myPost.getName()+"\n"+myPost.getDescrip()).build();
        fb.getInstance().publish(feed,onpub);;
    }
}
