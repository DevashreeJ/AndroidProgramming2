package com.example.devas.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.HashMap;

public class MasterDetailActivity extends AppCompatActivity implements List_Fragment.OnClickingButton {

    private boolean twoPanes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_detail);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, List_Fragment.newInstance(R.id.master_detail_main_fragment))
                .commit();

       if(findViewById(R.id.detail_container)!=null)
        {
            twoPanes=true;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menufile, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        Intent intent;
        switch (id)
        {
            case R.id.task1 :
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                return  true;

            case R.id.task2 :
                intent = new Intent(this,ViewPagerActivity.class);
                startActivity(intent);
                return  true;

            case R.id.task3 :
                intent = new Intent(this,MasterDetailActivity.class);
                startActivity(intent);
                return  true;
        }
        return true;
    }

    public void onClickingButton(HashMap<String,?>movie) {
        if(twoPanes)
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container,Movie_details_fragment.newInstance(movie))
                    .addToBackStack(null).commit();


        }
        else
        {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container,Movie_details_fragment.newInstance(movie))
                    .addToBackStack(null).commit();
        }

    }

}
