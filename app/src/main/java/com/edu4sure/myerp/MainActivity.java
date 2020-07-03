package com.edu4sure.myerp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn=(Button)findViewById(R.id.buttonGoogle);

     /*   loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Intent i=new Intent(MainActivity.this,RetailerActivity.class);
              //  MainActivity.this.startActivity(i);
                 open();
            }
        });*/

    }


    public void open(View view)
    {
        try {
            Intent i = new Intent(this, RetailerActivity.class);
            startActivity(i);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}