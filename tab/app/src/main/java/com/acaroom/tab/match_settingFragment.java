package com.acaroom.tab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
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
    SeekBar distance_seekbar, skill_seekbar, age_seekbar;
    TextView distText, skillText, ageText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_matchsetting, container,false);

        btn_set = (Button) view.findViewById(R.id.btn_set);

        btn_set.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "매치 설정을 완료하였습니다.", Toast.LENGTH_SHORT).show();
        });

        distance_seekbar = (SeekBar) view.findViewById(R.id.distance_seekbar);
        skill_seekbar = (SeekBar) view.findViewById(R.id.skill_seekbar);
        age_seekbar = (SeekBar) view.findViewById(R.id.age_seekbar);
        distText = (TextView) view.findViewById(R.id.distText);
        skillText = (TextView) view.findViewById(R.id.skillText);
        ageText = (TextView) view.findViewById(R.id.ageText);

        distance_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                distText.setText(Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        skill_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                skillText.setText(Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        age_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ageText.setText(Integer.toString(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        return view;
    }
}
