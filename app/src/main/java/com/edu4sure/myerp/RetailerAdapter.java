package com.edu4sure.myerp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RetailerAdapter extends RecyclerView.Adapter<RetailerAdapter.MyViewHolder>
{
    Context mC;
    List<CreateRetailer> rlist;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public RetailerAdapter(Context mC,List<CreateRetailer> rlist) {
        this.mC = mC;
        this.rlist=rlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v=LayoutInflater.from(mC).inflate(R.layout.create_retailer,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v,mListener);
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

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView img;
        private TextView txt;

        public MyViewHolder(@NonNull View itemView,final OnItemClickListener listener) {
            super(itemView);
            img=itemView.findViewById(R.id.retailerImg);
            txt=itemView.findViewById(R.id.retailerTextView);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  if(listener!=null)
                  {
                      int position=getAdapterPosition();
                      if(position!=RecyclerView.NO_POSITION)
                      {
                          listener.onItemClick(position);
                      }
                  }
                }
            });
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (listener != null) {
//                        int position = getAdapterPosition();
//                        if (position != RecyclerView.NO_POSITION)
//                        {
//                            listener.onItemClick(position);
//                           }
//            }}});

        }//ViewHolder ends

    }//class ends
}
