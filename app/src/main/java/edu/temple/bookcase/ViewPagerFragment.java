package edu.temple.bookcase;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import edu.temple.bookcase.R;


public class ViewPagerFragment extends Fragment {


    ArrayList<BookDetailsFragment> bookDetailsFragmentArrayList;
    String[] title;
    final static String TITLE_KEY = "title";
    Context parent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookDetailsFragmentArrayList = new ArrayList<>();
        Bundle bundle = getArguments();

        if(bundle != null){
            title = bundle.getStringArray(TITLE_KEY);
        }

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        parent = context;
    }

    public static ViewPagerFragment newInstance (String[] title){
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();

        Bundle bundle = new Bundle();


        bundle.putStringArray(TITLE_KEY,title);
        viewPagerFragment.setArguments(bundle);

        return viewPagerFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_view_pager, container,false);





        //
        for(int i = 0; i<title.length; i++){

            BookDetailsFragment bookFragment = BookDetailsFragment.newInstance(title[i]);
            bookDetailsFragmentArrayList.add(bookFragment);
        }
        //gets the reference to the view pager
        ViewPager viewPager = view.findViewById(R.id.viewPager2);
        viewPager.setAdapter(new MyFragmentAdapter(getFragmentManager()));

       return view;

    }

    public class MyFragmentAdapter extends FragmentStatePagerAdapter{

        public MyFragmentAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            return bookDetailsFragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return bookDetailsFragmentArrayList.size();
        }
    }
}
