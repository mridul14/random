package com.example.slider_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };
    private ViewPager pager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager = (ViewPager) findViewById(R.id.pager);

        CommonSenseAdapter adapter=new CommonSenseAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);





        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //inner class which is a subclass of adapter class
    class CommonSenseAdapter extends FragmentPagerAdapter{

        public CommonSenseAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) { //willl tell what fragment will be ccming


            switch(position){

                //kaunse position pe kiss fragment ka object banna hai we have 3 fragment so we will have 3 cases

                case 0:return  new oneFragment();
                case 1:return  new twoFragment();
                case 2:return  new threeFragment();


            }

            return null;
        }

        @Override
        public int getCount() { //determines how many fragments we will see
            return 3;
        }
    }

}
