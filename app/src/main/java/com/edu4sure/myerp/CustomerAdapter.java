package com.edu4sure.myerp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.MyViewHolder> {
    List<CreateCustomer> clist;
    Context mContext;
    private OnItemClickListener mListener;
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public CustomerAdapter(Context mContext,List<CreateCustomer> clist) {
        this.mContext = mContext;
        this.clist=clist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.create_customer,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(v,mListener);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.img.setImageResource(clist.get(position).getImage());
        holder.txt.setText(clist.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return clist.size();
    }

     public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView img;
        private TextView txt;
        public MyViewHolder(@NonNull View itemView,final OnItemClickListener listener) {
            super(itemView);
            img=itemView.findViewById(R.id.customerImg);
            txt=itemView.findViewById(R.id.customerTextView);

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

        }
    }
}//class ends
