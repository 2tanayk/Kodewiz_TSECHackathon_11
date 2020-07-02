package com.edu4sure.myerp.sql.mdb;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
    public DBHelper(Context context)
    {
        super(context, Constants.DB_NAME, null, Constants.DB_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        try
        {
            db.execSQL(Constants.CREATE_TB);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        try
        {
            db.execSQL(Constants.DROP_TB);
            db.execSQL(Constants.CREATE_TB);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
