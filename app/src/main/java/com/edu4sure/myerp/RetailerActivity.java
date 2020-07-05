package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

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
          fill();
          build();
    }//onCreate ends

// public void onClickLinearLayout(View v)
//    {
//        try {
//            Intent i = new Intent(this, ProductsActivity.class);
//            i.putExtra("table",3);
//            startActivity(i);
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//    }

    public void fill()
    {
        list=new ArrayList<>();

        list.add(new CreateRetailer(R.drawable.order,"Order"));
        list.add(new CreateRetailer(R.drawable.inventory,"Inventory"));
        list.add(new CreateRetailer(R.drawable.analysis,"Analysis"));
        list.add(new CreateRetailer(R.drawable.customer,"Customer"));
        list.add(new CreateRetailer(R.drawable.feedback,"Feedback"));
    }
    public void build()
    {
        recyclerView=(RecyclerView)findViewById(R.id.retailerRV);



        rAdapter=new RetailerAdapter(this,list);

        recyclerView.setLayoutManager(new GridLayoutManager(this,col));

        recyclerView.setAdapter(rAdapter);

//        rAdapter.setOnItemClickListener(new Retail.OnItemClickListener() {
//            @Override
//            public void onItemClick(int position) {
//               Toast.makeText(getApplicationContext(),"Clicked!"+position,Toast.LENGTH_SHORT).show();

//            }
//        });
          try {
        rAdapter.setOnItemClickListener(new RetailerAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(int position) {
//                Toast.makeText(RetailerActivity.this,"Clicked!"+position,Toast.LENGTH_SHORT).show();

                switch(position)
                {
                    case 0: {
                        try {
                            Intent i = new Intent(getApplicationContext(), OrdertableActivity.class);
                            startActivity(i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                    case 1:{

                        try {
                            Intent i = new Intent(getApplicationContext(),ProductsActivity.class);
                            startActivity(i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }

            }
        });
          }catch(Exception e)
          {
             e.printStackTrace();
              Toast.makeText(RetailerActivity.this,"Oops :(",Toast.LENGTH_SHORT).show();
          }

    }

}//RetailerActivity ends