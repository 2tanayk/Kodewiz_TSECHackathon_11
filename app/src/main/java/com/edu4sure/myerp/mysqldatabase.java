package com.edu4sure.myerp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class mysqldatabase extends SQLiteOpenHelper {
    SQLiteDatabase db=this.getWritableDatabase();
    public mysqldatabase(@Nullable Context context) {
        super(context, "Database", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        database.execSQL(" Create table if not exists Orders(Order_id INT(1000),Price DOUBLE(100),Qauntity INT(100),Product_id INT(1000),Order_status VARCHAR(50),Customer_id INT(1000))");
        database.execSQL("INSERT INTO ORDERS VALUES(2,500000,60,1,'DONE',2)");

        database.execSQL(" Create table if not exists Products(Product_id INT(1000),ProductName VARCHAR(50),Qauntity INT(100),Price Double(10,1))");
       // database.execSQL("INSERT INTO `Products` VALUES (1,'LAPTOP',70,500000), (2,'IPHONE',49,100000), (3,'ANDROID PHONE',38,25000), (4,'NOKIA',90,3400), (5,'WASHING MACHINE',94,33000), (6,'TV',14,20000), (7,'SMART TV',98,20), (8,'MOUSE',26,740);");

        database.execSQL(" Create table if not exists Customers(Customer_id INT(1000),CustomerName VARCHAR(50),CustomerAddres VARCHAR(5000),Phonenumber LONGINT(1000000))");
        database.execSQL("INSERT INTO Customers VALUES(1,'TANAY','KANDIVALI',9833275839)");
        database.execSQL("Create table if not exists Feedback(Customer_id INT(1000),CustomerName VARCHAR(50),Feedback VARCHAR(500),Rating INT(10))");
        database.execSQL("INSERT INTO Feedback VALUES(1,'TANAY','GOOD',9)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Orders");
        sqLiteDatabase.execSQL("drop table if exists Products");
        sqLiteDatabase.execSQL("drop table if exists Customers");
        sqLiteDatabase.execSQL("drop table if exists Feedback");
        onCreate(sqLiteDatabase);

    }
    public boolean insert_data_orders(String id,String price,String qauntity,String status,String customer_id){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Order_id",id);
        contentValues.put("Price",price);
        contentValues.put("Qauntity",qauntity);
        contentValues.put("Order_status",status);
        contentValues.put("Customer_id",customer_id);
        Long test= sqLiteDatabase.insert("Orders",null,contentValues);
        if(test!=-1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean insert_data_products(String Product_id,String ProductName,String Qauntity,String Price){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Product_id",Product_id);
        contentValues.put("ProductName",ProductName);
        contentValues.put("Qauntity",Qauntity);
        contentValues.put("Price",Price);
        Long test= sqLiteDatabase.insert("Products",null,contentValues);
        if(test!=-1){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean insert_data_feedback(String Customer_id ,String CustomerName,String Feedback,String Rating){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("Customer_id",Customer_id);
        contentValues.put("CustomerName",CustomerName);
        contentValues.put("Feedback",Feedback);
        contentValues.put("Rating",Rating);
        Long test= sqLiteDatabase.insert("Feedback",null,contentValues);
        if(test!=-1){
            return true;
        }
        else{
            return false;
        }
    }
}
