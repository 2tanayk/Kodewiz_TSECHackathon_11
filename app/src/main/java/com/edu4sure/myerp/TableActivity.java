package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.edu4sure.myerp.sql.SpaceCraft;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class  TableActivity extends AppCompatActivity {
    TableView<String[]>tb = (TableView<String[]>) findViewById(R.id.tableView);
    TableHelper tableHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        tableHelper= new TableHelper(this);
        tb.setColumnCount(4);
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, tableHelper.getSpaceProbeHeaders()));
    }
}