package com.acaroom.tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabItem Home, Match, MatchCall, Setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab);

        replaceFragment(new HomeFragment());

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getPosition() == 0) {
                replaceFragment(new HomeFragment());
            } else if (tab.getPosition() == 1) {
                replaceFragment(new MatchFragment());
            } else if (tab.getPosition() == 2) {
                replaceFragment(new MatchCallFragment());
            } else {
                replaceFragment(new SettingFragment());
            }
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
            }

        @Override
        public void onTabReselected(TabLayout.Tab tab){

            }
    });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frLayout, fragment).commit();
    }
}
