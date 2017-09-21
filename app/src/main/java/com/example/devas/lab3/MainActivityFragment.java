package com.example.devas.lab3;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by devas on 9/18/2017.
 */

public class MainActivityFragment extends Fragment {


    private static final String ARG_SECTION_NUMBER = "section_number";
    private  ButtonClickInterface buttonClickInterfacevar;
    Button aboutme ;
    Button task3;
    Button task2;
    public static MainActivityFragment newInstance(int sectionNumber) {
        MainActivityFragment mainPage = new MainActivityFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        mainPage.setArguments(args);
        return mainPage;
    }

    public MainActivityFragment() {

    }
    public interface ButtonClickInterface {
        public void onButtonClickListener(View v);

    }

    @Override
    public View onCreateView (LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState ) {

        View view = inflater.inflate(R.layout.mainactivityfragment,container,false);
        aboutme = (Button)view.findViewById(R.id.button5);
        task2 = (Button)view.findViewById(R.id.button6);
        task3 = (Button)view.findViewById(R.id.button7);


        task3.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public  void onClick(View v)
            {
                Intent intent= new Intent(getActivity(),MasterDetailActivity.class);
                startActivity(intent);
            }

        });

        task2.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public  void onClick(View v)
            {
                Intent intent= new Intent(getActivity(),ViewPagerActivity.class);
                startActivity(intent);
            }

        });
        aboutme.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                buttonClicked(v);
            }
        });
        return view;
    }

    public void  buttonClicked(View v){
        buttonClickInterfacevar.onButtonClickListener(v);
    }

    @Override
    @Deprecated
    public void onAttach ( Activity activity ) {
        super . onAttach ( activity );
        buttonClickInterfacevar = ( ButtonClickInterface ) activity ;
    }


}
