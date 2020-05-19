package com.acaroom.tab;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.HttpResponse;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import static java.lang.System.in;


/**
 * A simple {@link Fragment} subclass.
 */
public class SettingFragment extends Fragment {

    private TextView accountset, withdrawal, logout, appAsk, appNotice, appConst, appPersonal, appPermit;
    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, null);

        accountset = (TextView) view.findViewById(R.id.accountset);
        withdrawal = (TextView) view.findViewById(R.id.withdrawal);
        logout = (TextView) view.findViewById(R.id.logout);
        appAsk = (TextView) view.findViewById(R.id.appAsk);
        appNotice = (TextView) view.findViewById(R.id.appNotice);
        appConst = (TextView) view.findViewById(R.id.appConst);
        appPersonal = (TextView) view.findViewById(R.id.appPersonal);
        appPermit = (TextView) view.findViewById(R.id.appPermit);

        accountset.setOnClickListener((v) -> {  // 계정 설정 창으로
            Intent intent = new Intent(getActivity(), accountsetActivity.class);
            startActivity(intent);
        });
        withdrawal.setOnClickListener((v) -> {  // 정말 계정 삭제할지 Notification
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("알림");
            builder.setMessage("정말로 계정을 삭제하시겠습니까?");
            builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getActivity(), "회원탈퇴 페이지로 이동합니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getActivity(), withdrawalActivity.class);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getActivity(), "아니오 버튼을 누르셨습니다.", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();

        });
        logout.setOnClickListener((v) -> {// 인텐트로 로그인 창으로 이동
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
            if(logout.toString().equals("로그아웃")) {
                Toast.makeText(getActivity(), "로그아웃 하셨습니다.", Toast.LENGTH_SHORT).show();
                logout.setText("로그아웃");
            }

        });
        appAsk.setOnClickListener((v) -> {  // 문의 창으로 이동
            Intent intent = new Intent(getActivity(), appAskActivity.class);
            startActivity(intent);
        });
        appNotice.setOnClickListener((v) -> {   // 공지사항 창으로 이동
            Intent intent = new Intent(getActivity(), appNoticeActivity.class);
            startActivity(intent);
        });
        appConst.setOnClickListener((v) -> {    // 이용규칙 txt
            Intent intent = new Intent(getActivity(), appConstActivity.class);
            startActivity(intent);
        });
        appPersonal.setOnClickListener((v) -> { // 개인정보 처리방침 txt
            Intent intent = new Intent(getActivity(), appPersonalActivity.class);
            startActivity(intent);
        });
        appPermit.setOnClickListener((v) -> {   // gps 설정 및 개인정보 동의 설정 창으로 이동
            Intent intent = new Intent(getActivity(), appPermitActivity.class);
            startActivity(intent);
        });

        Switch alSwt = (Switch)view.findViewById(R.id.alarmSwt);

        alSwt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(getActivity(), "알람 수신을 동의하셨습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "알람 수신을 거부하셨습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}

