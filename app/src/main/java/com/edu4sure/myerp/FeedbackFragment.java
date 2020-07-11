package com.edu4sure.myerp;

import android.app.Application;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FeedbackFragment extends Fragment {
    EditText e1,e2,e3;
    RatingBar e4;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v= inflater.inflate(R.layout.fragment_feedback,container,false);

       e1= v.findViewById(R.id.customerId);
        e2=v.findViewById(R.id.name23);
        e3=v.findViewById(R.id.fId);
        e4=v.findViewById(R.id.feedback);
        LayerDrawable stars = (LayerDrawable) e4.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.YELLOW, PorterDuff.Mode.SRC_ATOP);
        Button b=v.findViewById(R.id.button56);
      b.setOnClickListener(new View.OnClickListener() {
          @Override
              public void onClick (View v){
                  String id = e1.getText().toString();
                  String name = e2.getText().toString();
                  String rating = e3.getText().toString();
                  String feedback = String.valueOf(e4.getNumStars());
                  Boolean state = MainActivity.m.insert_data_feedback(id, name, feedback, rating);
                  if (state) {
                      Toast.makeText(getActivity(), "Saved", Toast.LENGTH_SHORT).show();

                  } else {
                      Toast.makeText(getActivity(), "Sorry error", Toast.LENGTH_SHORT).show();
                  }

              }

      });

        return v;

    }

}
