package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class Tablefor3 extends AppCompatActivity {

    ArrayList<String> column_1 = new ArrayList<String>();
    ArrayList<String> column_2 = new ArrayList<>();
    ArrayList<String> column_3 = new ArrayList<>();
    ArrayList<String> column_4 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablefor3);
        Intent i=getIntent();
       int j= i.getIntExtra("table",0);
        if(j==1){
        Cursor c1=MainActivity.database.rawQuery("select * from Customers",null);
        c1.moveToFirst();
        if(c1.getCount()!=0){
            while(!c1.isAfterLast()){
                Log.i("inside","customers");
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
        }}
        else if(j==2){
            Log.i("inside","feedback");
            Cursor c1=MainActivity.database.rawQuery("select * from Feedback",null);
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
        }
        else if(j==3){
            Log.i("inside","analyis");
            Cursor c1=MainActivity.database.rawQuery("Select P.Product_id,P.ProductName,sum(O.Qauntity) ,sum(O.Qauntity)*P.Price    from Orders O join Products p on p.Product_id=o.Product_id group by P.Product_id order by sum(O.Qauntity) ",null);
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
        }
        ListView l = findViewById(R.id.listview2);
        l.setAdapter(new multitableadapter(this, R.layout.multitable, column_1, column_2, column_3,column_4));


    }
}