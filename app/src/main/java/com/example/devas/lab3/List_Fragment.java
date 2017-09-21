package com.example.devas.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by devas on 9/20/2017.
 */

public class List_Fragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    int counter=0;
    MovieData movieData = new MovieData();
    private OnClickingButton onclicking;

    public static List_Fragment newInstance(int sectionNumber) {
        List_Fragment listPage = new List_Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        listPage.setArguments(args);
        return listPage;
    }

    public List_Fragment() {

    }

    public interface OnClickingButton {
        public void onClickingButton(HashMap<String, ?>movie);
    }

    @Override
    public View onCreateView (LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState )
    {
        View view = inflater.inflate(R.layout.master_detail_main_fragment,container,false);

        final Button nextButton = (Button)view.findViewById(R.id.increaseButton);
        final Button previosButton = (Button)view.findViewById(R.id.decreaseButton);;
        final TextView count = (TextView)view.findViewById(R.id.number);
        count.setText(Integer.toString(counter));


        nextButton.setOnClickListener(new View.OnClickListener(){
        @Override

            public void onClick(View v)
            {
                ++counter;
                if(counter>=0&& counter<=24) {
                    onclicking.onClickingButton(movieData.getItem(counter));
                    count.setText(Integer.toString(counter));
                }
                else
                {--counter;}


            }
        });

        previosButton.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v)
            {
                --counter;
                if(counter>=0 && counter<=24 ) {
                    onclicking.onClickingButton(movieData.getItem(counter));
                    count.setText(Integer.toString(counter));
                }
                else
                {++counter;}


            }
        });

        return view;
    }

    @Override
    @Deprecated
    public void onAttach ( Activity activity ) {
        super . onAttach ( activity );
        onclicking = (List_Fragment.OnClickingButton) activity ;
    }
}