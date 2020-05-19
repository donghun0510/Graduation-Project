package com.acaroom.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.material.tabs.TabLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class match_settingFragment extends Fragment {

    public match_settingFragment() {
        // Required empty public constructor
    }

    Button btn_set;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matchsetting, container,false);

        btn_set = (Button) view.findViewById(R.id.btn_set);

        btn_set.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "매치 설정을 완료하였습니다.", Toast.LENGTH_SHORT).show();
        });
        return view;
    }
}
