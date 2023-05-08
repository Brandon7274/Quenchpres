package com.example.quench;

import static com.example.quench.R.id.button;
import static com.example.quench.R.id.button6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageButton hourlyNotificationButton;
    NotificationManager notificationManager;
    int notificationId = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton butt1= findViewById(button);
        ImageView butt2 = findViewById(R.id.button2);
        Button butt3 = findViewById(R.id.profile_button);
        ImageButton butt4 = findViewById(R.id.button3);
        ImageButton don = findViewById(R.id.donate_button);

        butt1.setOnClickListener(view -> openMainActivity2());

        butt2.setOnClickListener(view -> openMainActivity3());

        butt3.setOnClickListener(view -> openProfileActivity());

        butt4.setOnClickListener(view -> openwaterstats());

        don.setOnClickListener(view -> openDonate());





    }

    private void openDonate() {
        Intent intent = new Intent(this,Donate.class);
        startActivity(intent);
    }


    private void openMainActivity2() {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);
    }

    private void openMainActivity3() {
        Intent intent = new Intent(this,MainActivity3.class);
        startActivity(intent);
    }

    private void openProfileActivity(){
        Intent intent = new Intent(this, ProfilePage.class);
        startActivity(intent);
    }

    private void openwaterstats(){
        Intent intent = new Intent(this, waterstats.class);
        startActivity(intent);
    }


}