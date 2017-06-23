package com.example.abhishek.tablayout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public TabLayout tabLayout;
    public ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager =(ViewPager) findViewById(R.id.viewPager);

        tabLayout=(TabLayout)findViewById(R.id.tabLayout);


        setupViewPager(viewPager);

        tabLayout.setupWithViewPager(viewPager);
    }
    public void setupViewPager(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());


        adapter.addFragment(new chats(),"CHATS");//will add tabs on tablayout
        adapter.addFragment(new contacts(),"CONTACTS");
        adapter.addFragment(new status(),"STATUS");

        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {//FragmentPagerAdapter is Predefined class

        ArrayList arrayList = new ArrayList();

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return fragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return fragmentTitleList.size();
        }

        public void addFragment(Fragment fragment, String  title)
        {
            fragmentList.add(fragment);     //data and view
            fragmentTitleList.add(title);   //title
        }

        @Override
        public CharSequence getPageTitle(int position){
            //return null; //--> if we don't want to show a title on tablayout
            return fragmentTitleList.get(position);
        }
    }

}

