package com.acaroom.tab;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class appPermitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_permit);

        Switch adSwt = (Switch)findViewById(R.id.adpermitSwt);
        Switch gpsSwt = (Switch)findViewById(R.id.gpspermitSwt);

        adSwt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(getApplicationContext(), "정보 수신을 동의하셨습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "정보 수신을 거부하셨습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        gpsSwt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    Toast.makeText(getApplicationContext(), "정보 수신을 동의하셨습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "정보 수신을 거부하셨습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
