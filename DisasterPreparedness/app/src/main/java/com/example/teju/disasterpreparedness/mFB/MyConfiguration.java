package com.example.teju.disasterpreparedness.mFB;

import com.sromku.simple.fb.Permission;
import com.sromku.simple.fb.SimpleFacebookConfiguration;

/**
 * Created by teju on 3/5/2017.
 */
public class MyConfiguration {

    Permission[] permissions=new Permission[]{Permission.EMAIL, Permission.USER_PHOTOS, Permission.PUBLISH_ACTION};
    static final String APP_ID="269907623445928";

    public SimpleFacebookConfiguration getMyConfig()
    {
        SimpleFacebookConfiguration config=new SimpleFacebookConfiguration.Builder().setAppId(APP_ID).setNamespace("Social Share").setPermissions(permissions).build();
        return config;

    }

}
