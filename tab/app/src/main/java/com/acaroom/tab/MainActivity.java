package com.acaroom.tab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabItem Home, Match, MatchCall, Setting;
    private Fragment f_home, f_match, f_matchcall, f_set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab);

        FragmentManager fragmentManager = getSupportFragmentManager();

        f_home = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.frLayout, f_home).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            if (tab.getPosition() == 0) {
                if(f_home == null) {
                    f_home = new HomeFragment();
                    fragmentManager.beginTransaction().add(R.id.frLayout, f_home).commit();
                }
                if(f_home != null) fragmentManager.beginTransaction().show(f_home).commit();
                if(f_match != null) fragmentManager.beginTransaction().hide(f_match).commit();
                if(f_matchcall != null) fragmentManager.beginTransaction().hide(f_matchcall).commit();
                if(f_set != null) fragmentManager.beginTransaction().hide(f_set).commit();
            } else if (tab.getPosition() == 1) {
                if(f_match == null) {
                    f_match = new MatchFragment();
                    fragmentManager.beginTransaction().add(R.id.frLayout, f_match).commit();
                }
                if(f_home != null) fragmentManager.beginTransaction().hide(f_home).commit();
                if(f_match != null) fragmentManager.beginTransaction().show(f_match).commit();
                if(f_matchcall != null) fragmentManager.beginTransaction().hide(f_matchcall).commit();
                if(f_set != null) fragmentManager.beginTransaction().hide(f_set).commit();
            } else if (tab.getPosition() == 2) {
                if(f_matchcall == null) {
                    f_matchcall = new MatchCallFragment();
                    fragmentManager.beginTransaction().add(R.id.frLayout, f_matchcall).commit();
                }
                if(f_home != null) fragmentManager.beginTransaction().hide(f_home).commit();
                if(f_match != null) fragmentManager.beginTransaction().hide(f_match).commit();
                if(f_matchcall != null) fragmentManager.beginTransaction().show(f_matchcall).commit();
                if(f_set != null) fragmentManager.beginTransaction().hide(f_set).commit();
            } else {
                if(f_set == null) {
                    f_set = new SettingFragment();
                    fragmentManager.beginTransaction().add(R.id.frLayout, f_set).commit();
                }
                if(f_home != null) fragmentManager.beginTransaction().hide(f_home).commit();
                if(f_match != null) fragmentManager.beginTransaction().hide(f_match).commit();
                if(f_matchcall != null) fragmentManager.beginTransaction().hide(f_matchcall).commit();
                if(f_set != null) fragmentManager.beginTransaction().show(f_set).commit();
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
}
