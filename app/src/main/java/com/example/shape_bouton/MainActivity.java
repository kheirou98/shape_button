package com.example.shape_bouton;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int index=0;
    int [] images = {R.drawable.button1,R.drawable.button7};
    NotificationManager manager;
    static int id=1;
    NewMessageNotification ntf = new NewMessageNotification();
    public void bu (View view) {
        ImageView img=(ImageView)findViewById(R.id.img);
        img.setImageResource(images[index]);
        index++;
        if (index>1)
        {index=0;}
       ntf.notify(this, "Good Afternoon",id);
       id++;
        ntf.notify(this, "Good Night",id);
    }
   public void tclick ( View view) {
        ntf.cancel(this);
    }

    public void buttonclick(View view) {
        Intent myIntent = new Intent(this, Result_activity.class);
        startActivity(myIntent);
    }
    public void buttonfile(View view) {
        Intent myIntent = new Intent(this, file.class);
        startActivity(myIntent);
    }

    public void buttongrid(View view) {
        Intent myIntent = new Intent(this, produits.class);
        startActivity(myIntent);
    }
}
