package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class ProductsActivity extends AppCompatActivity {
    ArrayList<String> column_1 = new ArrayList<String>();
    ArrayList<String> column_2 = new ArrayList<>();
    ArrayList<String> column_3 = new ArrayList<>();
    ArrayList<String> column_4 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        Intent i =getIntent();
        Log.i("inside","Products");
        Cursor c1=MainActivity.database.rawQuery("select * from Products",null);
        c1.moveToFirst();
        if(c1.getCount()!=0){
            while(!c1.isAfterLast()){
                column_1.add(c1.getString(0));
                column_2.add(c1.getString(1));
                column_3.add(c1.getString(2));
                column_4.add(c1.getString(3));

                c1.moveToNext();}}
        else{
            column_1.add("NULL");
            column_2.add("NULL");
            column_3.add("NULL");
            column_4.add("NULL");
        }
        ListView l = findViewById(R.id.listview3);
        l.setAdapter(new Prodcuttableadapter(this, R.layout.producttable, column_1, column_2, column_3,column_4));
    }
}