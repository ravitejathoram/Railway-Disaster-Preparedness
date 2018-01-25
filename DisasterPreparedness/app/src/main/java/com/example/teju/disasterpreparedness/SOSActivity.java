package com.example.teju.disasterpreparedness;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class SOSActivity extends Activity {

    Toolbar tb;
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18;
    GPSTracker currentLocation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);
        currentLocation = new GPSTracker(SOSActivity.this);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
        tb = (Toolbar) findViewById(R.id.toll);
        tb.setTitle("SOS");
        tb.setTitleTextColor(Color.WHITE);
        tb.setLogo(R.mipmap.soss);

        btn1 = (Button) findViewById(R.id.sms1);
        btn2 = (Button) findViewById(R.id.phone1);
        btn3 = (Button) findViewById(R.id.email1);

        btn4 = (Button) findViewById(R.id.sms2);
        btn5 = (Button) findViewById(R.id.phone2);
        btn6 = (Button) findViewById(R.id.email2);

        btn7 = (Button) findViewById(R.id.sms3);
        btn8 = (Button) findViewById(R.id.phone3);
        btn9 = (Button) findViewById(R.id.email3);

        btn10 = (Button) findViewById(R.id.sms4);
        btn11 = (Button) findViewById(R.id.phone4);
        btn12 = (Button) findViewById(R.id.email4);

        btn13 = (Button) findViewById(R.id.sms5);
        btn14 = (Button) findViewById(R.id.phone5);
        btn15 = (Button) findViewById(R.id.email5);

        btn16 = (Button) findViewById(R.id.one);
        btn17 = (Button) findViewById(R.id.two);
        btn18 = (Button) findViewById(R.id.three);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsBody = new String("need help unable to use gps");
                if (currentLocation.canGetLocation()) {
                    smsBody = new String("http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude());
                } else {
                    currentLocation.showSettingsAlert();
                }
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", "Phone Number");
                smsIntent.putExtra("sms_body", smsBody);
                startActivity(smsIntent);


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9550934989"));
                if (ActivityCompat.checkSelfPermission(SOSActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="unable to use gps";
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                if(currentLocation.canGetLocation()) {
                    uri = "http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude();
                }
                else
                {
                    currentLocation.showSettingsAlert();
                }
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"AUTHORITY EMAIL"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "iam at "+uri);
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent,"Choose:"));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsBody = new String("need help unable to use gps");
                if (currentLocation.canGetLocation()) {
                    smsBody = new String("http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude());
                } else {
                    currentLocation.showSettingsAlert();
                }
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", "9550934989");
                smsIntent.putExtra("sms_body", smsBody);
                startActivity(smsIntent);


            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9440046739"));
                if (ActivityCompat.checkSelfPermission(SOSActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="unable to use gps";
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                if(currentLocation.canGetLocation()) {
                    uri = "http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude();
                }
                else
                {
                    currentLocation.showSettingsAlert();
                }
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"ravitejathoram@gmail.com"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "iam at "+uri);
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent,"Choose:"));
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsBody = new String("need help unable to use gps");
                if (currentLocation.canGetLocation()) {
                    smsBody = new String("http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude());
                } else {
                    currentLocation.showSettingsAlert();
                }
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", "9550934989");
                smsIntent.putExtra("sms_body", smsBody);
                startActivity(smsIntent);


            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9440046739"));
                if (ActivityCompat.checkSelfPermission(SOSActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="unable to use gps";
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                if(currentLocation.canGetLocation()) {
                    uri = "http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude();
                }
                else
                {
                    currentLocation.showSettingsAlert();
                }
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"ravitejathoram@gmail.com"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "iam at "+uri);
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent,"Choose:"));
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsBody = new String("need help unable to use gps");
                if (currentLocation.canGetLocation()) {
                    smsBody = new String("http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude());
                } else {
                    currentLocation.showSettingsAlert();
                }
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", "9550934989");
                smsIntent.putExtra("sms_body", smsBody);
                startActivity(smsIntent);


            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9440046739"));
                if (ActivityCompat.checkSelfPermission(SOSActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="unable to use gps";
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                if(currentLocation.canGetLocation()) {
                    uri = "http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude();
                }
                else
                {
                    currentLocation.showSettingsAlert();
                }
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"ravitejathoram@gmail.com"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "iam at "+uri);
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent,"Choose:"));
            }
        });
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsBody = new String("need help unable to use gps");
                if (currentLocation.canGetLocation()) {
                    smsBody = new String("http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude());
                } else {
                    currentLocation.showSettingsAlert();
                }
                Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                smsIntent.setType("vnd.android-dir/mms-sms");
                smsIntent.putExtra("address", "9550934989");
                smsIntent.putExtra("sms_body", smsBody);
                startActivity(smsIntent);


            }
        });
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9440046739"));
                if (ActivityCompat.checkSelfPermission(SOSActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri="unable to use gps";
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                if(currentLocation.canGetLocation()) {
                    uri = "http://maps.google.com/?ll=" + currentLocation.getLatitude() + "," + currentLocation.getLongitude();
                }
                else
                {
                    currentLocation.showSettingsAlert();
                }
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"ravitejathoram@gmail.com"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Email subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "iam at "+uri);
                emailIntent.setType("message/rfc822");
                startActivity(Intent.createChooser(emailIntent,"Choose:"));
            }
        });
        btn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9440046739"));
                if (ActivityCompat.checkSelfPermission(SOSActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });
        btn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9440046739"));
                if (ActivityCompat.checkSelfPermission(SOSActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });

        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "9440046739"));
                if (ActivityCompat.checkSelfPermission(SOSActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                startActivity(intent);
            }
        });


    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}
