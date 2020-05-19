package com.acaroom.tab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;



/**
 * A simple {@link Fragment} subclass.
 */
public class MatchFragment extends Fragment {

    private Fragment f_dist, f_skill, f_reco, f_setting;

    public MatchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_match, container,false);

        TabLayout tabLayout = view.findViewById(R.id.match_tab);

        FragmentManager fragmentManager = getChildFragmentManager();

        f_dist = new distFragment();
        fragmentManager.beginTransaction().replace(R.id.fr_match_Layout, f_dist).commit();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    if(f_dist == null) {
                        f_dist = new distFragment();
                        fragmentManager.beginTransaction().add(R.id.fr_match_Layout, f_dist).commit();
                    }
                    if(f_dist != null) fragmentManager.beginTransaction().show(f_dist).commit();
                    if(f_skill != null) fragmentManager.beginTransaction().hide(f_skill).commit();
                    if(f_reco != null) fragmentManager.beginTransaction().hide(f_reco).commit();
                    if(f_setting != null) fragmentManager.beginTransaction().hide(f_setting).commit();
                } else if (tab.getPosition() == 1) {
                    if(f_skill == null) {
                        f_skill = new skillFragment();
                        fragmentManager.beginTransaction().add(R.id.fr_match_Layout, f_skill).commit();
                    }
                    if(f_dist != null) fragmentManager.beginTransaction().hide(f_dist).commit();
                    if(f_skill != null) fragmentManager.beginTransaction().show(f_skill).commit();
                    if(f_reco != null) fragmentManager.beginTransaction().hide(f_reco).commit();
                    if(f_setting != null) fragmentManager.beginTransaction().hide(f_setting).commit();
                } else if (tab.getPosition() == 2) {
                    if(f_reco == null) {
                        f_reco = new recommandFragment();
                        fragmentManager.beginTransaction().add(R.id.fr_match_Layout, f_reco).commit();
                    }
                    if(f_dist != null) fragmentManager.beginTransaction().hide(f_dist).commit();
                    if(f_skill != null) fragmentManager.beginTransaction().hide(f_skill).commit();
                    if(f_reco != null) fragmentManager.beginTransaction().show(f_reco).commit();
                    if(f_setting != null) fragmentManager.beginTransaction().hide(f_setting).commit();
                } else {
                    if(f_setting == null) {
                        f_setting = new match_settingFragment();
                        fragmentManager.beginTransaction().add(R.id.fr_match_Layout, f_setting).commit();
                    }
                    if(f_dist != null) fragmentManager.beginTransaction().hide(f_dist).commit();
                    if(f_skill != null) fragmentManager.beginTransaction().hide(f_skill).commit();
                    if(f_reco != null) fragmentManager.beginTransaction().hide(f_reco).commit();
                    if(f_setting != null) fragmentManager.beginTransaction().show(f_setting).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab){

            }
        });
        return view;
    }
}
