package com.example.user_profile;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import androidx.annotation.NonNull;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfilePage extends AppCompatActivity{


    private Button userSummaryButton;
    private TextView name;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference database, personal, random, nameVal;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        firebaseDatabase = FirebaseDatabase.getInstance();
        database = firebaseDatabase.getReference("Users");
        random = database.child("WpsNdVWH43gNSscAI69Un1L3vQJ3");
        personal = random.child("Personal Information");
        nameVal = personal.child("name");

        name = findViewById(R.id.nameValue);

        getdata();

        userSummaryButton = (Button) findViewById(R.id.userSummaryButton);
    userSummaryButton.setOnClickListener((new View.OnClickListener(){
        @Override
        public void onClick(View v){
            openSummary();
        }
    }));
    }


    private void getdata() {
        nameVal.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                name.setText(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfilePage.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }





    public void openSummary(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
