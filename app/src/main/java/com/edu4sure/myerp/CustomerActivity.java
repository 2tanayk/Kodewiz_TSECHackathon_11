package com.edu4sure.myerp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {
    View v;
    private List<CreateCustomer> list;
    private RecyclerView recyclerView;
    CustomerAdapter cAdapter;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        list=new ArrayList<>();
        fill();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

    }//on Create ends

    public void fill()
    {

        list.add(new CreateCustomer(R.drawable.smarttv,"Smart TV"));
        list.add(new CreateCustomer(R.drawable.iphone,"IPhone"));
        list.add(new CreateCustomer(R.drawable.mouse,"Mouse"));
        list.add(new CreateCustomer(R.drawable.nokia,"Nokia"));
        list.add(new CreateCustomer(R.drawable.laptop,"Laptop"));
        list.add(new CreateCustomer(R.drawable.tv,"TV"));
        list.add(new CreateCustomer(R.drawable.laptop,"Washing Machine"));

        recyclerView=(RecyclerView)findViewById(R.id.customerRV);
        cAdapter =new CustomerAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(cAdapter);
    }//fill ends

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}//Customer ends