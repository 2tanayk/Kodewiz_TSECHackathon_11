package com.edu4sure.myerp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CartAdapter extends ArrayAdapter<String> {
    private Activity context;
    private List<String> d;
    private List<Integer> i;
    private List<String> q;

    public CartAdapter(Activity context,List<String> d,List<Integer> i,List<String> q) {
        super(context,R.layout.create_cart_list,d);
        this.context = context;
        this.d=d;
        this.i=i;
        this.q=q;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View cartItem=inflater.inflate(R.layout.create_cart_list,null,true);

        ImageView imgC=(ImageView)cartItem.findViewById(R.id.cartImageView);
        TextView txtC=(TextView)cartItem.findViewById(R.id.cartTextView);
        TextView txtQty=(TextView)cartItem.findViewById(R.id.qtyTextView);

        imgC.setImageResource(i.get(position));
        txtC.setText(d.get(position));
        txtQty.setText(q.get(position));

        return cartItem;
    }
}
