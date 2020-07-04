package com.edu4sure.myerp.sql.mdb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.edu4sure.myerp.sql.SpaceCraft;

import java.util.ArrayList;

public class DBAdapter
{
    Context c;
    SQLiteDatabase db;
    DBHelper helper;

    public DBAdapter(Context c)
    {
        this.c = c;
        helper = new DBHelper(c);
    }
    public boolean saveSpaceCraft(SpaceCraft spaceCraft)
    {
        try
        {
            db = helper.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(Constants.ORDER_ID, spaceCraft.getOrderId());
            cv.put(Constants.CUSTOMER_ID, spaceCraft.getCustomer_id());
            cv.put(Constants.ORDER_DATE, spaceCraft.getOrder_date());
            cv.put(Constants.STATUS, spaceCraft.getStatus());
            long result = db.insert(Constants.TB_NAME, Constants.CUSTOMER_ID, cv);
            if (result > 0)
            {
                return true;
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<SpaceCraft> retrieveSpaceCraft()
    {
        ArrayList<SpaceCraft> spacecrafts = new ArrayList<>();
        String[] columns = {Constants.ORDER_ID, Constants.CUSTOMER_ID, Constants.ORDER_DATE, Constants.STATUS};
        try
        {
            db = helper.getWritableDatabase();
            Cursor c = db.query(Constants.TB_NAME, columns, null, null, null,null,null);

            SpaceCraft s;
            if (c != null)
            {
                while (c.moveToNext())
                {
                    String s_orderId = c.getString(1);
                    String s_customerId = c.getString(2);
                    String s_orderDate = c.getString(3);
                    String s_status = c.getString(4);
                    s = new SpaceCraft();
                    s.setOrder_id(s_orderId);
                    s.setCustomer_id(s_customerId);
                    s.setOrder_date(s_orderDate);
                    s.setStatus(s_status);
                    spacecrafts.add(s);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return spacecrafts;
    }
}
