package com.example.user_profile;

import androidx.appcompat.app.AppCompatActivity;
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
import android.os.Bundle;



public class BreakfastActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference database, recipe, id;
    DatabaseReference recipeNameRef;
    String recipeID = "-NPA9bQhRvXnFWDVQ_jc";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        firebaseDatabase = FirebaseDatabase.getInstance();
        database = firebaseDatabase.getReference("Users");
        id = database.child(recipeID);

        recipeNameRef = id.child("recipeName");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_look);
    }
}