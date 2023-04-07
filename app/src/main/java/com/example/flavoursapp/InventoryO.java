package com.example.flavoursapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class InventoryO extends AppCompatActivity {
Button refresh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory_o);

        refresh = (Button)findViewById(R.id.button2);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(InventoryO.this, "Inventory Update: Success, Show:false", Toast.LENGTH_SHORT).show();

                Toast.makeText(InventoryO.this, "Fruit:93, Cheese:100, Flour 70,Chocolate:50, Cream:100, Sugar = 50, Chocochip = 84,Bags=94,Boxes=94", Toast.LENGTH_LONG).show();
                
            }
        });
       
    }
}