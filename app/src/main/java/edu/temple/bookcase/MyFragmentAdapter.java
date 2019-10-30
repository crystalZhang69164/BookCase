package edu.temple.bookcase;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import edu.temple.bookcase.BookDetailsFragment;

public class MyFragmentAdapter extends FragmentStatePagerAdapter {


    String[] books;

    public MyFragmentAdapter (FragmentManager fm, String[] books){
        super(fm);
        this.books = books;


    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return BookDetailsFragment.newInstance(this.books[position]);
    }

    @Override
    public int getCount() {
        return books.length;
    }
}
