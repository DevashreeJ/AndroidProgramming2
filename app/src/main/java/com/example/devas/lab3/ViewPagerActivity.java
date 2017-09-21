package com.example.devas.lab3;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class ViewPagerActivity extends AppCompatActivity {


    ViewPagerAdapter viewPagerAdapter;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        MovieData movieData = new MovieData();

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), movieData.getSize());
        viewPager= (ViewPager)findViewById(R.id.viewpager);
        viewPager.setAdapter(viewPagerAdapter);


        viewPager.setPageTransformer(false, new ViewPager.PageTransformer()
        {
            @Override
            public void transformPage(View page, float position)
            {
                final float normal_position = Math.abs(Math.abs(position)-1);
                page.setScaleX(normal_position/2 +0.5f);
                page.setScaleY(normal_position/2 +0.5f);
            }
        });

        TabLayout tab = (TabLayout)findViewById(R.id.view_pager_tab);
        tab.setupWithViewPager(viewPager);
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
                intent = new Intent(this,ViewPager.class);
                startActivity(intent);
                return  true;

            case R.id.task3 :
                intent = new Intent(this,MasterDetailActivity.class);
                startActivity(intent);
                return  true;
        }
        return true;
    }


}
