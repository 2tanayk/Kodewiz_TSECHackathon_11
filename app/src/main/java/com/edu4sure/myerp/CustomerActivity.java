package com.edu4sure.myerp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerActivity extends AppCompatActivity {
    View v;
    private List<CreateCustomer> list;
    private RecyclerView recyclerView;
    CustomerAdapter cAdapter;
    private DrawerLayout drawer;
    Intent intent1;
    public static int posn;

    private Integer i[]=new Integer[]{R.drawable.smarttv,R.drawable.iphone,R.drawable.mouse,R.drawable.nokia,R.drawable.laptop,R.drawable.tv,R.drawable.washingmachine};
    private String t[]=new String[]{"Smart TV","IPhone","Mouse","Nokia","Laptop","TV","Washing Machine"};

    public List<Integer> imgList= Arrays.asList(i);
    public List<String> prodList=Arrays.asList(t);


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final Intent intent = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        list=new ArrayList<>();

        fill();

       Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);

       NavigationView navigationView = findViewById(R.id.nav_view);

       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               switch (menuItem.getItemId()) {
                   case R.id.nav_cart:
                       getMyIntent();
                       intent1.putExtra("key",0);
                       startActivity(intent1);
                        //this.startActvity(intent1);
                       //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                      // getSupportFragmentManager().beginTransaction().replace(R.id.customerRV,new CartManagerFragment()).commit();
                       break;
                   case R.id.nav_orders:
                       getMyIntent();
                       intent1.putExtra("key",1);
                       startActivity(intent1);
                       //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                      // getSupportFragmentManager().beginTransaction().replace(R.id.customerRV,new OrdersFragment()).commit();
                       break;
                   case R.id.nav_feedback:
                       getMyIntent();
                       intent1.putExtra("key",2);
                       startActivity(intent1);
                       //Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                      // getSupportFragmentManager().beginTransaction().replace(R.id.customerRV,new FeedbackFragment()).commit();
                       break;
                   case R.id.nav_edit:
                       getMyIntent();
                       intent1.putExtra("key",3);
                       startActivity(intent1);
                      // Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                       //getSupportFragmentManager().beginTransaction().replace(R.id.customerRV,new EditProfileFragment()).commit();
                       break;

                 /*  case R.id.nav_logout:
                       Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
                       break;*/
               }//switch case
               drawer.closeDrawer(GravityCompat.START);
               return true;
           }
       });



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }//on Create ends

    public void getMyIntent()
    {
        intent1=new Intent(getApplicationContext(),FragHolder.class);

    }

    public void fill()
    {

        list.add(new CreateCustomer(R.drawable.smarttv,"Smart TV"));
        list.add(new CreateCustomer(R.drawable.iphone,"IPhone"));
        list.add(new CreateCustomer(R.drawable.mouse,"Mouse"));
        list.add(new CreateCustomer(R.drawable.nokia,"Nokia"));
        list.add(new CreateCustomer(R.drawable.laptop,"Laptop"));
        list.add(new CreateCustomer(R.drawable.tv,"TV"));
        list.add(new CreateCustomer(R.drawable.washingmachine,"Washing Machine"));

        recyclerView=(RecyclerView)findViewById(R.id.customerRV);
        cAdapter =new CustomerAdapter(this,list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(cAdapter);

        cAdapter.setOnItemClickListener(new CustomerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                posn=position;
                //Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAddToCartClick(int position) {
              CartManagerFragment.img.add(imgList.get(position));
              CartManagerFragment.cTxt.add(prodList.get(position));
              CartManagerFragment.cQty.add("1");
              Toast.makeText(getApplicationContext(),"Added to cart!",Toast.LENGTH_SHORT).show();
            }
        });
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