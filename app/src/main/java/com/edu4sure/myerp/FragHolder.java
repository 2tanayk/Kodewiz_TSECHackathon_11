package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class FragHolder extends AppCompatActivity {
    FragmentTransaction transaction;
    public static FragmentManager manager;
   // CartManagerFragment c;
    //OrdersFragment of;
    //FragmentTransaction fragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_holder);
        Intent intent = getIntent();
        int value = intent.getIntExtra("key",0);

        manager = getSupportFragmentManager();
     /*   if(findViewById(R.id.fragholder)!=null)
        {
            if (savedInstanceState != null)
            {
                return;
            }

            transaction = manager.beginTransaction();
            c = new CartManagerFragment();
            transaction.add(R.id.fragholder, c, "Fragment");
            transaction.commit();
        }*/

        //fragmentTransaction=manager.beginTransaction();

        //manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);*/



          switch (value) {
              case 0:
                  // c = new CartManagerFragment();
               // manager = getSupportFragmentManager();
               // fragmentTransaction=manager.beginTransaction();
                //transaction = manager.beginTransaction();
               // fragmentTransaction.add(R.id.fragholder, c, "Fragment");
              //  fragmentTransaction.commit();
                manager.beginTransaction().replace(R.id.fragholder,new CartManagerFragment(),null).commit();
                  //Toast.makeText(getApplicationContext(), "Shit!", Toast.LENGTH_SHORT).show();
                break;
              case 1:
                 /* of = new OrdersFragment();
                   manager = getSupportFragmentManager();
                  transaction= manager.beginTransaction();
                  transaction.add(R.id.fragholder, of, "Fragment");
                  Toast.makeText(getApplicationContext(), "Shit!", Toast.LENGTH_SHORT).show();*/

                 manager.beginTransaction().replace(R.id.fragholder,new OrdersFragment(),null).commit();
                  break;
              case 2:
               /*  FeedbackFragment f = new FeedbackFragment();
                   manager = getSupportFragmentManager();
                  transaction = manager.beginTransaction();
                  transaction.add(R.id.fragholder, f, "Fragment");
                  Toast.makeText(getApplicationContext(), "Shit!", Toast.LENGTH_SHORT).show();*/

                  manager.beginTransaction().replace(R.id.fragholder,new FeedbackFragment(),null).commit();
                  break;
              case 3:
               /*  EditProfileFragment ep = new EditProfileFragment();
                   manager = getSupportFragmentManager();
                  transaction= manager.beginTransaction();
                  transaction.add(R.id.fragholder, ep, "Fragment");
                  Toast.makeText(getApplicationContext(), "Shit!", Toast.LENGTH_SHORT).show();*/

                  manager.beginTransaction().replace(R.id.fragholder,new EditProfileFragment(),null).commit();
                  break;
              default:

          }
    }
}