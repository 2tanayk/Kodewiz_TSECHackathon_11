package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RetailerActivity extends AppCompatActivity {
    View v;
    private List<CreateRetailer> list;
    private RecyclerView recyclerView;
    RetailerAdapter rAdapter;

    int col=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer);



        list=new ArrayList<>();

        list.add(new CreateRetailer(R.drawable.order,"Order"));
        list.add(new CreateRetailer(R.drawable.inventory,"Inventory"));
        list.add(new CreateRetailer(R.drawable.analysis,"Analysis"));
        list.add(new CreateRetailer(R.drawable.customer,"Customer"));
        list.add(new CreateRetailer(R.drawable.feedback,"Feedback"));

        recyclerView=(RecyclerView)findViewById(R.id.retailerRV);

        rAdapter=new RetailerAdapter(this,list);

        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),col));

        recyclerView.setAdapter(rAdapter);


    }//onCreate ends
    public void onClickLinearLayout(View v)
    {
        try {
            Intent i = new Intent(this, ProductsActivity.class);
            i.putExtra("table",3);
            startActivity(i);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}//RetailerActivity ends