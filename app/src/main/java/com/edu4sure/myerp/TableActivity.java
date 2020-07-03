package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class  TableActivity extends AppCompatActivity {
    TableView<String[]> tb;
    TableHelper tableHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        tb = (TableView<String[]>) findViewById(R.id.tableview);
        tableHelper= new TableHelper(getApplicationContext());
        tb.setColumnCount(4);
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, tableHelper.getSpaceProbeHeaders()));
    }
}