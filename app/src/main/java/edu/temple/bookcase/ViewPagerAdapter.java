package edu.temple.bookcase;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import edu.temple.bookcase.R;

public class ViewPagerAdapter extends FragmentActivity {

    //ViewPager viewPager = findViewById(R.id.viewPager1);

    String[] books;
    //public final int NUM_PAGES = 10;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    int numTabs;


/*
    public ViewPagerAdapter(@NonNull FragmentManager fm, int numTabs) {

        super(fm);
        this.numTabs = numTabs;

    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                BookListFragment bookListFragment = new BookListFragment();
                return bookListFragment;
            case 1:
                BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();
                return bookDetailsFragment;
                default:
                    return null;
        }


        //return null;
    }

 */

/*
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPager = (ViewPager)findViewById(R.id.viewPager2);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager()) {
        //mPager.setAdapter(pagerAdapter);
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return false;
            }
        };
    }

    public void onBackPress(){
        if(mPager.getCurrentItem()==0){

            super.onBackPressed();
        }
        else{
            mPager.setCurrentItem(mPager.getCurrentItem()-1);
        }
    }
    /*
    @Override
    public int getCount() {
        return numTabs;
    }

     */

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{
        public ScreenSlidePagerAdapter(FragmentManager fm){
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return new ViewPagerFragment();
        }

        @Override
        public int getCount() {
            return 0;
        }
    }
}
