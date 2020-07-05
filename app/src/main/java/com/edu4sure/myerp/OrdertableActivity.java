package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrdertableActivity extends AppCompatActivity {

    ArrayList<String> column_1 = new ArrayList<String>();
    ArrayList<String> column_2 = new ArrayList<>();
    ArrayList<String> column_3 = new ArrayList<>();
    ArrayList<String> column_4 = new ArrayList<>();
    ArrayList<String> column_5 = new ArrayList<String>();
    ArrayList<String> column_6 = new ArrayList<String>();
    EditText  nameEditText;
    String rawQuery="update Orders set Order_status =";
    ListView l ;
    int pos=0;
Button  saveBtn;
public void add1(View v){

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordertable);
        Intent i=getIntent();
        column_1.add("Order id");
        column_2.add("Price");
        column_3.add("Quantity");
        column_4.add("Product_id");
        column_5.add("Order_status");
        column_6.add("Customer_id");
        Cursor c1=MainActivity.database.rawQuery("select * from Orders",null);
        c1.moveToFirst();
        if(c1.getCount()!=0){
           while(!c1.isAfterLast()){
            column_1.add(c1.getString(0));
            column_2.add(c1.getString(1));
            column_3.add(c1.getString(2));
            column_4.add(c1.getString(3));
            column_5.add(c1.getString(4));
            column_6.add(c1.getString(5));
            c1.moveToNext();}}
        else{
            column_1.add("NULL");
            column_2.add("NULL");
            column_3.add("NULL");
            column_4.add("NULL");
            column_5.add("NULL");
            column_6.add("NULL");
        }
        l = findViewById(R.id.listview);
        l.setAdapter(new Order_Adaptere(this, R.layout.orderstablelist, column_1, column_2, column_3, column_4,column_5,column_6));
        l.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                pos=i;
                Dialog d = new Dialog(OrdertableActivity.this);
                d.setTitle("CHANGE STATUS");
                d.setContentView(R.layout.customdialog);

                //INITIALIZE VIEWS
                nameEditText = (EditText) d.findViewById(R.id.nameEditTxt);
                nameEditText.findViewById(R.id.nameEditTxt35);

                saveBtn = (Button) d.findViewById(R.id.add2);


                //SAVE
                saveBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String status=  nameEditText.getText().toString();
                        String query="Update  `Orders` VALUES SET Status ="+status+"where order id="+Integer.toString(pos);
                       /*column_1.add(id);
                       column_2.add(name);
                       column_3.add(quantity);
                       column_4.add(price);
                       MainActivity.database.execSQL(query,null);
                       l.notify();*/


                    }
                });
                 return  true;
    }
        });
    }
}

