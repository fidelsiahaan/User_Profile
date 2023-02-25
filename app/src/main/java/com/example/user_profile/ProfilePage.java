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
    private TextView name, weight, age, email, gender, heightft, heightin;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference database, personal, id, nameRef, weightRef, ageRef, emailRef, genderRef,
    heightFtRef, heightInRef;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        firebaseDatabase = FirebaseDatabase.getInstance();
        database = firebaseDatabase.getReference("Users");
        id = database.child("b1KqcJul0WZOdcXRdaJ2wuKPbLL2"); //Personal user id
        personal = id.child("Personal Information");

        nameRef = personal.child("name");
        ageRef = personal.child("age");
        weightRef = personal.child("weight");
        emailRef = personal.child("email");
        genderRef = personal.child("gender");
        heightFtRef = personal.child("feet");
        heightInRef = personal.child("inches");

        name = findViewById(R.id.nameValue);
        weight = findViewById(R.id.weightValue);
        age = findViewById(R.id.ageValue);
        email = findViewById(R.id.emailValue);
        gender = findViewById(R.id.genderValue);
        heightft = findViewById(R.id.heightFeetValue);
        heightin = findViewById(R.id.heightInValue);



        getdata(nameRef, name);
        getdataNum(weightRef, weight);
        getdataNum(ageRef, age);
        getdata(emailRef, email);
        getdata(genderRef, gender);
        getdataNum(heightFtRef, gender);
        getdataNum(heightInRef, gender);


        userSummaryButton = (Button) findViewById(R.id.userSummaryButton);
    userSummaryButton.setOnClickListener((new View.OnClickListener(){
        @Override
        public void onClick(View v){
            openSummary();
        }
    }));
    }

    private void getdata(DatabaseReference ref, TextView text) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                text.setText(value);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(ProfilePage.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getdataNum(DatabaseReference ref, TextView text) {
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int value = snapshot.getValue(int.class);
                text.setText(String.valueOf(value));
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
