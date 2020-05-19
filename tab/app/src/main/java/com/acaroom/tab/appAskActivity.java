package com.acaroom.tab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class appAskActivity extends AppCompatActivity {

    private ArrayList<String> mList;
    private ListView mListView;;
    private ArrayAdapter mAdapter;
    Button btn_wri, btn_mod, btn_del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_ask);

        btn_wri = (Button) findViewById(R.id.btn_write);
        btn_mod = (Button) findViewById(R.id.btn_modify);
        btn_del = (Button) findViewById(R.id.btn_del);

        btn_wri.setOnClickListener((v)-> {
            Intent intent = new Intent(getApplicationContext(), app_ask_writeActivity.class);
            startActivity(intent);
        });
        btn_mod.setOnClickListener((v) -> {
            int count, checked;
            count = mAdapter.getCount();

            if (count > 0) {
                // 현재 선택된 아이템의 position 획득.
                checked = mListView.getCheckedItemPosition();

                if (checked > -1 && checked < count) {
                    // 아이템 삭제
                    mList.remove(checked);
                    Toast.makeText(getApplicationContext(), "문의시항 수정 페이지로 이동합니다.", Toast.LENGTH_SHORT).show();

                    // listview 선택 초기화.
                    mListView.clearChoices();

                    // listview 갱신.
                    mAdapter.notifyDataSetChanged();
                }
                else {
                    Toast.makeText(getApplicationContext(), "삭제할 문의사항을 선택해주십시오.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_del.setOnClickListener((v) -> {
                int count, checked;
                count = mAdapter.getCount();

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = mListView.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        // 아이템 삭제
                        mList.remove(checked);
                        Toast.makeText(getApplicationContext(), "문의시항을 삭제하셨습니다.", Toast.LENGTH_SHORT).show();

                        // listview 선택 초기화.
                        mListView.clearChoices();

                        // listview 갱신.
                        mAdapter.notifyDataSetChanged();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "삭제할 문의사항을 선택해주십시오.", Toast.LENGTH_SHORT).show();
                    }
                }
        });
    }
}
