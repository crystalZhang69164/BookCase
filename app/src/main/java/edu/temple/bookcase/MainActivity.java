package edu.temple.bookcase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TableLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Fragment bookListFragment;

        ViewPager pager;
        //ViewPagerAdapter pagerAdapter;
        Boolean singlePane = findViewById(R.id.frame2) == null;

        //gets the array of books from the string.xml file
        String[] books = getResources().getStringArray(R.array.books);
        ViewPagerFragment viewPagerFragment = ViewPagerFragment.newInstance(books);
        BookListFragment bookListFragment = BookListFragment.newInstance(books);
        BookDetailsFragment bookDetailsFragment = new BookDetailsFragment();


        //ArrayList<BookListFragment> bookListFragments;

        //gets reference of book list view
        ListView listView = findViewById(R.id.listViewBooks);

        //gets reference to the viewPager
        ViewPager viewPager = findViewById(R.id.viewPager2);

        //PagerAdapter pagerAdapter1 = new PagerAdapter(getSupportFragmentManager(), viewPager.getChildCount()) {
        //}
        //gets a reference to that fragment
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.frame1);

        if(singlePane){
            if(fragment instanceof BookListFragment){
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }

            getSupportFragmentManager().beginTransaction().add(R.id.frame1, viewPagerFragment).commit();
        }
        else{
            if(fragment instanceof ViewPagerFragment){
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
            }
            //adds the list view of books to the left of the screen in landscape
            getSupportFragmentManager().beginTransaction().add(R.id.frame1, bookListFragment).commit();
            //adds the book details to the right of the screen in landscape (frame 2)
            getSupportFragmentManager().beginTransaction().add(R.id.frame2, bookDetailsFragment).commit();
        }




        //displays the listview in portrait mode with the book titles
        /*
        BookListFragment bookListFragment1 = BookListFragment.newInstance(getResources().getStringArray(R.array.books));

        Bundle bundle = new Bundle();
        bundle.putStringArray("books", books);
        bookListFragment1.setArguments(bundle);

         */

        //getSupportFragmentManager().beginTransaction().add(R.id.layout1, bookListFragment1).commit();



    }

    //@Override
    public void bookSelected(String title){
        //bookDetailsFragment.changeTitle(title);
    }

}
