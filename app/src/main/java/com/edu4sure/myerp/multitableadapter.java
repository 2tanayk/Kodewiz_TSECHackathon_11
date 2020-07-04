package com.edu4sure.myerp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

 class multitableadapter extends ArrayAdapter<String> {
    private ArrayList<String> data,data1,data2,data3;
    private LayoutInflater l;
    private int resource;
    Context mcontext;
    int rowcount;

    public multitableadapter(@NonNull Context context, int resource, ArrayList<String> data, ArrayList<String> data1, ArrayList<String>data2, ArrayList<String>data3) {
        super(context, resource, data);
        this.data=data;
        this.data1=data1;
        this.data2=data2;
        this.data3=data3;
        mcontext=context;
        this.resource=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater l=   LayoutInflater.from(mcontext);
        convertView=l.inflate(resource,parent,false);
        TextView t=convertView.findViewById(R.id.text1);
        TextView t1=convertView.findViewById(R.id.text2);
        TextView t2=convertView.findViewById(R.id.text3);
        TextView t3=convertView.findViewById(R.id.text4);
        t.setText(data.get(position));
        t1.setText(data1.get(position));
        t2.setText(data2.get(position));
        t3.setText(data3.get(position));
        return convertView;
    }
}
