package com.example.flavoursapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.flavoursapp.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    ActivityDetailBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       final DBHelper helper = new DBHelper(this);

        if(getIntent().getIntExtra("type",0)==1)
        {
        final int image = getIntent().getIntExtra("image",0);
        final int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String name = getIntent().getStringExtra("name");
        final String description = getIntent().getStringExtra("desc");

        binding.detailImage.setImageResource(image);
        binding.priceLbl.setText(String.format("%d",price));
        binding.NameBoxbig.setText(name);
        binding.detailDescription.setText(description);




        binding.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = helper.insertOrder(binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,image,description,name,Integer.parseInt(binding.quantity.getText().toString()));

                if(isInserted)
                    Toast.makeText(DetailActivity.this,"Data Insert Success",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(DetailActivity.this,"Data Error",Toast.LENGTH_SHORT).show();

            }
        });
    } else{
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor =helper.getOrderById(id);
            Toast.makeText(this,"Editing order of : "+cursor.getString(1),Toast.LENGTH_SHORT).show();

            int image = cursor.getInt(4);
            binding.detailImage.setImageResource(image);
            binding.priceLbl.setText(String.format("%d",cursor.getInt(3)));
            binding.NameBoxbig.setText(cursor.getString(6));
            binding.detailDescription.setText(cursor.getString(5));


            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("Update Now");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   boolean isUpdated= helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLbl.getText().toString()),image,binding.detailDescription.getText().toString(),binding.NameBoxbig.getText().toString(),1,id);

                    if(isUpdated)
                        Toast.makeText(DetailActivity.this,"Data Update Success",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(DetailActivity.this,"Data Error",Toast.LENGTH_SHORT).show();

                }
            });


        }
    }
}