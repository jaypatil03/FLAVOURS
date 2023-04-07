package com.example.flavoursapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminauth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button auth;
        EditText code;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminauth);
        code = (EditText) findViewById(R.id.authcode);
        auth = (Button) findViewById(R.id.submitauth);

        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(code.getText().toString().equals("091002"))
                {
                    Intent i = new Intent(adminauth.this,adminauth2.class);
                    startActivity(i);
                }
                else Toast.makeText(adminauth.this, "Invalid Code", Toast.LENGTH_SHORT).show();
            }
        });

    }
}