package com.edu4sure.myerp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RetailerAdapter extends RecyclerView.Adapter<RetailerAdapter.MyViewHolder>
{
    Context mC;
    List<Create> rlist;

    public RetailerAdapter(Context mC,List<Create> rlist) {
        this.mC = mC;
        this.rlist=rlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v=LayoutInflater.from(mC).inflate(R.layout.create_retailer,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.img.setImageResource(rlist.get(position).getImage());
        holder.txt.setText(rlist.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return rlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView img;
        private TextView txt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.retailerImg);
            txt=itemView.findViewById(R.id.retailerTextView);
        }//ViewHolder ends
    }//class ends
}
