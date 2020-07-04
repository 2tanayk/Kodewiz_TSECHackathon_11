package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class FragHolder extends AppCompatActivity {
    FragmentTransaction transaction;
    FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_holder);
        CartManagerFragment c1 = new CartManagerFragment();
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.fragholder, c1, "Fragment");

        manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        Intent intent = getIntent();
        int value = intent.getIntExtra("key",0); //if it's a string you stored.

          switch (value) {
              case 0:
                  CartManagerFragment c = new CartManagerFragment();
                manager = getSupportFragmentManager();
                transaction = manager.beginTransaction();
                transaction.add(R.id.fragholder, c, "Fragment");
                break;
              case 1:
                  OrdersFragment of = new OrdersFragment();
                   manager = getSupportFragmentManager();
                  transaction= manager.beginTransaction();
                  transaction.add(R.id.fragholder, of, "Fragment");
                  break;
              case 2:
                 FeedbackFragment f = new FeedbackFragment();
                   manager = getSupportFragmentManager();
                  transaction = manager.beginTransaction();
                  transaction.add(R.id.fragholder, f, "Fragment");
                  break;
              case 3:
                 EditProfileFragment ep = new EditProfileFragment();
                   manager = getSupportFragmentManager();
                  transaction= manager.beginTransaction();
                  transaction.add(R.id.fragholder, ep, "Fragment");
                  break;

          }
    }
}