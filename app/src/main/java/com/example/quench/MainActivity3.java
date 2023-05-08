package com.example.quench;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {

    private EditText mEditText;
    private Button mSaveButton;

    private DatabaseReference mDatabaseRef;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mEditText = findViewById(R.id.edit_text);
        mSaveButton = findViewById(R.id.save_button);

        mAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference().child("texts");

        mSaveButton.setOnClickListener(v -> saveText());
    }

    private void saveText() {
        String text = mEditText.getText().toString().trim();

        if (TextUtils.isEmpty(text)) {
            Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mAuth.getCurrentUser() == null) {
            Toast.makeText(this, "Please sign in to save text", Toast.LENGTH_SHORT).show();
            return;
        }

        String email = mAuth.getCurrentUser().getEmail();
        String key = mDatabaseRef.push().getKey();
        mDatabaseRef.child(key).setValue(text + " - " + email);

        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
        mEditText.setText("");
    }
}

