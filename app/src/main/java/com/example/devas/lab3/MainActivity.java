package com.example.devas.lab3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements MainActivityFragment.ButtonClickInterface
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout,MainActivityFragment.newInstance(R.id.mainactivity))
                .commit();

    }

    @Override
    public void onButtonClickListener(View v) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout,CoverpageFragment.newInstance(R.id.coverpage)).addToBackStack(null)
                .commit();

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
}
