package com.example.affirmations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.affirmations.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mActivityBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mActivityBinding.getRoot();
        setContentView(view);

      //  mActivityBinding.viewpager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mActivityBinding.bottomnavigationview.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                     /*   switch (item.getItemId()){
                            case R.id.action_home:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.action_categories:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.action_settings:
                                viewPager.setCurrentItem(2);
                                break;
                        }*/
                     showToastMessage(item.getTitle().toString());
                     return false;
                    }
                }
        );
    }

    public void showToastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public class ViewPagerAdapter extends FragmentPagerAdapter{

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new MyAffirmationsFragment();
                case 1:
                    return new AffirmationCategoriesFragment();
                case 2:
                    return new SettingsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
