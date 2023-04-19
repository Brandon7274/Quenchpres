package com.example.quench;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button butt1= findViewById(R.id.button);
        Button butt2 = findViewById(R.id.button2);
        Button butt3 = findViewById(R.id.profile_button);
        Button butt4 = findViewById(R.id.button3);
        butt1.setOnClickListener(view -> openMainActivity2());

        butt2.setOnClickListener(view -> openMainActivity3());

        butt3.setOnClickListener(view -> openProfileActivity());

        butt4.setOnClickListener(view -> openwaterstats());

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

    public void showToast(View View) {
        Toast toast = Toast.makeText(this, "You should drink some water!",
                Toast.LENGTH_SHORT);
        toast.show();
    }
}