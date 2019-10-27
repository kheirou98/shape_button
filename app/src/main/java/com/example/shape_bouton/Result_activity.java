package com.example.shape_bouton;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Result_activity extends AppCompatActivity {
   public final static int req_per =123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void buclick(View view) {
        inboxmsg();
        if ((int) Build.VERSION.SDK_INT>=23){
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS)
                    != PackageManager.PERMISSION_GRANTED){
                if(!shouldShowRequestPermissionRationale(Manifest.permission.READ_SMS)){
                    requestPermissions(new String [] {Manifest.permission.READ_SMS},req_per);
                }
                return;
            }
        }
        inboxmsg ();
    }
    public void onRequestPermissionResult (int requestCode ,String [] Permissions,int [] grantResults) {
        switch (requestCode){
            case req_per:
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    inboxmsg ();
                } else {

                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode,Permissions,grantResults);

        }

    }
    void inboxmsg () {
        try {
            String sms="";
            Uri urisms = Uri.parse("content://sms/inbox");
            Cursor cur = getContentResolver().query(urisms, null, null, null, null);
            cur.moveToPosition(0);
            while (cur.moveToNext()) {
                sms+= "From"+cur.getString(cur.getColumnIndex("address"))+" : "
                        +cur.getString(cur.getColumnIndex("body"))+"\n" ;
            }
            TextView txt = findViewById(R.id.textView2);
            txt.setText(sms);
        } catch( Exception exc) {

        }
    }
}
