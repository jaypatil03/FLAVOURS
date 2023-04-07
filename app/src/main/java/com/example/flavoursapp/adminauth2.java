package com.example.flavoursapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class adminauth2 extends AppCompatActivity {

    Button signoutt,manage,inventory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminauth2);

    signoutt = (Button) findViewById(R.id.signout);
        manage = (Button) findViewById(R.id.manageord);
        inventory =(Button) findViewById(R.id.inven);


        signoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(adminauth2.this,MainActivity.class);
                startActivity(i);
            }
        });




        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(adminauth2.this,OrderActivity.class);
                startActivity(i);
            }
        });





        inventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(adminauth2.this,InventoryO.class);
                startActivity(i);
            }
        });


    }
}