package com.edu4sure.myerp;

import android.content.Context;

import com.edu4sure.myerp.sql.SpaceCraft;
import com.edu4sure.myerp.sql.mdb.DBAdapter;

import java.util.ArrayList;

public class TableHelper
{
    Context c;
    private String[] spaceProbeHeaders = {"Order ID", "Customer ID", "Order Date", "Status"};
    private String[][] spaceProbes;
    public TableHelper(Context c)
    {
        this.c = c;
    }
    public String[] getSpaceProbeHeaders()
    {
        return spaceProbeHeaders;
    }
    public String[][] getSpaceProbes()
    {
        ArrayList<SpaceCraft> spaceCrafts = new DBAdapter(c).retrieveSpaceCraft();
        SpaceCraft s;
        spaceProbes = new String[spaceCrafts.size()][4];
        for (int i= 0; i < spaceCrafts.size(); i++)
        {
            s= spaceCrafts.get(i);
            spaceProbes[i][0] = s.getOrderId();
            spaceProbes[i][1] = s.getCustomer_id();
            spaceProbes[i][2] = s.getOrder_date();
            spaceProbes[i][3] = s.getStatus();
        }
        return spaceProbes;
    }

}
