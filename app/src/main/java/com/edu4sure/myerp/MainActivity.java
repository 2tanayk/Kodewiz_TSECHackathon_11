package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button loginBtn,GButton;
 static SQLiteDatabase database;


    ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn=(Button)findViewById(R.id.buttonGoogle);
        GButton=(Button)findViewById(R.id.buttonGoogle);
        database=this.openOrCreateDatabase("name",MODE_PRIVATE,null);
        database.execSQL(" Create table if not exists Orders(Order_id INT(1000),Price DOUBLE(10000000),Qauntity INT(100),Product_id INT(1000),Order_status VARCHAR(50),Customer_id INT(1000))");
         database.execSQL("INSERT INTO ORDERS VALUES(2,500000,60,1,'DONE',2)");
        database.execSQL(" Create table if not exists Products(Product_id INT(1000),ProductName VARCHAR(50),Qauntity INT(100),Price Double(1000000,1))");
        //database.execSQL("INSERT INTO `Products` VALUES (1,'LAPTOP',70,500000), (2,'IPHONE',49,1000000), (3,'ANDROID PHONE',38,25000), (4,'NOKIA',90,3400), (5,'WASHING MACHINE',94,33000), (6,'TV',14,20000), (7,'SMART TV',98,20), (8,'MOUSE',26,740);");
        database.execSQL(" Create table if not exists Customers(Customer_id INT(1000),CustomerName VARCHAR(50),CustomerAddres VARCHAR(5000),Phonenumber LONGINT(1000000))");
        database.execSQL("Create table if not exists Feedback(Customer_id INT(1000),CustomerFirstName VARCHAR(50),CustomerLastName VARCHAR(50),Feedback VARCHAR(500))");

     /*   loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Intent i=new Intent(MainActivity.this,RetailerActivity.class);
              //  MainActivity.this.startActivity(i);
                 open();
            }
        });*/

    }


    public void open(View view)
{
    try {
        Intent i = new Intent(this, RetailerActivity.class);
        startActivity(i);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}

    public void openC(View view)
    {
        try {
            Intent i = new Intent(this, CustomerActivity.class);
            startActivity(i);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}