package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RetailerActivity extends AppCompatActivity {
    View v;
    private List<Create> list;
    private RecyclerView recyclerView;
    RetailerAdapter rAdapter;

    int col=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer);



        list=new ArrayList<>();

        list.add(new Create(R.drawable.order,"Order"));
        list.add(new Create(R.drawable.inventory,"Inventory"));
        list.add(new Create(R.drawable.analysis,"Analysis"));
        list.add(new Create(R.drawable.customer,"Customer"));
        list.add(new Create(R.drawable.feedback,"Feedback"));

        recyclerView=(RecyclerView)findViewById(R.id.retailerRV);

        rAdapter=new RetailerAdapter(this,list);

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),col));

        recyclerView.setAdapter(rAdapter);



    }//onCreate ends


}//RetailerActivity ends