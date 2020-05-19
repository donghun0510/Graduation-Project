package com.acaroom.tab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class app_ask_writeActivity extends AppCompatActivity {

    Button btn_write, btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_ask_write);

        btn_write = (Button) findViewById(R.id.btn_write);
        btn_cancel = (Button) findViewById(R.id.btn_cancel);

        btn_write.setOnClickListener((v)-> {
            Intent intent = new Intent(getApplicationContext(), appAskActivity.class);
            Toast.makeText(getApplicationContext(), "작성을 완료하였습니다.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
        btn_cancel.setOnClickListener((v)-> {
            Intent intent = new Intent(getApplicationContext(), appAskActivity.class);
            Toast.makeText(getApplicationContext(), "취소 버튼을 누르셨습니다.", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        });
    }
}
