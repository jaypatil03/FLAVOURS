package com.example.flavoursapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    String emailtxt, password;
    EditText email, passw;
    Button signin, newacc, logadmin;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();


        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        passw = (EditText) findViewById(R.id.editTextTextPassword);
        signin = (Button) findViewById(R.id.addnew);//login
        newacc = (Button) findViewById(R.id.addmail);//register
        logadmin = (Button) findViewById(R.id.admin);



        logadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,adminauth.class);
                startActivity(i);
            }
        });

            newacc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    createUser();
                }
            }); // register


            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loginuser();

                }
            }); // login





        }



public void createUser()
{
    emailtxt = email.getText().toString();
    password= passw.getText().toString();
    mAuth.createUserWithEmailAndPassword(emailtxt, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("SUCCESSSREG", "createUserWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(MainActivity.this,"Welcome "+user,Toast.LENGTH_SHORT).show();
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("CREATEUSERERROR", "createUserWithEmail:failure", task.getException());
                        Toast.makeText(MainActivity.this, "Authentication failed",
                                Toast.LENGTH_SHORT).show();

                    }
                }



            });
}


public void loginuser()
{
    mAuth.signInWithEmailAndPassword(emailtxt, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("SIGNIN", "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent i = new Intent(MainActivity.this,MainActivity2.class);startActivity(i);

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("SIGNIN", "signInWithEmail:failure", task.getException());
                        Toast.makeText(MainActivity.this, "Authentication failed."+task.getException(),
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });

}


}