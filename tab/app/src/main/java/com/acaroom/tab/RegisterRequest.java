package com.acaroom.tab;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://donghun0510.dothome.co.kr/Register.php";
    private Map<String, String>map;
    //private Map<String, String>parameters;

    public RegisterRequest(String userID, String userPassword, String userLocal, String userTeam, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("userID", userID);
        map.put("userPassword", userPassword);
        map.put("userLocal", userLocal);
        map.put("userTeam", userTeam + "");
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}
