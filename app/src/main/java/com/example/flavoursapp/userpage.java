package com.example.flavoursapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.flavoursapp.Adapters.MainAdapter;
import com.example.flavoursapp.Models.MainModel;
import com.example.flavoursapp.databinding.ActivityMainBinding;
import com.example.flavoursapp.databinding.ActivityUserpageBinding;

import java.util.ArrayList;

public class userpage extends AppCompatActivity {


    ActivityUserpageBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserpageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
//add value to list
        list.add(new MainModel(R.drawable.caramelcustard,"Caramel Custard","500","Caramel Custard is a traditional French dessert with creamy caramel over silky custard."));
        list.add(new MainModel(R.drawable.cheeseballs,"Cheese Balls","500","A cheese ball is a mixture of cream cheese, fresh grated cheese, sour cream, and other spices for flavoring."));
        list.add(new MainModel(R.drawable.fruitcake,"Fruit Cake","400","Fruitcake is a cake made with fresh fruit, nuts, and spices, and optionally soaked in spirits."));
        list.add(new MainModel(R.drawable.chocolava,"Choco Lava Cake","500","Soft warm chocolate cake outside giving way to a creamy, smooth stream of warm liquid chocolate inside."));
        list.add(new MainModel(R.drawable.cheesecake,"Cheese Cake","600"," A dessert consisting of a thick, creamy filling of cheese, eggs, and sugar over a thinner crust and topped with salty items."));
        list.add(new MainModel(R.drawable.pestobread,"Pesto Bread","570","Herbaceous garden aroma suspended with delicate olive oil, enriched with pine nuts"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);
    }
}