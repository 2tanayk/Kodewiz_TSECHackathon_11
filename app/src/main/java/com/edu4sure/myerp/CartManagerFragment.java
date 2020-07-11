package com.edu4sure.myerp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class CartManagerFragment extends Fragment {
    ListView cList;
    List<Integer> img;
    List<String> cTxt;
    List<String> cQty;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.fragment_cart_manager,container,false);

        CartAdapter myCartAdapter=new CartAdapter(getActivity(),cTxt,img,cQty);
        cList=(ListView)v.findViewById(R.id.cartList);
        cList.setAdapter(myCartAdapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        img=new ArrayList<>();
        cTxt=new ArrayList<>();
        cQty=new ArrayList<>();

        img.add(R.drawable.laptop);
        cTxt.add("Laptop");
        cQty.add("2");

    }
}
