package com.edu4sure.myerp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FeedbackFragment extends Fragment {
    EditText e1,e2,e3,e4;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.fragment_feedback,container,false);

       e1= v.findViewById(R.id.customerId);
        e2=v.findViewById(R.id.customerId);
        e3=v.findViewById(R.id.fId);
        e4=v.findViewById(R.id.feedback);
        Button b=v.findViewById(R.id.button56);
      b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String query="INSERT INTO `Products` VALUES ("+e1.getText().toString()+","+e2.getText().toString()+","+e3.getText().toString()+","+e4.getText().toString()+")";
              MainActivity.database.execSQL(query);
          }
      });


        return v;
    }

}
